SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=1;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=1;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `fitness_club` DEFAULT CHARACTER SET utf8 ;
USE `fitness_club` ;

CREATE TABLE IF NOT EXISTS `clients` (
`id` BIGINT NOT NULL AUTO_INCREMENT,
`first_name` VARCHAR(50) NOT NULL,
`last_name` VARCHAR(50) NOT NULL,
`personal_code` VARCHAR(50) NOT NULL,
PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

CREATE UNIQUE INDEX `ix_clients_personal_code` ON `clients` (`personal_code`);


CREATE TABLE IF NOT EXISTS `age_groups` (
`id` BIGINT NOT NULL AUTO_INCREMENT,
`age_group` VARCHAR(50) NOT NULL,
PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

CREATE UNIQUE INDEX `ix_age_groups_age_group` ON `age_groups` (`age_group`);


CREATE TABLE IF NOT EXISTS `workouts` (
`id` BIGINT NOT NULL AUTO_INCREMENT,
`workout` VARCHAR(50) NOT NULL,
PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

CREATE UNIQUE INDEX `ix_workouts_workout` ON `workouts` (`workout`);


CREATE TABLE IF NOT EXISTS `fitness_centres` (
`id` BIGINT NOT NULL AUTO_INCREMENT,
`fitness_centre` VARCHAR(50) NOT NULL,
PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

CREATE UNIQUE INDEX `ix_fitness_centres_fitness_centre` ON `fitness_centres` (`fitness_centre`);


CREATE TABLE IF NOT EXISTS `member_card` (
`id` BIGINT NOT NULL AUTO_INCREMENT,
`client_id` BIGINT NOT NULL,
`age_group` VARCHAR(50) NOT NULL,
`workout` VARCHAR(50) NOT NULL,
`fitness_centre` VARCHAR(50) NOT NULL,
`term_of_contract` DATETIME NOT NULL,
PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;


ALTER TABLE `member_card`
ADD FOREIGN KEY (`client_id`) REFERENCES `clients`(`personal_code`);

--ALTER TABLE `member_card`
--ADD FOREIGN KEY (`age_group`) REFERENCES `age_groups`(`id`);
--
--ALTER TABLE `member_card`
--ADD FOREIGN KEY (`workout`) REFERENCES `workouts`(`id`);
--
--ALTER TABLE `member_card`
--ADD FOREIGN KEY (`fitness_centre`) REFERENCES `fitness_centres`(`id`);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;