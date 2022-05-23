package com.example.tp3.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClientDto {

    private long id;
    private String email;
    private String password;
    private String fullName;
    private int fee;

    List<BorrowDto> borrows = new ArrayList<>();

    public void addBorrow(BorrowDto borrow) {
        borrows.add(borrow);
    }
}
