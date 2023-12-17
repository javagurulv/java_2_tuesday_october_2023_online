DROP TABLE IF EXISTS ingredients_cake CASCADE;
DROP TABLE IF EXISTS ingredients CASCADE;
DROP TABLE IF EXISTS cakes CASCADE;

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


CREATE TABLE IF NOT EXISTS `ingredients_cake` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `cake_id` BIGINT NOT NULL,
  `ingredient_id` BIGINT NOT NULL,
  `quantity` FLOAT NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;


ALTER TABLE `ingredients_cake`
ADD FOREIGN KEY (`cake_id`) REFERENCES `cakes`(`id`);

ALTER TABLE `ingredients_cake`
ADD FOREIGN KEY (`ingredient_id`) REFERENCES `ingredients`(`id`);
