SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=1;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=1;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `avangard_teen_order` DEFAULT CHARACTER SET utf8 ;
USE `avangard_teen_order` ;

CREATE TABLE IF NOT EXISTS  `client` (
`id` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT ,
`name_surname` VARCHAR (200) NOT NULL,
`telephone_number` BIGINT NOT NULL,
`address` VARCHAR (300) NOT NULL

)
ENGINE = InnoDB
AUTO_INCREMENT = 10;

ALTER TABLE `client`
ADD column 	`date_order` datetime default now();

CREATE TABLE IF NOT EXISTS  `client-anthropological_data` (
`id` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT ,
`client_id` BIGINT NOT NULL,
`pelvis_width` INT NOT NULL,
`thigh_length` INT NOT NULL,
`back_height` INT NOT NULL,
`shin_length` INT NOT NULL,
foreign key (client_id) REFERENCES client (id)  ON DELETE CASCADE
)
ENGINE = InnoDB
AUTO_INCREMENT = 10;

CREATE TABLE IF NOT EXISTS  `wheelchair-dimensions` (
`id` BIGINT NOT NULL  PRIMARY KEY AUTO_INCREMENT,
`client_id` BIGINT NOT NULL,
`seatWidth` INT NOT NULL,
`seatDepth` INT NOT NULL,
`footrestLength` INT NOT NULL,
`bachHeight` INT NOT NULL,
`price` DOUBLE DEFAULT 177000.0,
foreign key (client_id) REFERENCES client (id)  ON DELETE CASCADE
)
ENGINE = InnoDB
AUTO_INCREMENT = 10;

CREATE TABLE IF NOT EXISTS  `components-list-order` (
`id` BIGINT NOT NULL PRIMARY KEY auto_increment,
`client_id` BIGINT NOT NULL,
`wheelchair_id` BIGINT NOT NULL,
`marking` VARCHAR (45) NOT NULL,
`description` VARCHAR (300) NOT NULL,
`price` DOUBLE,
foreign key (client_id) REFERENCES `client` (id),
foreign key (wheelchair_id) REFERENCES `wheelchair-dimensions` (id)  ON DELETE CASCADE

)
ENGINE = InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `category`(
`id` BIGINT NOT NULL AUTO_INCREMENT,
`title` VARCHAR(20) NOT NULL,
PRIMARY KEY (`id`)
);

CREATE UNIQUE INDEX category_type_index ON category(title);

ENGINE = InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `components` (
`components_id` BIGINT NOT NULL AUTO_INCREMENT,
`category_key` VARCHAR(20) NOT NULL,
`marking` VARCHAR (20) NOT NULL UNIQUE,
`information` VARCHAR (2000) NOT NULL,
`price` FLOAT DEFAULT 0,
PRIMARY KEY (`components_id`)
);

ENGINE = InnoDB
AUTO_INCREMENT = 1;

ALTER TABLE `components`
ADD FOREIGN KEY (`category_key`)
REFERENCES `category` (`title`);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;