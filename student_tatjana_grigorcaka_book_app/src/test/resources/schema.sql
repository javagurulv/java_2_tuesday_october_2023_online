DROP TABLE IF EXISTS reader_books CASCADE;
DROP TABLE IF EXISTS books CASCADE;
DROP TABLE IF EXISTS readers CASCADE;

CREATE TABLE IF NOT EXISTS `books` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NOT NULL,
  `author` VARCHAR(100) NOT NULL,
  `issue_year` INT NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;


CREATE UNIQUE INDEX `ix_books_title_author`
ON `books` (`title, author`);


CREATE TABLE IF NOT EXISTS `readers` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(200) NOT NULL,
  `last_name` VARCHAR(100) NOT NULL,
  `personal_code` VARCHAR(50) NOT NULL,

  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

CREATE UNIQUE INDEX `ix_readers_first_name_last_name_personal_code`
ON readers (first_name, last_name, personal_code);


CREATE TABLE IF NOT EXISTS `reader_books` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `reader_id` BIGINT NOT NULL,
  `book_id` BIGINT NOT NULL,
  `book_out_date` DATETIME NOT NULL,
  `book_return_date` DATETIME,
  PRIMARY KEY (id)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;


ALTER TABLE `reader_books`
ADD FOREIGN KEY (`book_id`) REFERENCES `books`(`id`);

ALTER TABLE `reader_books`
ADD FOREIGN KEY (`reader_id`) REFERENCES `readers`(`id`);


CREATE INDEX ix_reader_books_reader_id
ON reader_books (reader_id);

CREATE INDEX ix_reader_books_book_id
ON reader_books (book_id);

