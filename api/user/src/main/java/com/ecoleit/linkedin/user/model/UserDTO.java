package com.ecoleit.linkedin.user.model;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.sql.Date;

public record UserDTO(Integer id, String username, String firstName, String lastName, String password,
                      String email, Date birthDate, LocalDateTime registrationDate, Timestamp lastLoginDate) {
}
