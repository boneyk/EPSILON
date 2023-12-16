package com.example.finalfinalback3.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class TourEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String country;
    private String city;
    private LocalDate date_start;
    private LocalDate date_end;
    private String tour_type;
    private Integer capacity;
    private Integer price_per_one;
    private String description;

    @ManyToMany
    @JoinTable(name="tour_image",
            joinColumns = @JoinColumn(name = "tour_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id")
    )
    private List<ImageEntity> images;

    @JsonIgnore
    @ManyToMany(mappedBy = "favorites")
    private List<UserEntity> favorites;

}
