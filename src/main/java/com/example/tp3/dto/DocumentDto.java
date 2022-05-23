package com.example.tp3.dto;

import lombok.Data;

@Data
public class DocumentDto {

    private long id;
    private String title;
    private int publicationYear;
    private String author;
    private String editor;
    private String category;
    private String documentType;
    private int quantity;
    private long borrowTimePeriod;

}
