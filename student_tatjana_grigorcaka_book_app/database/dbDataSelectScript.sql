SELECT * FROM books;
SELECT * FROM readers;
SELECT * FROM reader_books;

SELECT * FROM books WHERE id = 1002;
SELECT * FROM readers WHERE id = 1003;
SELECT * FROM reader_books WHERE id = 1004;

SELECT author FROM books WHERE id = 1002;
SELECT title FROM books WHERE id = 1003;
SELECT issueYear FROM books WHERE id = 1004;

SELECT * FROM books WHERE title = "The Alchemist";
Select * FROM readers WHERE first_name = "Emily";

SELECT * FROM books WHERE title = "The Alchemist" OR author = "Paulo Coelho";
SELECT * FROM books WHERE title = "The Alchemist" AND author = "Paulo Coelho";

SELECT * FROM books
LIMIT 1,3;

SELECT title, author FROM books
ORDER BY title ASC;

SELECT title, author FROM books
ORDER BY title DESC;

SELECT COUNT(*) FROM books;


