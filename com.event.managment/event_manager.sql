CREATE TABLE `conference_guests` (
  `conferences_id` int NOT NULL,
  `guest_id` int NOT NULL,
  PRIMARY KEY (`conferences_id`,`guest_id`),
  KEY `fk_conferences_has_guest_guest1_idx` (`guest_id`),
  KEY `fk_conferences_has_guest_conferences1_idx` (`conferences_id`),
  CONSTRAINT `fk_conferences_has_guest_conferences1` FOREIGN KEY (`conferences_id`) REFERENCES `conferences` (`id`),
  CONSTRAINT `fk_conferences_has_guest_guest1` FOREIGN KEY (`guest_id`) REFERENCES `guests` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `conference_speakers` (
  `conferences_id` int NOT NULL,
  `speakers_id` int NOT NULL,
  PRIMARY KEY (`conferences_id`,`speakers_id`),
  KEY `fk_conferences_has_speakers_speakers1_idx` (`speakers_id`),
  KEY `fk_conferences_has_speakers_conferences1_idx` (`conferences_id`),
  CONSTRAINT `fk_conferences_has_speakers_conferences1` FOREIGN KEY (`conferences_id`) REFERENCES `conferences` (`id`),
  CONSTRAINT `fk_conferences_has_speakers_speakers1` FOREIGN KEY (`speakers_id`) REFERENCES `speakers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `conferences` (
  `id` int NOT NULL AUTO_INCREMENT,
  `location` varchar(100) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `duration` int DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `events` (
  `id` int NOT NULL AUTO_INCREMENT,
  `location` varchar(100) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `duration` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `event_guests` (
  `event_id` int NOT NULL,
  `guest_id` int NOT NULL,
  PRIMARY KEY (`event_id`,`guest_id`),
  KEY `fk_event_has_guest_guest1_idx` (`guest_id`),
  KEY `fk_event_has_guest_event1_idx` (`event_id`),
  CONSTRAINT `fk_event_has_guest_event1` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`),
  CONSTRAINT `fk_event_has_guest_guest1` FOREIGN KEY (`guest_id`) REFERENCES `guests` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `exposition_guests` (
  `expositions_id` int NOT NULL,
  `guest_id` int NOT NULL,
  PRIMARY KEY (`expositions_id`,`guest_id`),
  KEY `fk_expositions_has_guest_guest1_idx` (`guest_id`),
  KEY `fk_expositions_has_guest_expositions1_idx` (`expositions_id`),
  CONSTRAINT `fk_expositions_has_guest_expositions1` FOREIGN KEY (`expositions_id`) REFERENCES `expositions` (`id`),
  CONSTRAINT `fk_expositions_has_guest_guest1` FOREIGN KEY (`guest_id`) REFERENCES `guests` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `expositions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `location` varchar(100) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `duration` int DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `guests` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `speakers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `presentation_duration` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
