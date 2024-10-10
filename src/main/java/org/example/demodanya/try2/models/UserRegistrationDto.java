package org.example.demodanya.try2.models;

import lombok.Data;

@Data
public class UserRegistrationDto {
    private String username;
    private String password;
    private String role;

    public UserRegistrationDto(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
