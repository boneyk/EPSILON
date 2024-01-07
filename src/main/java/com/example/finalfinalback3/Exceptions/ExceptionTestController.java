package com.example.finalfinalback3.Exceptions;

import com.example.finalfinalback3.Annotation.ExceptionTestHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/exceptions")
@ExceptionTestHandler
public class ExceptionTestController {
    private final ExceptionTestService eService;

    public ExceptionTestController(ExceptionTestService eService) {
        this.eService = eService;
    }

    //@ExceptionHandler({DataAlreadyExistsException.class, PasswordsNotSameException.class})
    @PostMapping("/e1")
    public ResponseEntity e1(@RequestParam(required = false, defaultValue = "0") Integer exception)
            throws DataAlreadyExistsException, PasswordsNotSameException {
        return new ResponseEntity(eService.e1(exception), HttpStatus.OK);
    }

}
