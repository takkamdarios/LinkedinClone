CREATE TABLE IF NOT EXISTS `profiles` (
                                          `id` int(11) NOT NULL AUTO_INCREMENT,
    `user_id` int(11) NOT NULL,
    `current_job_title` varchar(255) NOT NULL,
    `industry` varchar(255) DEFAULT NULL,
    `summary` text DEFAULT NULL,
    `headline` varchar(255) NOT NULL,
    `website` varchar(255) DEFAULT NULL,
    `open_for_work` tinyint(1) NOT NULL DEFAULT 0,
    PRIMARY KEY (`id`),
    INDEX `user_idx` (`user_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



CREATE TABLE IF NOT EXISTS `education` (
                                           `id` int(11) NOT NULL AUTO_INCREMENT,
    `profile_id` int(11) NOT NULL,
    `school` varchar(255) NOT NULL,
    `degree` varchar(255) NOT NULL,
    `field_of_study` varchar(255) NOT NULL,
    `start_date` date NOT NULL,
    `end_date` date DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `profile_id` (`profile_id`),
    CONSTRAINT `education_ibfk_1` FOREIGN KEY (`profile_id`) REFERENCES `profiles` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE IF NOT EXISTS `experiences` (
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
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
