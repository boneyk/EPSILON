package com.example.finalfinalback3.Entity;

import com.example.finalfinalback3.DTO.PassportAddDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class PassportEntity {
    @Id
    private Integer id;
    private String fullname;
    private String sex;
    @JsonProperty("date_of_birth")
    private LocalDate dob; //Date of birth
    private String citizenship;
    private String serial;
    private String number;
    @JsonProperty("date_of_given")
    private LocalDate dog; // Date of given
    @JsonProperty("who_gave")
    private String wg; // who_gave
    private String registration;

    @OneToOne
    @MapsId
    @JsonIgnore
    private DocumentEntity doc;


    public PassportEntity(PassportAddDTO passport) {
        this.fullname = passport.getFullname();
        this.sex = passport.getSex();
        this.dob = passport.getDob();
        this.citizenship = passport.getCitizenship();
        this.serial = passport.getSerial();
        this.number = passport.getNumber();
        this.dog = passport.getDog();
        this.wg = passport.getWg();
        this.registration = passport.getRegistration();
    }
}
