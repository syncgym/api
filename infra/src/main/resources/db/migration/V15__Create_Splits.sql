CREATE TABLE IF NOT EXISTS `splits` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `ordination` TINYINT NOT NULL,
  `workout_id` bigint NOT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_splits_workout_id` (`workout_id`),
  CONSTRAINT `fk_splits_workout_id` FOREIGN KEY (`workout_id`) REFERENCES `workouts` (`id`)
) ENGINE=InnoDB;
