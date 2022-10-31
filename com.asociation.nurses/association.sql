USE association;
CREATE TABLE `association` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `chapters` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `district` varchar(45) DEFAULT NULL,
  `association_id` int NOT NULL,
  `president_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_chapters_members1_idx` (`president_id`),
  KEY `fk_chapters_association1_idx` (`association_id`),
  CONSTRAINT `fk_chapters_association1` FOREIGN KEY (`association_id`) REFERENCES `association` (`id`),
  CONSTRAINT `fk_chapters_members1` FOREIGN KEY (`president_id`) REFERENCES `members` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `members` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `status` varchar(15) DEFAULT NULL,
  `renewal_date` date DEFAULT NULL,
  `chapters_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_members_chapters1_idx` (`chapters_id`),
  CONSTRAINT `fk_members_chapters1` FOREIGN KEY (`chapters_id`) REFERENCES `chapters` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
