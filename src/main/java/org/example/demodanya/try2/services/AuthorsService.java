package org.example.demodanya.try2.services;

import org.example.demodanya.try2.models.Authors;
import org.example.demodanya.try2.models.FullAuthorInfoProjection;

import java.util.Date;
import java.util.List;

public interface AuthorsService {
    List<Authors> getAuthors (String name);

    void createAuthors (String name, String biography, Date birthDate);

    void updateAuthors (String name, String biography, Date birthDate, int id);

    void deleteAuthors (int id);

    Authors getAuthorById(int id);

    List<FullAuthorInfoProjection> getAuthorByPublisher(String name);
}
