package com.example.finalfinalback3.DTO;

import com.example.finalfinalback3.Entity.PassportEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DocumentAddDTO {
    private Integer id;

    public DocumentAddDTO(Integer id) {
        this.id = id;
    }
}
