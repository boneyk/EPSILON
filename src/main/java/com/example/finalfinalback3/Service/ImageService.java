package com.example.finalfinalback3.Service;

import com.example.finalfinalback3.DTO.ImageAddDTO;
import com.example.finalfinalback3.Entity.ImageEntity;
import com.example.finalfinalback3.Exceptions.DataAlreadyExistsException;
import com.example.finalfinalback3.Exceptions.DataNotFoundException;
import com.example.finalfinalback3.Repository.ImageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageService {

    private final ModelMapper modelMapper;
    private final ImageRepository imageRepo;

    public ImageService(ModelMapper modelMapper, ImageRepository imageRepository) {
        this.modelMapper = modelMapper;
        this.imageRepo = imageRepository;
    }

    public ImageEntity getImageById(Integer id) throws DataNotFoundException{
        Optional<ImageEntity> image = imageRepo.findById(id);
        if (image.isEmpty()){
            throw new DataNotFoundException("Такого изображения не найдено");
        }
        return image.get();
    }

    public ImageEntity addImage(ImageAddDTO image) throws DataAlreadyExistsException {
        if (imageRepo.findByFilename(image.getFilename()) != null){
            throw new DataAlreadyExistsException("Изображение с таким названием уже в базе данных!");
        }
        return imageRepo.save(modelMapper.map(image, ImageEntity.class));
    }



}
