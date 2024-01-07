package com.example.finalfinalback3.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class DocumentEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String token;
    private String fullname;
    private String phone_number;
    private String sex;
    //@JsonProperty("date_of_birth")
    private LocalDate dob;


    @OneToOne(cascade = CascadeType.ALL)
    private PassportEntity passport;

    @ManyToOne
    //@MapsId
    @JsonIgnore
    private UserEntity user;

    public DocumentEntity(Integer id, PassportEntity passport) {
        this.id = id;
        this.passport = passport;
    }
}
