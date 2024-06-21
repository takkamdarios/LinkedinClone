package com.ecoleit.linkedin.bff.model;

import java.sql.Date;

public record ExperienceDTO (Integer id, String jobTitle, String companyName, String location,
                             Date startDate, Date endDate){
}
