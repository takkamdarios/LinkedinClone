package com.ecoleit.linkedin.bff.model;

import java.sql.Date;

public record EducationDTO(Integer id, String school, String degree, String filedOfStudy,
                           Date startDate, Date endDate) {
}
