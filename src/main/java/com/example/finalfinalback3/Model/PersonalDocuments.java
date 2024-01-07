package com.example.finalfinalback3.Model;

import com.example.finalfinalback3.Entity.PassportEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PersonalDocuments {
    private String token;
    private String fullname;
    private String phone_number;
    private String sex;
    @JsonProperty("date_of_birth")
    private LocalDate dob;
    private PassportEntity passport;
}
