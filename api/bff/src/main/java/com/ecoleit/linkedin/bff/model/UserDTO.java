package com.ecoleit.linkedin.bff.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public record UserDTO(Integer id, String username, String firstName,
                      String lastName, String email, Date birthDate,
                      LocalDateTime registrationDate, Timestamp lastLoginDate) {
}
