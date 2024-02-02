CREATE TABLE IF NOT EXISTS `subscriptions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `id_user` bigint NOT NULL,
  `id_plan` bigint NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_subscriptions_users` (`id_user`),
  CONSTRAINT `fk_subscriptions_users` FOREIGN KEY (`id_user`) REFERENCES `common_users` (`id`),
  CONSTRAINT `fk_subscriptions_plans` FOREIGN KEY (`id_plan`) REFERENCES `plans` (`id`)
) ENGINE=InnoDB;
