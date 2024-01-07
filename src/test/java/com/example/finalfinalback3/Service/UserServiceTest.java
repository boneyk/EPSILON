package com.example.finalfinalback3.Service;

import com.example.finalfinalback3.Entity.UserEntity;
import com.example.finalfinalback3.Exceptions.DataNotFoundException;
import com.example.finalfinalback3.Repository.UserRepository;
import org.apache.catalina.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepo;
    @Mock
    private ModelMapper modelMapper;

    @Test
    void getUserById_invalidId_throwException(){
        Integer testId = 99999;
        Assertions.assertThrows(DataNotFoundException.class, () -> userService.getUserById(testId));
    }

    @Test
    @Disabled
    void getUserById_validId_getUser(){
        userRepo.save(new UserEntity());
        Integer testId = 1;
        userService.getUserById(testId);
        Mockito.verify(userService, times(1)).getUserById(testId);
    }
}
