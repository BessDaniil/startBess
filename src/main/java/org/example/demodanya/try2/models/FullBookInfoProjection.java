package org.example.demodanya.try2.models;

import java.util.Date;

public interface FullBookInfoProjection {

    Integer getId();

    String getTitle();

    String getGenre();

    String getAuthorName();

    Date getAuthorBirthDate();

    String getCategoryName();
}
