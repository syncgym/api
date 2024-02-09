CREATE TABLE IF NOT EXISTS `user_workout` (
  `workout_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  `completed_splits` TINYINT NOT NULL DEFAULT 0,
  `is_active` BIT NOT NULL DEFAULT 1,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`workout_id`,`user_id`),
  KEY `fk_user_workout_user` (`user_id`),
  CONSTRAINT `fk_user_workout_user` FOREIGN KEY (`user_id`) REFERENCES `common_users` (`id`),
  CONSTRAINT `fk_user_workout_workout` FOREIGN KEY (`workout_id`) REFERENCES `workouts` (`id`)
) ENGINE=InnoDB;