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

    @Query("select b.id as id, b.title as title, b.genre as genre, a.name as authorName, " +
            "a.birthDate as authorBirthDate, c.name as categoryName " +
            "from Books b " +
            "inner join Authors a on b.authorId = a.id " +
            "inner join b.categories c " +
            "where b.genre = :genre and a.birthDate > :birthDate")
    List<FullBookInfoProjection> findBooksByGenreAndAuthorBornLater(@Param("genre") String genre,
                                                                   @Param("birthDate") Date birthDate);

}
