package com.example.finalfinalback3.Security;
import com.example.finalfinalback3.DTO.UserAuthDTO;
import com.example.finalfinalback3.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface AuthRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findByLogin(String login);

}
