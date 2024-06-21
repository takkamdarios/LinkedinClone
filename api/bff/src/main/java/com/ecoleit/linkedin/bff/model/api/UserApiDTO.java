package com.ecoleit.linkedin.bff.model.api;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public record UserApiDTO(Integer id, String username, String firstName, String lastName,
                         String password, String email, Date birthDate,
                         LocalDateTime registrationDate, Timestamp lastLoginDate) {
}
