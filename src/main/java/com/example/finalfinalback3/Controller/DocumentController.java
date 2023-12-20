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
    public ResponseEntity addEmptyDocument(@RequestParam Integer user_id){
        docService.addDocument(user_id);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PatchMapping("/passport")
    public ResponseEntity addPassport(@RequestBody PassportAddDTO passport,
                                      @RequestParam Integer user_id) {
        docService.addPassport(passport, user_id);
        return new ResponseEntity(HttpStatus.CREATED);
//        try {
//            docService.addPassport(passport, user_id);
//            return new ResponseEntity(HttpStatus.CREATED);
//        } catch (DataAlreadyExistsException e) {
//            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {
//            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }

    @GetMapping()
    public ResponseEntity showDocuments(@RequestParam Integer user_id) {
        try {
            return new ResponseEntity(docService.showDocuments(user_id), HttpStatus.OK);
        } catch (DataNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
