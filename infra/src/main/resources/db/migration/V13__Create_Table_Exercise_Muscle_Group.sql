CREATE TABLE IF NOT EXISTS `exercise_muscle_group` (
  `muscle_group_id` bigint NOT NULL,
  `exercise_id` bigint NOT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`muscle_group_id`,`exercise_id`),
  KEY `fk_exercise_muscle_group_muscle_group` (`muscle_group_id`),
  CONSTRAINT `fk_exercise_muscle_group_muscle_group` FOREIGN KEY (`muscle_group_id`) REFERENCES `muscle_groups` (`id`),
  CONSTRAINT `fk_exercise_muscle_group_exercise` FOREIGN KEY (`exercise_id`) REFERENCES `exercises` (`id`)
) ENGINE=InnoDB;