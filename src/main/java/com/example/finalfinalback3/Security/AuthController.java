package com.example.finalfinalback3.Security;

import com.example.finalfinalback3.DTO.UserAuthDTO;
import com.example.finalfinalback3.DTO.UserRegisterDTO;
import com.example.finalfinalback3.Exceptions.DataAlreadyExistsException;
import com.example.finalfinalback3.Exceptions.DataNotFoundException;
import com.example.finalfinalback3.Exceptions.PasswordsNotSameException;
import com.example.finalfinalback3.Model.Token;
import com.example.finalfinalback3.Service.TourService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final TourService tourService;
    public AuthController(AuthService authService, TourService tourService) {
        this.authService = authService;
        this.tourService = tourService;
    }


    //@ExceptionHandler({DataAlreadyExistsException.class, PasswordsNotSameException.class})
    @PostMapping("/reg")
    public ResponseEntity registration(@RequestBody UserRegisterDTO user) throws DataAlreadyExistsException, PasswordsNotSameException {
        return new ResponseEntity(authService.registration(user),HttpStatus.CREATED);
    }

    @PostMapping("/logout")
    public ResponseEntity logout(){
        return null;
    }

    @PostMapping

    public ResponseEntity authUser(@RequestBody UserAuthDTO user,
                                   @RequestHeader Map<String, String> headers){
        try{
            Token user_token = authService.authUser(user, headers);
            System.out.println(headers);
            return new ResponseEntity(user_token, HttpStatus.OK);
        }
        catch (DataNotFoundException | PasswordsNotSameException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
