SELECT  readers.id, books.author as "автор", books.title as "название"
FROM reader_books
JOIN books ON books.id =  reader_books.book_id
JOIN readers on readers.id = reader_books.reader_id
where reader_books.book_return_date is null and readers.id = 2
order by  readers.last_name asc

SELECT  readers.first_name, readers.last_name
FROM reader_books
JOIN books ON books.id =  reader_books.book_id
JOIN readers on readers.id = reader_books.reader_id
where books.id = 5 and reader_books.book_out_date is not null
order by  readers.last_name asc

