package org.example.demodanya.try2.models;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record AuthorsRequest(
        @NotNull
        String name,
        @NotNull
        String biography,
        @NotNull
        Date birthDate
) {
}
