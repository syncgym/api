CREATE TABLE IF NOT EXISTS `payments` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `id_subscription` bigint NOT NULL,
  `value` DATE NOT NULL,
  `date` DATE NOT NULL,
  `invoice` VARCHAR(255) NOT NULL,
  `method` VARCHAR(255) NOT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_payments_subscriptions` (`id_subscription`),
  CONSTRAINT `fk_payments_subscriptions` FOREIGN KEY (`id_subscription`) REFERENCES `subscriptions` (`id`)
) ENGINE=InnoDB;