CREATE TABLE IF NOT EXISTS `payments` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `payment_method_id` bigint NOT NULL,
  `value` INT NOT NULL,
  `date` DATE NOT NULL,
  `invoice` VARCHAR(255) NOT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_payments_subscriptions` FOREIGN KEY (`id`) REFERENCES `subscriptions` (`id`),
  CONSTRAINT `fk_payments_payment_methods` FOREIGN KEY (`payment_method_id`) REFERENCES `payment_methods` (`id`)
) ENGINE=InnoDB;