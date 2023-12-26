package com.example.finalfinalback3.Exceptions;

import jakarta.persistence.EntityNotFoundException;

public class DataNotFoundException extends EntityNotFoundException {
    public DataNotFoundException(String message) {
        super(message);
    }
}
