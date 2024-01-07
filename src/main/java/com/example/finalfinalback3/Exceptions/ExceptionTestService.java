package com.example.finalfinalback3.Exceptions;

import com.example.finalfinalback3.Annotation.ExceptionTestHandler;
import com.example.finalfinalback3.Model.ResponseException;
import com.example.finalfinalback3.Model.Token;
import org.springframework.stereotype.Service;

@Service
@ExceptionTestHandler
public class ExceptionTestService {
    public Token e1(Integer exception) throws DataAlreadyExistsException, PasswordsNotSameException {
        if (exception == -1) {
            throw new PasswordsNotSameException("PNS exc");
        }
        if (exception == 1){

            throw new DataAlreadyExistsException("some_exception");
        }
        return new Token("ok");
    }
}
