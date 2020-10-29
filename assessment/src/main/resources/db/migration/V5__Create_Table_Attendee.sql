CREATE TABLE IF NOT EXISTS `ATTENDEE` (
  `attendee_id` bigint NOT NULL AUTO_INCREMENT,
  `talk_id` bigint NOT NULL,
  `company` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `registered` varchar(255) NOT NULL,
  PRIMARY KEY (`attendee_id`),
  KEY `talk_id` (`talk_id`),
  CONSTRAINT `attendees_ibfk_1` FOREIGN KEY (`talk_id`) REFERENCES `TALK` (`talk_id`)
);