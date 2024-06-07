package org.example.demodanya.try2.repository;

import org.example.demodanya.try2.models.Authors;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AuthorsRepository {

    Optional<Authors> getAuthorsById(String name);

    void insertAuthors(String name, String biography, Date birthDate);

    void updateAuthors(String biography, Date birthDate, String name);

    void deleteAuthorsById(String name);

}
