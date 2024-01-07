package com.example.finalfinalback3.Controller;

import com.example.finalfinalback3.DTO.PassportAddDTO;
import com.example.finalfinalback3.DTO.UserRegisterDTO;
import com.example.finalfinalback3.Entity.DocumentEntity;
import com.example.finalfinalback3.Exceptions.DataAlreadyExistsException;
import com.example.finalfinalback3.Exceptions.DataNotFoundException;
import com.example.finalfinalback3.Exceptions.PasswordsNotSameException;
import com.example.finalfinalback3.Model.DocPersonalInfo;
import com.example.finalfinalback3.Service.DocumentService;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PatchMapping("/add")//TODO подумать над тем, чтобы возвращать токен документа
    public ResponseEntity addEmptyDocument(@RequestParam String token){
        return new ResponseEntity(docService.addDocument(token), HttpStatus.CREATED);
    }

    @PostMapping("/passport")
    public ResponseEntity addPassport(@RequestBody PassportAddDTO passport,
                                      @RequestParam String doc_token)
            throws DataNotFoundException,
            DataAlreadyExistsException{
        try {
            docService.addPassport(passport, doc_token);
            return new ResponseEntity(HttpStatus.CREATED);
        }
        catch (DataNotFoundException | DataAlreadyExistsException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/passport")
    public ResponseEntity changePassport(@RequestBody PassportAddDTO passport,
                                         @RequestParam String doc_token) throws DataNotFoundException {
        try {
            return new ResponseEntity(docService.changePassport(passport, doc_token), HttpStatus.CREATED);
        }
        catch (DataNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping()//token - токен пользователя
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

    @GetMapping("/person")
    public ResponseEntity showPersonDocuments(@RequestParam String doc_token) {
        try {
            return new ResponseEntity(docService.showPersonDocuments(doc_token), HttpStatus.OK);
        } catch (DataNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping()
    public ResponseEntity deletePersonDocuments(@RequestParam String doc_token,
                                                @RequestParam String token) {
        try {
            return new ResponseEntity(docService.deletePersonDocument(doc_token, token), HttpStatus.OK);
        } catch (DataNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
