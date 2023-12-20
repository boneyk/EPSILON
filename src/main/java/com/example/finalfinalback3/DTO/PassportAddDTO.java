package com.example.finalfinalback3.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PassportAddDTO {
    private String fullname;
    private String sex;
    //@JsonProperty("date_of_birth")
    private LocalDate dob; //Date of birth
    private String citizenship;
    private String serial;
    private String number;
    //@JsonProperty("date_of_given")
    private LocalDate dog; // Date of given
    //@JsonProperty("who_gave")
    private String wg; // who_gave
    private String registration;

    public PassportAddDTO(String fullname, String sex, LocalDate dob, String citizenship, String serial, String number, LocalDate dog, String wg, String registration) {
        this.fullname = fullname;
        this.sex = sex;
        this.dob = dob;
        this.citizenship = citizenship;
        this.serial = serial;
        this.number = number;
        this.dog = dog;
        this.wg = wg;
        this.registration = registration;
    }
}
