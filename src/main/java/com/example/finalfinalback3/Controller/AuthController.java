package com.example.finalfinalback3.Controller;

import com.example.finalfinalback3.DTO.TourMainDTO;
import com.example.finalfinalback3.DTO.UserAuthDTO;
import com.example.finalfinalback3.DTO.UserRegisterDTO;
import com.example.finalfinalback3.Exceptions.DataAlreadyExistsException;
import com.example.finalfinalback3.Exceptions.DataNotFoundException;
import com.example.finalfinalback3.Exceptions.PasswordsNotSameException;
import com.example.finalfinalback3.Service.AuthService;
import com.example.finalfinalback3.Service.TourService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/reg")
    public ResponseEntity registration(@RequestBody UserRegisterDTO user) {
        try {
            //List<TourMainDTO> tour_list = tourService.showAll();
            return new ResponseEntity(authService.registration(user),HttpStatus.CREATED);
        } catch (DataAlreadyExistsException | PasswordsNotSameException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity logout(){
        return null;
    }

    @PostMapping
    public ResponseEntity authUser(@RequestBody UserAuthDTO user){
        try{
            return new ResponseEntity(authService.authUser(user), HttpStatus.OK);
        }
        catch (DataNotFoundException | PasswordsNotSameException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
