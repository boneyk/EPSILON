package com.example.finalfinalback3.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ImageAddDTO {
    private String filename;
    private String path;
    private String alt;
    private String size;
    private String content_type;

    public ImageAddDTO(String filename, String path, String alt, String size, String content_type) {
        this.filename = filename;
        this.path = path;
        this.alt = alt;
        this.size = size;
        this.content_type = content_type;
    }
}
