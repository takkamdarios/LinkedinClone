package com.ecoleit.linkedin.user.auth;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public record RegisterRequest(
        String username, String firstName, String lastName,
        String password, String email, Date birthDate) {


}


