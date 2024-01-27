CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) UNIQUE,
  `password` varchar(255) DEFAULT NULL,
  `account_non_expired` bit(1) DEFAULT NULL,
  `account_non_locked` bit(1) DEFAULT NULL,
  `credentials_non_expired` bit(1) DEFAULT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
  `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;