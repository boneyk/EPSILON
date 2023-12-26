package com.example.finalfinalback3.Service;

import com.example.finalfinalback3.DTO.PersonalInfoAddDTO;
import com.example.finalfinalback3.DTO.PersonalInfoMainDTO;
import com.example.finalfinalback3.Entity.UserEntity;
import com.example.finalfinalback3.Exceptions.DataNotFoundException;
import com.example.finalfinalback3.Repository.UserRepository;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepo;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }


    //Спросить насчёт использования Optional
    public UserEntity getUserById(Integer id) throws DataNotFoundException {
        Optional<UserEntity> user = userRepo.findById(id);
        if (user.isEmpty()) {
            throw new DataNotFoundException("Пользователя с таким id не существует!");
        }
        return user.get();
    }

    public UserEntity getUserByToken(String token) throws DataNotFoundException {
        Optional<UserEntity> user = Optional.ofNullable(userRepo.findByToken(token));
        if (user.isEmpty()) {
            throw new DataNotFoundException("Пользователь с таким токеном не авторизован!");
        }
        return user.get();
    }

    public List<UserEntity> showAll() throws DataNotFoundException{
        if (userRepo.findAll() == null){
            throw new DataNotFoundException("Нет пользователей в базе данных...");
        }
        return (List<UserEntity>) userRepo.findAll();
    }

    public Integer deleteUser(Integer id) throws DataNotFoundException {
        if (userRepo.findById(id) == null) {
            throw new DataNotFoundException("Нет пользователя с таким id!");
        }
        userRepo.deleteById(id);
        return id;
    }
    public void saveUser(UserEntity user) {
        userRepo.save(user);
    }

    //Прости, Господь, за это
    public UserEntity addPersonalInfo(PersonalInfoAddDTO info, String token) throws DataNotFoundException{
        UserEntity user = getUserByToken(token);
        user.setFullname(info.getFullname());
        user.setPhone_number(info.getPhone_number());
        return userRepo.save(user);
    }

    public PersonalInfoMainDTO showPersonalInfo(String token) throws DataNotFoundException{
        UserEntity user = getUserByToken(token);
        return modelMapper.map(user, PersonalInfoMainDTO.class);
    }

    public UserEntity setUserRoleAdmin(Integer id) throws DataNotFoundException{
        UserEntity user = getUserById(id);
        user.setRole("ADMIN");
        return userRepo.save(user);
    }
}

