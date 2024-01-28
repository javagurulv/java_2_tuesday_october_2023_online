DROP TABLE IF EXISTS clients CASCADE;
DROP TABLE IF EXISTS parameters CASCADE;
DROP TABLE IF EXISTS wheelchairs CASCADE;
DROP TABLE IF EXISTS order_components CASCADE;
DROP TABLE IF EXISTS components CASCADE;

CREATE TABLE IF NOT EXISTS  `clients` (
`id` BIGINT NOT NULL AUTO_INCREMENT,
`nameSurname` VARCHAR (200) NOT NULL,
`personalCode` BIGINT NOT NULL,
`phone` BIGINT NOT NULL,
`address` VARCHAR (300) NOT NULL,
PRIMARY KEY (`id`)
);

CREATE UNIQUE INDEX clients_type_index ON clients(nameSurname, personalCode);

CREATE TABLE IF NOT EXISTS  `parameters` (
`id` BIGINT NOT NULL  AUTO_INCREMENT,
`client_id` BIGINT NOT NULL,
`pelvisWidth` INT NOT NULL,
`thighLength` INT NOT NULL,
`backHeight` INT NOT NULL,
`shinLength` INT NOT NULL,
PRIMARY KEY (`id`)
);

ALTER TABLE `parameters`
add foreign key (client_id) REFERENCES clients (id) ON DELETE CASCADE;

CREATE TABLE IF NOT EXISTS  `wheelchairs` (
`id` BIGINT NOT NULL AUTO_INCREMENT,
`client_id` BIGINT NOT NULL,
`seatWidth` INT NOT NULL,
`seatDepth` INT NOT NULL,
`footrestLength` INT NOT NULL,
`bachHeight` INT NOT NULL,
`price` DOUBLE DEFAULT 177000.0,
PRIMARY KEY (`id`)
);

ALTER TABLE `wheelchairs`
add foreign key (client_id) REFERENCES clients (id);

CREATE TABLE IF NOT EXISTS `components` (
`id` INT NOT NULL AUTO_INCREMENT,
`category` VARCHAR(20) NOT NULL,
`marking` VARCHAR (20) NOT NULL UNIQUE,
`information` VARCHAR (2000) NOT NULL,
`price` DOUBLE NOT NULL,
PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS  `order_components` (
`id` BIGINT NOT NULL PRIMARY KEY auto_increment,
`wheelchair_id` BIGINT NOT NULL,
`component_id` INT NOT NULL,
`price_component` DOUBLE NOT NULL

);

ALTER TABLE `order_components` ADD foreign key (component_id) REFERENCES `components` (id);

ALTER TABLE `order_components` ADD foreign key (wheelchair_id) REFERENCES `wheelchairs` (id)  ON DELETE CASCADE;



