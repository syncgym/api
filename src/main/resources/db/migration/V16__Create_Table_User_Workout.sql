CREATE TABLE IF NOT EXISTS `user_workout` (
  `id_workout` bigint NOT NULL,
  `id_user` bigint NOT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_workout`,`id_user`),
  KEY `fk_user_workout_user` (`id_user`),
  CONSTRAINT `fk_user_workout_user` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  CONSTRAINT `fk_user_workout_workout` FOREIGN KEY (`id_workout`) REFERENCES `workouts` (`id`)
) ENGINE=InnoDB;