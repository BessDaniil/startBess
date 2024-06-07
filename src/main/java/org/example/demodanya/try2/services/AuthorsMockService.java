/*
package org.example.demodanya.try2.services;
import org.example.demodanya.try2.controllers.AuthorsNotFoundException;
import org.example.demodanya.try2.models.Authors;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthorsMockService implements AuthorsService {
    @Override
    public Authors getAuthors(int id) {
        //имитация БД пока что
        if (id == 123) {
            return new Authors(id, "Василий", "zdarova", new Date(89, 3, 21));
        }
        else {
            throw new AuthorsNotFoundException(id);
        }
    }
}

 */