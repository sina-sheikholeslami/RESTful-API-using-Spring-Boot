CREATE TABLE IF NOT EXISTS `attendees` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `company` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `registered` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);