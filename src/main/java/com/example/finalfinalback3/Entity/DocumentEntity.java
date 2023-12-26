package com.example.finalfinalback3.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class DocumentEntity {
    @Id
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    private PassportEntity passport;

    @OneToOne
    @MapsId
    @JsonIgnore
    private UserEntity user;

    public DocumentEntity(Integer id, PassportEntity passport) {
        this.id = id;
        this.passport = passport;
    }
}
