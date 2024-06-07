package org.example.demodanya.try2.services;

import org.example.demodanya.try2.controllers.AuthorsNotFoundException;
import org.example.demodanya.try2.models.Authors;
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
    public Authors getAuthorById(int id) {

        Authors user = null;

//        if (user == null) {
//            throw new RuntimeException("Пользователь с id " + id + " jhbjlkhb не найден");
//        }
//
//        Optional<Authors> authorsOptional = Optional.ofNullable(new Authors());
//
//        if (!authorsOptional.isPresent()) {
//            throw new RuntimeException("Пользователь с id " + id + " jhbjlkhb не найден");
//        } else {
//            Authors authors = authorsOptional.get();
//        }

        return authorsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Автор с id " + id + " не найден"));
    }

    //    @Override
//    public void updateAuthors(String biography, Date birthDate, String name) {
//        var authors = authorsRepository.getAuthorsById(name).orElseThrow(() -> new AuthorsNotFoundException(name));
//        authorsRepository.updateAuthors(biography, birthDate, authors.name());
//    }
//
//    @Override
//    public void deleteAuthors(String name) {
//        var authors = authorsRepository.getAuthorsById(name).orElseThrow(() -> new AuthorsNotFoundException(name));
//        authorsRepository.deleteAuthorsById(authors.name());
//    }

}
