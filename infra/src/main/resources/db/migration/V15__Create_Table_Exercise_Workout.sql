CREATE TABLE IF NOT EXISTS `exercise_workout` (
  `workout_id` bigint NOT NULL,
  `exercise_id` bigint NOT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`workout_id`,`exercise_id`),
  KEY `fk_exercise_workout_workout` (`workout_id`),
  CONSTRAINT `fk_exercise_workout_exercise` FOREIGN KEY (`exercise_id`) REFERENCES `exercises` (`id`),
  CONSTRAINT `fk_exercise_workout_workout` FOREIGN KEY (`workout_id`) REFERENCES `workouts` (`id`)
) ENGINE=InnoDB;