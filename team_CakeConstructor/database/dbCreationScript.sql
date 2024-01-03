SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=1;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=1;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


CREATE SCHEMA IF NOT EXISTS `cake_constructor` DEFAULT CHARACTER SET utf8 ;
USE `cake_constructor` ;

CREATE TABLE IF NOT EXISTS `ingredients` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(200) NOT NULL,
  `taste` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;


CREATE UNIQUE INDEX `ix_ingredients_type_taste`
ON ingredients (type, taste);


CREATE TABLE IF NOT EXISTS `cakes` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `cake_name` VARCHAR(200) NOT NULL,
  `weight` FLOAT,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;


CREATE UNIQUE INDEX `ix_cakes_cake_name`
ON cakes (cake_name);


CREATE TABLE IF NOT EXISTS `cake_ingredients` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `cake_id` BIGINT NOT NULL,
  `ingredient_id` BIGINT NOT NULL,
  `quantity` FLOAT NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;


ALTER TABLE `cake_ingredients`
ADD FOREIGN KEY (`cake_id`) REFERENCES `cakes`(`id`);

ALTER TABLE `cake_ingredients`
ADD FOREIGN KEY (`ingredient_id`) REFERENCES `ingredients`(`id`);


CREATE TABLE IF NOT EXISTS `clients` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(100) NOT NULL,
  `last_name` VARCHAR(100) NOT NULL,
  `personal_code` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

CREATE UNIQUE INDEX `ix_clients_first_name_last_name_personal_code`
ON clients (first_name, last_name, personal_code);


CREATE TABLE IF NOT EXISTS `orders` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `client_id` BIGINT NOT NULL,
  `cake_id` BIGINT NOT NULL,
  `order_date` DATETIME NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;


ALTER TABLE `orders`
ADD FOREIGN KEY (`client_id`) REFERENCES `clients`(`id`);

ALTER TABLE `orders`
ADD FOREIGN KEY (`cake_id`) REFERENCES `cakes`(`id`);


CREATE INDEX ix_cake_ingredients_cake_id
ON cake_ingredients (cake_id);

CREATE INDEX ix_cake_ingredients_ingredient_id
ON cake_ingredients (ingredient_id);

CREATE INDEX ix_orders_client_id
ON orders (client_id);

CREATE INDEX ix_orders_cake_id
ON orders (cake_id);



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;