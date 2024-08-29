package org.example.demodanya.try2.repository;

import org.example.demodanya.try2.models.Authors;
import org.example.demodanya.try2.models.Books;
import org.example.demodanya.try2.models.BooksDto;
import org.example.demodanya.try2.models.FullBookInfoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Book;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface BookRepository extends JpaRepository<Books, Integer> {

    List<Books> findAllByTitle(String title);

    List<Books> findAllByGenre(String genre);

    List<Books> findAllByAuthorId(int authorId);

    List<Books> findAuthorsById(int id);

    List<Books> findAllByCreateDateGreaterThan(Timestamp createDate);

    @Query("select b.id as id, b.title as title, b.genre as genre, a.name as authorName, a.birthDate as authorBirthDate " +
            "from Books b " +
            "inner join Authors a on b.authorId = a.id " +
            "where b.genre = :genre")
    List<FullBookInfoProjection> findAllBooksWithAuthorAndCategory(@Param("genre") String genre);

}
