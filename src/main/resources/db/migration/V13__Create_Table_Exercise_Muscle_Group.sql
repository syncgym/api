CREATE TABLE IF NOT EXISTS `exercise_muscle_group` (
  `id_muscle_group` bigint NOT NULL,
  `id_exercise` bigint NOT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_muscle_group`,`id_exercise`),
  KEY `fk_exercise_muscle_group_muscle_group` (`id_muscle_group`),
  CONSTRAINT `fk_exercise_muscle_group_muscle_group` FOREIGN KEY (`id_muscle_group`) REFERENCES `muscle_groups` (`id`),
  CONSTRAINT `fk_exercise_muscle_group_exercise` FOREIGN KEY (`id_exercise`) REFERENCES `exercises` (`id`)
) ENGINE=InnoDB;