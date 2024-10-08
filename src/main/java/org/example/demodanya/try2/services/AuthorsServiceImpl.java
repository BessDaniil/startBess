package org.example.demodanya.try2.services;


import org.example.demodanya.try2.models.Authors;
import org.example.demodanya.try2.models.FullAuthorInfoProjection;
import org.example.demodanya.try2.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorsServiceImpl implements AuthorsService {

    private final AuthorRepository authorsRepository;

    public AuthorsServiceImpl(AuthorRepository authorRepository) {
        this.authorsRepository = authorRepository;
    }

    @Override
    public List<Authors> getAuthors(String name) {
        return authorsRepository.findAllByName(name);
    }

    @Override
    public void createAuthors(String name, String biography, Date birthDate) {
        Authors authors = new Authors(name, biography, birthDate);

        authorsRepository.save(authors);
    }

    @Override
    public void updateAuthors(String name, String biography, Date birthDate, int id){

        Authors authors = authorsRepository.findById(id).orElseThrow(() -> new RuntimeException("Автор с id " + id + " не найден"));
        authors.setBiography(biography);
        authors.setBirthDate(birthDate);
        authors.setName(name);
        authorsRepository.save(authors);

    }

    @Override
    public void deleteAuthors(int id) {
        Authors authors = authorsRepository.findById(id).orElseThrow(() -> new RuntimeException("Автор с id " + id + " не найден"));
        authorsRepository.delete(authors);
    }

    //пример поиска по ID
    @Override
    public Authors getAuthorById(int id) {
        return authorsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Автор с id " + id + " не найден"));
    }

    @Override
    public List<FullAuthorInfoProjection> getAuthorByPublisher(String name){
        return authorsRepository.getFullAuthorPublisher(name);
    }
}
