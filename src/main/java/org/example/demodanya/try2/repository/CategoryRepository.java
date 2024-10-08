package org.example.demodanya.try2.repository;

import org.example.demodanya.try2.models.Books;
import org.example.demodanya.try2.models.Categories;
import org.example.demodanya.try2.models.FullCategoryInfoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Categories, Integer> {

    @Query("select c.id as id, c.name as name, a.name as authorName, b.title as bookTitle " +
            "from Categories c join c.includedBooks b " +
            "join Authors a on b.authorId = a.id " +
            "join b.publishers p " +
            "where p.name = :name")
    List<FullCategoryInfoProjection>getFullCategoryInfoProjectionByPublisher(@Param("name") String name);
}
