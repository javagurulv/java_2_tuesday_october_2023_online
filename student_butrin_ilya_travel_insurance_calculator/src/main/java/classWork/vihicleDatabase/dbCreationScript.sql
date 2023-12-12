
CREATE INDEX author
ON books (author);
CREATE INDEX title
ON books (title);
Create index author_and_title
ON books (author, title);
Create index id
ON books (id);

Create index first_name
ON readers (first_name);
Create index last_name
ON readers (last_name);
Create index id
ON readers (id);

Create index book_out_date
ON reader_books (book_out_date);
Create index book_return_date
ON reader_books (book_return_date);
Create index reader_id
ON reader_books (reader_id);