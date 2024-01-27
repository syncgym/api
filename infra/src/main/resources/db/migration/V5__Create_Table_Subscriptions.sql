CREATE TABLE IF NOT EXISTS `subscriptions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `id_plan` bigint NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_subscriptions_plans` (`id_plan`),
  CONSTRAINT `fk_subscriptions_plans` FOREIGN KEY (`id_plan`) REFERENCES `plans` (`id`)
) ENGINE=InnoDB;
