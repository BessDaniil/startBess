package org.example.demodanya.try2.repository;

import org.example.demodanya.try2.models.Authors;
import org.example.demodanya.try2.models.FullAuthorInfoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Authors, Integer> {

    List<Authors> findAllByName(String name);

    List<Authors> findAllByBirthDateAfter(Date date);

    @Query("select a.id as id, a.name as name, a.biography as biography, a.birthDate as birthDate, " +
            "b.title as booksTitle, c.name as categoryName " +
            "from Authors a " +
            "inner join Books b on a.id = b.authorId " +
            "join b.categories c " +
            "join b.publishers p where " +
            "p.name = :name")
    List<FullAuthorInfoProjection> getFullAuthorPublisher(@Param("name") String name);

}
