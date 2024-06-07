package org.example.demodanya.try2.services;

import org.example.demodanya.try2.models.Authors;

import java.util.Date;

public interface AuthorsService {
    Authors getAuthors (String name);

    public void createAuthors (String name, String biography, Date birthDate);

    public void updateAuthors (String biography, Date birthDate, String name);

    public void deleteAuthors (String name);
}
