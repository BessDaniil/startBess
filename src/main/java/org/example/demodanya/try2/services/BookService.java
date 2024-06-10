package org.example.demodanya.try2.services;

import org.example.demodanya.try2.models.Books;

import java.util.List;

public interface BookService {
    List<Books> getBooksByTitle(String title);

    List<Books> getBooksByGenre(String genre);

    List<Books> getBooksByAuthorId(int authorId);

    void createBooks (int authorId, String title, String genre);

    void updateBooks (String title, String genre, int authorId, int id);

    void deleteBooks (int id);

}
