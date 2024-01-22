CREATE TABLE IF NOT EXISTS `exercise_workout` (
  `id_workout` bigint NOT NULL,
  `id_exercise` bigint NOT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_workout`,`id_exercise`),
  KEY `fk_exercise_workout_workout` (`id_workout`),
  CONSTRAINT `fk_exercise_workout_exercise` FOREIGN KEY (`id_exercise`) REFERENCES `exercises` (`id`),
  CONSTRAINT `fk_exercise_workout_workout` FOREIGN KEY (`id_workout`) REFERENCES `workouts` (`id`)
) ENGINE=InnoDB;