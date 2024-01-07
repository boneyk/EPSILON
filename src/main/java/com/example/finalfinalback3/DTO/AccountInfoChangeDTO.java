package com.example.finalfinalback3.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountInfoChangeDTO {
    private String email;
    private String login;
    private String password;
}
