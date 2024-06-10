package org.example.demodanya.try2.repository;

import org.example.demodanya.try2.models.Authors;
import org.example.demodanya.try2.models.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Books, Integer> {
    List<Books> findAllByTitle(String title);

    List<Books> findAllByGenre(String genre);

    List<Books> findAllByAuthorId(int authorId);

    List<Books> findAuthorsById(int id);
}
