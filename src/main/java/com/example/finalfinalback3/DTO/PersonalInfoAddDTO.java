package com.example.finalfinalback3.DTO;

import com.example.finalfinalback3.Entity.UserEntity;
import com.example.finalfinalback3.Service.UserService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
public class PersonalInfoAddDTO {

    private Integer doc_id;
    private String fullname;
    private String phone_number;

    public PersonalInfoAddDTO(Integer doc_id, String fullname, String phone_number) {
        this.doc_id = doc_id;
        this.fullname = fullname;
        this.phone_number = phone_number;
    }
}
