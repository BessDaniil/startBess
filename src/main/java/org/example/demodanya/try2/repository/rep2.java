package org.example.demodanya.try2.repository;

import org.example.demodanya.try2.models.Authors;

import java.util.Date;
import java.util.List;

public interface rep2 {
    List<Authors> getAuthorsByName(String name);

}
