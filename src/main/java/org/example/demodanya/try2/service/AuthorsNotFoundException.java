package org.example.demodanya.try2.service;

public class AuthorsNotFoundException extends RuntimeException {
    private final int id;

    public AuthorsNotFoundException(int id) {
        this.id = id;
    }
    @Override
    public String getMessage() {
        return "Author with id: " + id + " not found";
    }
}
