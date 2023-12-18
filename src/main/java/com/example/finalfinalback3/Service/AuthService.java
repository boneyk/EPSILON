package com.example.finalfinalback3.Service;

import com.example.finalfinalback3.DTO.UserAuthDTO;
import com.example.finalfinalback3.DTO.UserRegisterDTO;
import com.example.finalfinalback3.Entity.UserEntity;
import com.example.finalfinalback3.Exceptions.DataAlreadyExistsException;
import com.example.finalfinalback3.Exceptions.DataNotFoundException;
import com.example.finalfinalback3.Exceptions.PasswordsNotSameException;
import com.example.finalfinalback3.Repository.AuthRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    
    private final AuthRepository authRepo;
    private final ModelMapper modelMapper;
    public AuthService(AuthRepository authRepo, ModelMapper modelMapper) {
        this.authRepo = authRepo;
        this.modelMapper = modelMapper;
    }

    public Integer authUser(UserAuthDTO user) throws DataNotFoundException,
            PasswordsNotSameException {
        UserEntity find_user = authRepo.findByLogin(user.getLogin());
        if (find_user == null){
            throw new DataNotFoundException("Такого пользователя не существует!");
        }
        if (!find_user.getPassword().equals(user.getPassword())){
            throw new PasswordsNotSameException("Неверный пароль!");
        }
        return find_user.getId();
    }

    public Integer registration(UserRegisterDTO user) throws DataAlreadyExistsException,
            PasswordsNotSameException {
        UserEntity find_user = authRepo.findByLogin(user.getLogin());
        if (find_user != null) {
            throw new DataAlreadyExistsException("Пользователь с таким логином уже существует!");
        }
        if (!user.getPassword().equals(user.getPassword_confirm())){
            throw new PasswordsNotSameException("Пароли не совпадают");
        }
        UserEntity new_user = authRepo.save(modelMapper.map(user, UserEntity.class));
        return new_user.getId();
    }

}
