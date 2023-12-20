package com.example.finalfinalback3.Service;

import com.example.finalfinalback3.DTO.PassportAddDTO;
import com.example.finalfinalback3.Entity.DocumentEntity;
import com.example.finalfinalback3.Entity.PassportEntity;
import com.example.finalfinalback3.Entity.UserEntity;
import com.example.finalfinalback3.Exceptions.DataNotFoundException;
import com.example.finalfinalback3.Repository.DocumentRepository;
import com.example.finalfinalback3.Repository.PassportRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {
    private final DocumentRepository docRepo;
    private final PassportRepository passportRepo;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public DocumentService(DocumentRepository docRepo, PassportRepository passportRepo, UserService userService, ModelMapper modelMapper) {
        this.docRepo = docRepo;
        this.passportRepo = passportRepo;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    public DocumentEntity getDocumentById(Integer id) throws DataNotFoundException{
        if (docRepo.findById(id).isEmpty()){
            throw new DataNotFoundException("Документов не найдено");
        }
        return docRepo.findById(id).get();
    }

    public DocumentEntity addDocument(Integer user_id) throws DataNotFoundException{
        UserEntity user = userService.getUserById(user_id);
        DocumentEntity empty_doc = new DocumentEntity();
        //DocumentEntity new_doc = modelMapper.map(empty_doc, DocumentEntity.class);
        empty_doc.setUser(user);
        DocumentEntity doc = docRepo.save(empty_doc);
        user.setDoc(doc);
        empty_doc.setId(user_id);
        userService.saveUser(user);
        return doc;
    }
    public PassportEntity addPassport(PassportAddDTO passport, Integer user_id) throws DataNotFoundException{
        UserEntity user = userService.getUserById(user_id);
        DocumentEntity doc = user.getDoc();
        if (doc == null){
            doc = addDocument(user_id);
        }
        PassportEntity new_passport = new PassportEntity(passport);//modelMapper.map(passport, PassportEntity.class);
        new_passport.setDoc(doc);
        PassportEntity new_passport_entity = passportRepo.save(new_passport);
        doc.setPassport(new_passport_entity);
        docRepo.save(doc);
        //userService.saveUser(user);
        return new_passport_entity;
    }

    public DocumentEntity showDocuments(Integer user_id) throws DataNotFoundException{
        UserEntity user = userService.getUserById(user_id);
        DocumentEntity doc = user.getDoc();
        if (doc == null){
            throw new DataNotFoundException("Документов пока нет!");
        }
        return doc;
    }
}
