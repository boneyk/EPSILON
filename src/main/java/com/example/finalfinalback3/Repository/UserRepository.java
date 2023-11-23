package com.example.finalfinalback3.Repository;

import com.example.finalfinalback3.Entity.UserEntity;
import com.example.finalfinalback3.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity findByLogin(String login);
}
