package com.example.finalfinalback3.Repository;

import com.example.finalfinalback3.Entity.ImageEntity;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<ImageEntity, Integer> {
    ImageEntity findByFilename(String filename);
}
