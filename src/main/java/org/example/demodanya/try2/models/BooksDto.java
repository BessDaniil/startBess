package org.example.demodanya.try2.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Value;

@Data
public class BooksDto {
    private int id;
    private String title;
    private String genre;
    private int authorId;

    public BooksDto(int id, String title, String genre, int authorId) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.authorId = authorId;
    }
}