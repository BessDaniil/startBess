package org.example.demodanya.try2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.w3c.dom.Text;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String biography;

    private Date birthDate;

    public Authors(String name, String biography, Date birthDate) {
        this.name = name;
        this.biography = biography;
        this.birthDate = birthDate;
    }

    public Authors() {
    }
}
