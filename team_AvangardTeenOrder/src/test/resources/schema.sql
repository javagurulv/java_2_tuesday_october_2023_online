DROP TABLE IF EXISTS clients CASCADE;

CREATE TABLE IF NOT EXISTS  `clients` (
`id` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT ,
`name_surname` VARCHAR (200) NOT NULL,
`personal_code` BIGINT NOT NULL,
`telephone_number` BIGINT NOT NULL,
`address` VARCHAR (300) NOT NULL

)
ENGINE = InnoDB
AUTO_INCREMENT = 10;

CREATE UNIQUE INDEX clients_type_index ON clients(name_surname, personal_code);
CREATE TABLE IF NOT EXISTS  `client_size` (
`id` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT ,
`clients_id` BIGINT NOT NULL,
`pelvis_width` INT NOT NULL,
`thigh_length` INT NOT NULL,
`back_height` INT NOT NULL,
`shin_length` INT NOT NULL

)
ENGINE = InnoDB
AUTO_INCREMENT = 10;

ALTER TABLE `client_size`
add foreign key (clients_id) REFERENCES clients (id)  ON DELETE CASCADE;

CREATE UNIQUE INDEX client_size_type_index ON client_size(clients_id);
