package org.example.demodanya.try2.repository;

import org.example.demodanya.try2.models.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Authors, Integer> {

    List<Authors> findAllByName(String name);

    List<Authors> findAllByBirthDateAfter(Date date);

}
