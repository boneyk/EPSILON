package com.example.finalfinalback3.Repository;

import com.example.finalfinalback3.Entity.DocumentEntity;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<DocumentEntity, Integer> {
    DocumentEntity findByToken(String token);
}
