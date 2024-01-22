CREATE TABLE IF NOT EXISTS `common_users` (
  `id` bigint NOT NULL,
  `id_subscription` bigint NOT NULL,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name` VARCHAR(255) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `gender` BIT NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_common_users_users` FOREIGN KEY (`id`) REFERENCES `users` (`id`),
  KEY `fk_common_users_subscriptions` (`id_subscription`),
  CONSTRAINT `fk_common_users_subscriptions` FOREIGN KEY (`id_subscription`) REFERENCES `subscriptions` (`id`)
) ENGINE=InnoDB;
