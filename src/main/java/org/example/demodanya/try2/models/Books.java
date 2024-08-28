package org.example.demodanya.try2.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.*;

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
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createDate;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updateDate;

    @ManyToMany
    @JoinTable(
            name = "book_caterories",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Categories> categories = new ArrayList<>();

    public Books(String title, String genre, int authorId) {
        this.title = title;
        this.genre = genre;
        this.authorId = authorId;
    }

    public Books(){}

    @Override
    public String toString(){
        return "Books [id=" + id + ", title=" + title + ", genre=" + genre + ", authorId=" + authorId + "]";
    }
}
