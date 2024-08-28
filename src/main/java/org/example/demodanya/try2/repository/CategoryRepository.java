package org.example.demodanya.try2.repository;

import org.example.demodanya.try2.models.Books;
import org.example.demodanya.try2.models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Categories, Integer> {

}
