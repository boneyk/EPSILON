package com.example.finalfinalback3.DTO;

import com.example.finalfinalback3.Entity.TourEntity;
import com.example.finalfinalback3.Entity.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDetailsDTO {
    private TourEntity tour;
    private UserEntity user;

    public OrderDetailsDTO(TourEntity tour, UserEntity user) {
        this.tour = tour;
        this.user = user;
    }
}
