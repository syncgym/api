CREATE TABLE IF NOT EXISTS `notes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `id_user` bigint NOT NULL,
  `id_exercise` bigint NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `date` DATE NOT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_notes_user` (`id_user`),
  CONSTRAINT `fk_notes_user` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  CONSTRAINT `fk_notes_exercise` FOREIGN KEY (`id_exercise`) REFERENCES `exercises` (`id`)
) ENGINE=InnoDB;