package com.example.finalfinalback3.Service;

import com.example.finalfinalback3.DTO.PersonalInfoAddDTO;
import com.example.finalfinalback3.Entity.PersonalInfoEntity;
import com.example.finalfinalback3.Entity.UserEntity;
import com.example.finalfinalback3.Exceptions.DataAlreadyExistsException;
import com.example.finalfinalback3.Exceptions.DataNotFoundException;
import com.example.finalfinalback3.Repository.PersonalInfoRepository;
import com.example.finalfinalback3.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepo;
    private final PersonalInfoRepository infoRepo;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepo, PersonalInfoRepository infoRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.infoRepo = infoRepo;
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

    public PersonalInfoEntity addPersonalInfo(PersonalInfoAddDTO info) throws DataAlreadyExistsException{
        //Optional<PersonalInfoEntity> find_info = infoRepo.findById(info.getId());
        //if (find_info.isPresent()) {
        //    throw new DataAlreadyExistsException("О пользователе уже есть личная информация!");
        //}
        return infoRepo.save(modelMapper.map(info, PersonalInfoEntity.class));
    }

    public void saveUser(UserEntity user) {
        userRepo.save(user);
    }
}

