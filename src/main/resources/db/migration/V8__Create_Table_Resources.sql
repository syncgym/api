CREATE TABLE IF NOT EXISTS `resources` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `id_plan` bigint NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_resources_plans` (`id_plan`),
  CONSTRAINT `fk_resources_plans` FOREIGN KEY (`id_plan`) REFERENCES `plans` (`id`)
) ENGINE=InnoDB;