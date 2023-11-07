-- MySQL Script generated by MySQL Workbench
-- Tue Nov  7 20:59:59 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema java-real-practice-insurance
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema java-real-practice-insurance
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `java-real-practice-insurance` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema mySqlDbCreationScript
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mySqlDbCreationScript
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mySqlDbCreationScript` DEFAULT CHARACTER SET utf8 ;
USE `java-real-practice-insurance` ;

-- -----------------------------------------------------
-- Table `java-real-practice-insurance`.`classifiers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `java-real-practice-insurance`.`classifiers` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `ix_classifiers_title` (`title` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;


-- -----------------------------------------------------
-- Table `java-real-practice-insurance`.`classifier_values`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `java-real-practice-insurance`.`classifier_values` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `classifier_id` BIGINT NOT NULL,
  `ic` VARCHAR(200) NOT NULL,
  `description` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `ix_classifier_values_ic` (`ic` ASC) VISIBLE,
  INDEX (`classifier_id` ASC) VISIBLE,
  CONSTRAINT ``
    FOREIGN KEY (`classifier_id`)
    REFERENCES `java-real-practice-insurance`.`classifiers` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

USE `mySqlDbCreationScript` ;

-- -----------------------------------------------------
-- Table `mySqlDbCreationScript`.`classifiers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mySqlDbCreationScript`.`classifiers` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `ix_classifiers_title` (`title` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mySqlDbCreationScript`.`classifier_values`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mySqlDbCreationScript`.`classifier_values` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `classifier_id` BIGINT NOT NULL,
  `ic` VARCHAR(200) NOT NULL,
  `description` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX (`classifier_id` ASC) VISIBLE,
  UNIQUE INDEX `ix_classifier_values_ic` (`ic` ASC) VISIBLE,
  CONSTRAINT ``
    FOREIGN KEY (`classifier_id`)
    REFERENCES `mySqlDbCreationScript`.`classifiers` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
