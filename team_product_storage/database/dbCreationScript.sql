SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=1;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=1;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


CREATE SCHEMA IF NOT EXISTS `product_storage` DEFAULT CHARACTER SET utf8 ;
USE `product_storage` ;

CREATE TABLE IF NOT EXISTS `products` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(200) NOT NULL,
  `product_brand` VARCHAR(100) NOT NULL,
  `product_model` VARCHAR(100) NOT NULL,
  `product_quantity` INT NOT NULL,
  `price_in_stock` DECIMAL(10,2) NOT NULL,
  `category` VARCHAR(100),
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;


CREATE UNIQUE INDEX `ix_products_product_brand_product_model`
ON products (product_brand, product_model);

CREATE TABLE IF NOT EXISTS `customers` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `customer_name` VARCHAR(200) NOT NULL,
  `registration_code` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

CREATE UNIQUE INDEX `ix_customers_registration_code`
ON `customers` (`registration_code`);


CREATE TABLE IF NOT EXISTS `orders` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `customer_id` BIGINT NOT NULL,
  `order_date` DATETIME NOT NULL,
  `total_price_in_stock` DECIMAL(10,2),
  PRIMARY KEY (id)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;


ALTER TABLE `orders`
ADD FOREIGN KEY (`customer_id`) REFERENCES `customers`(`id`);


CREATE TABLE IF NOT EXISTS `order_items` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_id` BIGINT NOT NULL,
  `product_id` BIGINT NOT NULL,
  `product_quantity` INT NOT NULL,
  `price_in_stock` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;


ALTER TABLE `order_items`
ADD FOREIGN KEY (`order_id`) REFERENCES `orders`(`id`);

ALTER TABLE `order_items`
ADD FOREIGN KEY (`product_id`) REFERENCES `products`(`id`);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;