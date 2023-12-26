package com.example.finalfinalback3.DTO;

import com.example.finalfinalback3.Entity.ImageEntity;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class TourMainDTO {
    private Integer id;
    private String name;
    private Integer price_per_one;
    private String tour_type;
    private List<ImageEntity> images;
}
