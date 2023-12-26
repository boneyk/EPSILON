package com.example.finalfinalback3.DTO;

import com.example.finalfinalback3.Entity.ImageEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TourHistoryDTO {
    private Integer id;
    private String country;
    private String city;
    private String tour_type;
    private Integer price_per_one;
    private List<ImageEntity> images;

    public TourHistoryDTO(Integer tour_id, String country, String city, String tour_type, Integer price_per_one, List<ImageEntity> images) {
        this.id = tour_id;
        this.country = country;
        this.city = city;
        this.tour_type = tour_type;
        this.price_per_one = price_per_one;
        this.images = images;
    }
}
