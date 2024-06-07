package org.example.demodanya.try2.controllers;

public class AuthorsNotFoundException extends RuntimeException {
    private final String name;

    public AuthorsNotFoundException(String name) {
        this.name = name;
    }
    @Override
    public String getMessage() {
        return "Author with name: " + name + " not found";
    }
}
