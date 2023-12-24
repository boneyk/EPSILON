package com.example.finalfinalback3.Controller;

import com.example.finalfinalback3.DTO.PassportAddDTO;
import com.example.finalfinalback3.DTO.UserRegisterDTO;
import com.example.finalfinalback3.Exceptions.DataAlreadyExistsException;
import com.example.finalfinalback3.Exceptions.DataNotFoundException;
import com.example.finalfinalback3.Exceptions.PasswordsNotSameException;
import com.example.finalfinalback3.Service.DocumentService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private final DocumentService docService;
    private final ModelMapper modelMapper;
    public DocumentController(DocumentService docService, ModelMapper modelMapper) {
        this.docService = docService;
        this.modelMapper = modelMapper;
    }

    @PatchMapping("/add")
    public ResponseEntity addEmptyDocument(@RequestParam String token){
        docService.addDocument(token);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PatchMapping("/passport")
    public ResponseEntity addPassport(@RequestBody PassportAddDTO passport,
                                      @RequestParam String token) throws DataNotFoundException {
        try {
            docService.addPassport(passport, token);
            return new ResponseEntity(HttpStatus.CREATED);
        }
        catch (DataNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity showDocuments(@RequestParam String token) {
        try {
            return new ResponseEntity(docService.showDocuments(token), HttpStatus.OK);
        } catch (DataNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
