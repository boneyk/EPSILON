package com.example.finalfinalback3.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Token {
    private String Token;

    public Token(String token) {
        Token = token;
    }
}
