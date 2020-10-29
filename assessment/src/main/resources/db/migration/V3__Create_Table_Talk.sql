CREATE TABLE IF NOT EXISTS `TALK` (
  `talk_id` bigint NOT NULL AUTO_INCREMENT,
  `speaker_id` bigint NOT NULL,
  `room` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`talk_id`),
  KEY `speaker_id` (`speaker_id`),
  CONSTRAINT `talks_ibfk_1` FOREIGN KEY (`speaker_id`) REFERENCES `SPEAKER` (`speaker_id`)
);