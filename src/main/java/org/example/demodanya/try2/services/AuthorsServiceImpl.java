package org.example.demodanya.try2.services;

import org.example.demodanya.try2.controllers.AuthorsNotFoundException;
import org.example.demodanya.try2.models.Authors;
import org.example.demodanya.try2.repository.AuthorsRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Date;

//@Primary
@Service
public class AuthorsServiceImpl implements AuthorsService {
    private final AuthorsRepository authorsRepository;

    public AuthorsServiceImpl(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    @Override
    public Authors getAuthors(String name){
        return authorsRepository.getAuthorsById(name).orElseThrow(() -> new AuthorsNotFoundException(name));
    }
    @Override
    public void createAuthors(String name, String biography, Date birthDate){
        authorsRepository.insertAuthors(name, biography, birthDate);
    }
    @Override
    public void updateAuthors(String biography, Date birthDate, String name){
        var authors = authorsRepository.getAuthorsById(name).orElseThrow(() -> new AuthorsNotFoundException(name));
        authorsRepository.updateAuthors(biography, birthDate, authors.name());
    }
    @Override
    public void deleteAuthors(String name){
        var authors = authorsRepository.getAuthorsById(name).orElseThrow(() -> new AuthorsNotFoundException(name));
        authorsRepository.deleteAuthorsById(authors.name());
    }

}
