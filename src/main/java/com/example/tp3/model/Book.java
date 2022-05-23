package com.example.tp3.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book extends Document {

    private int nbPages;

    @Builder
    public Book(long id, String title, int publicationYear, String author,
                String editor, String category, int nbPages, String documentType,
                int quantity, long borrowTimePeriod) {
        super(id, title, publicationYear, author, editor, category, documentType, quantity, borrowTimePeriod);
        this.nbPages = nbPages;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\t\t" + "Number of Pages : " + nbPages + "\n";
    }
}

