package com.example.finalfinalback3.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class ImageEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String filename;
    private String path;
    private String alt;
    private String size;
    private String content_type;

    @JsonIgnore
    @ManyToMany(mappedBy = "images")
    private Set<TourEntity> tours = new HashSet<>();
}
