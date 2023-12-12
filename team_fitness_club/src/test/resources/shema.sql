DROP TABLE IF EXISTS member_card CASCADE;
DROP TABLE IF EXISTS fitness_centres CASCADE;
DROP TABLE IF EXISTS workouts CASCADE;
DROP TABLE IF EXISTS age_groups CASCADE;
DROP TABLE IF EXISTS clients CASCADE;

CREATE TABLE IF NOT EXISTS `clients` (
`id` BIGINT NOT NULL AUTO_INCREMENT,
`first_name` VARCHAR(50) NOT NULL,
`last_name` VARCHAR(50) NOT NULL,
`personal_code` VARCHAR(50) NOT NULL,
PRIMARY KEY (`id`)
)


CREATE TABLE IF NOT EXISTS `age_groups` (
`id` BIGINT NOT NULL AUTO_INCREMENT,
`age_group` VARCHAR(50) NOT NULL,
PRIMARY KEY (`id`)
)


CREATE TABLE IF NOT EXISTS `workouts` (
`id` BIGINT NOT NULL AUTO_INCREMENT,
`workout` VARCHAR(50) NOT NULL,
PRIMARY KEY (`id`)
)


CREATE TABLE IF NOT EXISTS `fitness_centres` (
`id` BIGINT NOT NULL AUTO_INCREMENT,
`fitness_centre` VARCHAR(50) NOT NULL,
PRIMARY KEY (`id`)
)


CREATE TABLE IF NOT EXISTS `member_card` (
`id` BIGINT NOT NULL AUTO_INCREMENT,
`client_id` BIGINT NOT NULL,
`age_group_id` BIGINT NOT NULL,
`workout_id` BIGINT NOT NULL,
`fitness_centre_id` BIGINT NOT NULL,
`term_of_contract` DATETIME NOT NULL,
PRIMARY KEY (`id`)
)


ALTER TABLE `member_card`
ADD FOREIGN KEY (`client_id`) REFERENCES `clients`(`id`);

ALTER TABLE `member_card`
ADD FOREIGN KEY (`age_group_id`) REFERENCES `age_groups`(`id`);

ALTER TABLE `member_card`
ADD FOREIGN KEY (`workout_id`) REFERENCES `workouts`(`id`);

ALTER TABLE `member_card`
ADD FOREIGN KEY (`fitness_centre_id`) REFERENCES `fitness_centres`(`id`);

