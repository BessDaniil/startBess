package org.example.demodanya.try2.models;

import jakarta.validation.constraints.NotNull;

public record BooksRequest(
        @NotNull
        String title,
        @NotNull
        String genre,
        @NotNull
        int authorId
) {

}
