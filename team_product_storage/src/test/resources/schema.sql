DROP TABLE IF EXISTS orders CASCADE;
DROP TABLE IF EXISTS products CASCADE;
DROP TABLE IF EXISTS customers CASCADE;
DROP TABLE IF EXISTS order_items CASCADE;

CREATE TABLE IF NOT EXISTS `products` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(200) NOT NULL,
  `product_brand` VARCHAR(100) NOT NULL,
  `product_model` VARCHAR(100) NOT NULL,
  `product_quantity` INT NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
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

CREATE UNIQUE INDEX `ix_customers_customer_name_registration_code`
ON customers (customer_name, registration_code);


CREATE TABLE IF NOT EXISTS `orders` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `customer_id` BIGINT NOT NULL,
  `order_date` DATETIME NOT NULL,
  `total_amount` DECIMAL(10,2),
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
  `quantity` INT NOT NULL,
  `amount` DECIMAL(10,2),
  PRIMARY KEY (id)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;


ALTER TABLE `order_items`
ADD FOREIGN KEY (`order_id`) REFERENCES `orders`(`id`);

ALTER TABLE `order_items`
ADD FOREIGN KEY (`product_id`) REFERENCES `products`(`id`);



CREATE INDEX ix_order_items_order_id
ON order_items (order_id);

CREATE INDEX ix_order_items_product_id
ON order_items (product_id);

CREATE INDEX ix_orders_customer_id
ON orders (customer_id);