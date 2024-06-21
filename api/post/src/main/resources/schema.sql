DROP TABLE IF EXISTS `comments`;
DROP TABLE IF EXISTS `posts`;


CREATE TABLE `posts` (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `profile_id` int(11) NOT NULL,
                         `title` varchar(255) NOT NULL,
                         `content` text NOT NULL,
                         `creation_date` timestamp NOT NULL DEFAULT current_timestamp(),
                         PRIMARY KEY (`id`),
                         KEY `profile_id` (`profile_id`)
) ENGINE=InnoDB AUTO_INCREMENT=257 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;


CREATE TABLE `comments` (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `post_id` int(11) NOT NULL,
                            `profile_id` int(11) NOT NULL,
                            `content` text NOT NULL,
                            `creation_date` timestamp NOT NULL DEFAULT current_timestamp(),
                            PRIMARY KEY (`id`),
                            KEY `post_id` (`post_id`),
                            KEY `profile_id` (`profile_id`),
                            CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

