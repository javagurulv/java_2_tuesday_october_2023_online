SELECT *
FROM book_app.reader_books
JOIN book_app.books ON book_app.reader_books.book_id = book_app.books.id
WHERE book_return_date IS NULL;

SELECT title, author
FROM book_app.reader_books
JOIN book_app.books ON book_app.reader_books.book_id = book_app.books.id
WHERE book_return_date IS NULL;


SELECT *
FROM book_app.reader_books
JOIN book_app.readers ON book_app.reader_books.reader_id = book_app.readers.id
WHERE book_id = 1004;

SELECT first_name, last_name
FROM book_app.reader_books
JOIN book_app.readers ON book_app.reader_books.reader_id = book_app.readers.id
WHERE book_id = 1004;


SELECT book_id, title, author, issue_year, count(book_id)
FROM book_app.reader_books
JOIN book_app.books ON book_app.reader_books.book_id = book_app.books.id
GROUP BY title
ORDER BY count(book_id) desc;




