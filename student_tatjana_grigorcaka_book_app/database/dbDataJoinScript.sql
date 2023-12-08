SELECT *
FROM reader_books
JOIN books ON reader_books.book_id = books.id
WHERE book_return_date IS NULL;

SELECT title, author
FROM reader_books
JOIN books ON reader_books.book_id = books.id
WHERE book_return_date IS NULL;


SELECT *
FROM reader_books
JOIN readers ON reader_books.reader_id = readers.id
WHERE book_id = 1004;

SELECT first_name, last_name
FROM reader_books
JOIN readers ON reader_books.reader_id = readers.id
WHERE book_id = 1004;


SELECT book_id, title, author, issueYear, count(book_id)
FROM reader_books
JOIN books ON reader_books.book_id = books.id
GROUP BY title
ORDER BY count(book_id) desc;




