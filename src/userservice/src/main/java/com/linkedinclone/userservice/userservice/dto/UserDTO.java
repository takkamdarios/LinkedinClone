package com.linkedinclone.userservice.userservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;


public class UserDTO {

    @Schema(description = "The unique identifier of the user.", example = "1", required = true)
    private Long id;
    @Schema(description = "The username of the user.", example = "johndoe", required = true)
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private Integer age;

    // Constructor
    public UserDTO() {
    }

    public UserDTO(Long id, String username, String firstName, String lastName, String email, LocalDate birthDate, Integer age) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.age = age;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
