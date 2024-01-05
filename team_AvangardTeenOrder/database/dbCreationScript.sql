SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=1;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=1;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `avangard_teen_order` DEFAULT CHARACTER SET utf8 ;
USE `avangard_teen_order` ;

CREATE TABLE IF NOT EXISTS  `clients` (
`id` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT ,
`name_surname` VARCHAR (200) NOT NULL,
`personal_code` BIGINT NOT NULL,
`phone` BIGINT NOT NULL,
`address` VARCHAR (300) NOT NULL

)
ENGINE = InnoDB
AUTO_INCREMENT = 10;

CREATE UNIQUE INDEX clients_type_index ON clients(name_surname, personal_code);

CREATE TABLE IF NOT EXISTS  `parameters` (
`id` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`client_id` BIGINT NOT NULL,
`pelvisWidth` INT NOT NULL,
`thighLength` INT NOT NULL,
`backHeight` INT NOT NULL,
`shinLength` INT NOT NULL

)
ENGINE = InnoDB
AUTO_INCREMENT = 10;

CREATE TABLE IF NOT EXISTS  `wheelchair` (
`id` BIGINT NOT NULL  PRIMARY KEY AUTO_INCREMENT,
`client_id` BIGINT NOT NULL,
`seatWidth` INT NOT NULL,
`seatDepth` INT NOT NULL,
`footrestLength` INT NOT NULL,
`bachHeight` INT NOT NULL,
`price` DOUBLE DEFAULT 177000.0
)
ENGINE = InnoDB
AUTO_INCREMENT = 10;

ALTER TABLE `wheelchair`
add foreign key (client_id) REFERENCES clients (id)  ON DELETE CASCADE;

CREATE TABLE IF NOT EXISTS  `order_components` (
`id` BIGINT NOT NULL PRIMARY KEY auto_increment,
`wheelchair_id` BIGINT NOT NULL,
`component_id` INT NOT NULL

)
ENGINE = InnoDB
AUTO_INCREMENT = 1;

ALTER TABLE `order_components`
add foreign key (component_id) REFERENCES `components` (id);

ALTER TABLE `order_components`
add foreign key (wheelchair_id) REFERENCES `wheelchair` (id)  ON DELETE CASCADE;

CREATE UNIQUE INDEX order_components_wheelchair_index ON order_components(wheelchair_id);


CREATE TABLE IF NOT EXISTS `components` (
`id` INT NOT NULL AUTO_INCREMENT,
`category` VARCHAR(20) NOT NULL,
`marking` VARCHAR (20) NOT NULL UNIQUE,
`information` VARCHAR (2000) NOT NULL,
`price` DOUBLE,
PRIMARY KEY (`id`)
)

ENGINE = InnoDB
AUTO_INCREMENT = 1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;