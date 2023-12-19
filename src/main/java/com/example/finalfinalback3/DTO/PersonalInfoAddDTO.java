package com.example.finalfinalback3.DTO;

import com.example.finalfinalback3.Entity.UserEntity;
import com.example.finalfinalback3.Service.UserService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
public class PersonalInfoAddDTO {

    private String fullname;
    private String phone_number;

    public PersonalInfoAddDTO(String fullname, String phone_number) {
        this.fullname = fullname;
        this.phone_number = phone_number;
    }
}
