package org.example.demodanya.try2.services;

import org.example.demodanya.try2.models.BooksDto;
import org.example.demodanya.try2.models.FullBookInfoProjection;

import java.util.Date;
import java.util.List;

public interface BookService {
    List<BooksDto> getBooksByTitle(String title);

    List<BooksDto> getBooksByGenre(String genre);

    List<BooksDto> getBooksByAuthorId(int authorId);

    List<BooksDto> getBooksByCategoryId(int categoryId);

    List<FullBookInfoProjection> getBooksByGenreAndAuthorBornLater(String genre, Date birthDate);

    List<FullBookInfoProjection> getBooksByPublisher(String name);

    void createBooks (int authorId, String title, String genre, int categoryId);

    void updateBooks (String title, String genre, int authorId, int id);

    void deleteBooks (int id);

}
