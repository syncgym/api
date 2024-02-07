CREATE TABLE IF NOT EXISTS `exercise_split` (
  `split_id` bigint NOT NULL,
  `exercise_id` bigint NOT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`split_id`,`exercise_id`),
  KEY `fk_exercise_split_split` (`split_id`),
  CONSTRAINT `fk_exercise_split_exercise` FOREIGN KEY (`exercise_id`) REFERENCES `exercises` (`id`),
  CONSTRAINT `fk_exercise_split_split` FOREIGN KEY (`split_id`) REFERENCES `splits` (`id`)
) ENGINE=InnoDB;