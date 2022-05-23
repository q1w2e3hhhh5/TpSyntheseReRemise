package com.example.tp3.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @ToString.Exclude
    private Client client;

    private LocalDateTime localDateTimeOfBorrow;
    private LocalDateTime localDateTimeOfReturn;

    public Borrow(Document documentById, Client client) {
        this.document = documentById;
        this.localDateTimeOfBorrow = LocalDateTime.now();
        if (document.getDocumentType().equals("Book")) {
            this.localDateTimeOfReturn = LocalDateTime.now().plusWeeks(3);
        } else if (document.getDocumentType().equals("Cd")) {
            this.localDateTimeOfReturn = LocalDateTime.now().plusWeeks(2);
        } else if (document.getDocumentType().equals("Dvd")) {
            this.localDateTimeOfReturn = LocalDateTime.now().plusWeeks(1);
        }
        this.client = client;
    }
}
