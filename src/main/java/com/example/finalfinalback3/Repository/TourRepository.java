package com.example.finalfinalback3.Repository;

import com.example.finalfinalback3.Entity.TourEntity;
import com.example.finalfinalback3.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TourRepository extends CrudRepository<TourEntity, Integer> {

    TourEntity findByName(String name);
    List<TourEntity> findAllByCountryAndCapacityIsGreaterThanEqual(
            String country,
            Integer amount
    );

    List<TourEntity> findAllByFavorites(UserEntity user);
    List<TourEntity> findAllByHistory(UserEntity user);
}
