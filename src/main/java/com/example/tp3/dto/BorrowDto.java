package com.example.tp3.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BorrowDto {
    private long id;
    private DocumentDto documentDto;
    private ClientDto clientDto;
    private LocalDateTime localDateTimeOfBorrow;
    private LocalDateTime localDateTimeOfReturn;

}
