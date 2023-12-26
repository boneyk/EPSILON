package com.example.finalfinalback3.Exceptions;

import javax.naming.AuthenticationException;

public class PasswordsNotSameException extends AuthenticationException {
    public PasswordsNotSameException(String message) {
        super(message);
    }
}
