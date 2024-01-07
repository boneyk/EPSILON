package com.example.finalfinalback3.Advice;

import com.example.finalfinalback3.Annotation.ExceptionTestHandler;
import com.example.finalfinalback3.Exceptions.DataAlreadyExistsException;
import com.example.finalfinalback3.Exceptions.DataNotFoundException;
import com.example.finalfinalback3.Exceptions.PasswordsNotSameException;
import com.example.finalfinalback3.Model.ResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(annotations = ExceptionTestHandler.class)
public class ExceptionTestAdvice {

    @ExceptionHandler({
            DataAlreadyExistsException.class,
            PasswordsNotSameException.class,
            DataNotFoundException.class
    })
    public ResponseEntity handleException(Exception e){
        System.out.println("YOU ARE IN EXCEPTION_TEST_ADVICE");
        ResponseException response = new ResponseException("TEST_EXCEPTION:" + e.getMessage());
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }
}
