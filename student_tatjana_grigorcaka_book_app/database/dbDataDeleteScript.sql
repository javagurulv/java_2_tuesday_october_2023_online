DELETE FROM readers;  //не работает
DELETE FROM books;
DELETE FROM reader_books;

DELETE FROM readers WHERE id != 0;
DELETE FROM books WHERE id != 0;
DELETE FROM reader_books WHERE id != 0;

DELETE FROM books WHERE id = 1012;

DROP TABLE IF EXISTS `books`

DROP SCHEMA `book_app` ;



