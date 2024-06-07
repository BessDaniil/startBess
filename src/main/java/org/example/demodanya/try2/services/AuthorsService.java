package org.example.demodanya.try2.services;

import org.example.demodanya.try2.models.Authors;

import java.util.Date;
import java.util.List;

public interface AuthorsService {
    List<Authors> getAuthors (String name);

    void createAuthors (String name, String biography, Date birthDate);

    Authors getAuthorById(int id);

//    public void updateAuthors (String biography, Date birthDate, String name);
//
//    public void deleteAuthors (String name);
}
