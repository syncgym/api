CREATE TABLE IF NOT EXISTS `exercises` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `target_muscle_group_id` bigint NOT NULL,
  `name` varchar(255) UNIQUE,
  `difficulty` TINYINT NOT NULL,
  `description` varchar(255) NOT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_exercises_target_muscle_group_id` (`target_muscle_group_id`),
  CONSTRAINT `fk_exercises_target_muscle_group_id` FOREIGN KEY (`target_muscle_group_id`) REFERENCES `muscle_groups` (`id`)
) ENGINE=InnoDB;