CREATE TABLE IF NOT EXISTS `user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `is_Active` BIT(1) NOT NULL DEFAULT b'1',
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NULL,
  `password` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `user_name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `phone_UNIQUE` (`phone` ASC) VISIBLE);
