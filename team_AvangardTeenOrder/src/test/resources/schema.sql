DROP TABLE IF EXISTS clients CASCADE;
DROP TABLE IF EXISTS client_size CASCADE;
DROP TABLE IF EXISTS wheelchair CASCADE;
DROP TABLE IF EXISTS order_components CASCADE;

CREATE TABLE IF NOT EXISTS  `clients` (
`id` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT ,
`name_surname` VARCHAR (200) NOT NULL,
`personal_code` BIGINT NOT NULL,
`phone` BIGINT NOT NULL,
`address` VARCHAR (300) NOT NULL,
`order_id` BIGINT

)
ENGINE = InnoDB
AUTO_INCREMENT = 10;

ALTER TABLE `clients`
add foreign key (order_id) REFERENCES wheelchair (id) ON DELETE CASCADE;

CREATE UNIQUE INDEX ix_clients_wheelchair_order ON clients(id, order_id);
CREATE UNIQUE INDEX clients_type_index ON clients(name_surname, personal_code);

CREATE TABLE IF NOT EXISTS  `client_size` (
`id` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`client_id` BIGINT NOT NULL,
`pelvisWidth` INT NOT NULL,
`thighLength` INT NOT NULL,
`backHeight` INT NOT NULL,
`shinLength` INT NOT NULL,
`order_id` BIGINT
)
ENGINE = InnoDB
AUTO_INCREMENT = 10;

ALTER TABLE `client_size`
add foreign key (order_id) REFERENCES wheelchair (id)  ON DELETE CASCADE;

CREATE UNIQUE INDEX client_size_type_index ON client_size(order_id);

CREATE TABLE IF NOT EXISTS  `wheelchair` (
`id` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`seatWidth` INT NOT NULL,
`seatDepth` INT NOT NULL,
`footrestLength` INT NOT NULL,
`bachHeight` INT NOT NULL,
`price` DOUBLE DEFAULT 177000.0,
)
ENGINE = InnoDB
AUTO_INCREMENT = 10;

ALTER TABLE `wheelchair`
add foreign key (client_id) REFERENCES clients (id)  ON DELETE CASCADE;

CREATE UNIQUE INDEX wheelchair_type_index ON wheelchair(client_id);


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

CREATE UNIQUE INDEX order_components_components_index ON order_components(component_id);
CREATE UNIQUE INDEX order_components_wheelchair_index ON order_components(wheelchair_id);


CREATE TABLE IF NOT EXISTS `category`(
`id` BIGINT NOT NULL AUTO_INCREMENT,
`title` VARCHAR(20) NOT NULL,
PRIMARY KEY (`id`)
)

ENGINE = InnoDB
AUTO_INCREMENT = 1;

CREATE UNIQUE INDEX category_type_index ON category(title);

CREATE TABLE IF NOT EXISTS `components` (
`id` INT NOT NULL AUTO_INCREMENT,
`category_key` BIGINT NOT NULL,
`marking` VARCHAR (20) NOT NULL UNIQUE,
`information` VARCHAR (2000) NOT NULL,
`price` DOUBLE,
PRIMARY KEY (`id`)
)

ENGINE = InnoDB
AUTO_INCREMENT = 1;

ALTER TABLE `components`
ADD FOREIGN KEY (`category_key`)
REFERENCES `category` (`id`);

CREATE UNIQUE INDEX category_key_index ON components(category_key);
