package com.ecoleit.linkedin.bff.model.api;

import com.ecoleit.linkedin.bff.model.ProfileDTO;

import java.sql.Timestamp;

public record PostWithProfileApiDTO(Integer id, ProfileDTO profile,
                                    String title, String content, Timestamp creationDate) {
}
