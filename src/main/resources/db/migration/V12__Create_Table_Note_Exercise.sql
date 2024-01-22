CREATE TABLE IF NOT EXISTS `note_exercise` (
  `id_note` bigint NOT NULL,
  `id_exercise` bigint NOT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_note`,`id_exercise`),
  KEY `fk_note_exercise_exercise` (`id_exercise`),
  CONSTRAINT `fk_note_exercise_exercise` FOREIGN KEY (`id_exercise`) REFERENCES `exercises` (`id`),
  CONSTRAINT `fk_note_exercise_note` FOREIGN KEY (`id_note`) REFERENCES `notes` (`id`)
) ENGINE=InnoDB;