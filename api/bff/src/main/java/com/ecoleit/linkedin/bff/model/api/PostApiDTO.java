package com.ecoleit.linkedin.bff.model.api;

import java.sql.Timestamp;

public record PostApiDTO(Integer id, Integer profileId, String title, String content, Timestamp creationDate) {
}
