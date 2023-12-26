package com.example.finalfinalback3.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
//@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDTO {
    private String email;
    private String login;
    private String password;
    private String password_confirm;
    private String role = "USER";

    public UserRegisterDTO(String email, String login, String password, String password_confirm) {
        this.email = email;
        this.login = login;
        this.password = password;
        this.password_confirm = password_confirm;
    }
}
