package com.example.finalfinalback3.Repository;

import com.example.finalfinalback3.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity findByLogin(String login);
    UserEntity findByToken(String token);
}
