package com.linkedinclone.userservice.userservice.dto;

import java.time.LocalDate;

public class UserRegistrationDTO {

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private LocalDate birthDate;

    // Constructor
    public UserRegistrationDTO() {
    }

    public UserRegistrationDTO(String username, String firstName, String lastName, String password, String email, LocalDate birthDate) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
