CREATE TABLE IF NOT EXISTS `talks` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `room` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);