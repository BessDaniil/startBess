package org.example.demodanya.try2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String genre;

    private int authorId;


    public Books(String title, String genre, int authorId) {
        this.title = title;
        this.genre = genre;
        this.authorId = authorId;
    }

    public Books(){

    }
}
