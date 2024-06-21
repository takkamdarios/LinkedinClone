DROP TABLE IF EXISTS `profiles_connections`;
DROP TABLE IF EXISTS `profiles_skills`;
DROP TABLE IF EXISTS `experiences`;
DROP TABLE IF EXISTS `educations`;
DROP TABLE IF EXISTS `skills`;
DROP TABLE IF EXISTS `profiles`;

CREATE TABLE `profiles` (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `user_id` int(11) NOT NULL,
                            `current_job_title` varchar(255) NOT NULL,
                            `industry` varchar(255) DEFAULT NULL,
                            `summary` text DEFAULT NULL,
                            `headline` varchar(255) NOT NULL,
                            `website` varchar(255) DEFAULT NULL,
                            `open_for_work` tinyint(1) NOT NULL DEFAULT 0,
                            PRIMARY KEY (`id`),
                            KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

CREATE TABLE `profiles_connections` (
                                        `profile1_id` int(11) NOT NULL,
                                        `profile2_id` int(11) NOT NULL,
                                        KEY `profile1_id`(`profile1_id`),
                                        KEY `profile2_id` (`profile2_id`),
                                        CONSTRAINT `profiles_connections_ibfk_1` FOREIGN KEY (`profile1_id`) REFERENCES `profiles` (`id`),
                                        CONSTRAINT `profiles_connections_ibfk_2` FOREIGN KEY (`profile2_id`) REFERENCES `profiles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

CREATE TABLE `skills` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `name` varchar(255) NOT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

CREATE TABLE `profiles_skills` (
                                   `profile_id` int(11) NOT NULL,
                                   `skill_id` int(11) NOT NULL,
                                   KEY `profile_id`(`profile_id`),
                                   KEY `skill_id` (`skill_id`),
                                   CONSTRAINT `profiles_skills_ibfk_1` FOREIGN KEY (`profile_id`) REFERENCES `profiles` (`id`),
                                   CONSTRAINT `profiles_skills_ibfk_2` FOREIGN KEY (`skill_id`) REFERENCES `skills` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

CREATE TABLE `experiences` (
                               `id` int(11) NOT NULL AUTO_INCREMENT,
                               `profile_id` int(11) NOT NULL,
                               `job_title` varchar(255) NOT NULL,
                               `company_name` varchar(255) NOT NULL,
                               `location` varchar(255) NOT NULL,
                               `start_date` date NOT NULL,
                               `end_date` date DEFAULT NULL,
                               PRIMARY KEY (`id`),
                               KEY `profile_id` (`profile_id`),
                               CONSTRAINT `experiences_ibfk_1` FOREIGN KEY (`profile_id`) REFERENCES `profiles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

CREATE TABLE `educations` (
                             `id` int(11) NOT NULL AUTO_INCREMENT,
                             `profile_id` int(11) NOT NULL,
                             `school` varchar(255) NOT NULL,
                             `degree` varchar(255) NOT NULL,
                             `field_of_study` varchar(255) NOT NULL,
                             `start_date` date NOT NULL,
                             `end_date` date DEFAULT NULL,
                             PRIMARY KEY (`id`),
                             KEY `profile_id` (`profile_id`),
                             CONSTRAINT `educations_ibfk_1` FOREIGN KEY (`profile_id`) REFERENCES `profiles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;




