insert into books(title, author, issueYear, genre)
values ("The Little Prince", "Antoine de Saint-Exupery", 1943, "FABLE");

insert into books(title, author, issueYear, genre)
values ("The Alchemist", "Paulo Coelho", 1988, "ADVENTURE");

insert into books(title, author, issueYear, genre)
values ("The Hunger Games", "Suzanne Collins", 2012, "SCIENCE_FICTION");

insert into books(id, title, author, issueYear, genre)
values (1004, "Rich Dad Poor Dad", "Robert Kiyosaki", 1997, "PERSONAL_FINANCE");

insert into books(id, title, author, issueYear, genre)
values (1005, "Harry Potter and the Philosopher's Stone", "Joanne Rowling", 1997, "FANTASY");



insert into readers(first_name, last_name)
values ('John', 'Smith');

insert into readers(first_name, last_name)
values ('Emily', 'Davies');

insert into readers(id, first_name, last_name)
values (7777, 'William', 'Taylor');



insert into reader_books(reader_id, book_id, book_out_date)
values (7777, 1005, '2021-01-01 23:59:59');
insert into reader_books(reader_id, book_id, book_out_date)
values (1002, 1002, '2021-01-01 23:59:59');
insert into reader_books(reader_id, book_id, book_out_date)
values (1002, 1003, '2021-01-01 23:59:59');
insert into reader_books(reader_id, book_id, book_out_date)
values (7777, 1005, '2021-01-01 23:59:59');
insert into reader_books(reader_id, book_id, book_out_date)
values (1002, 1004, '2021-01-01 23:59:59');
insert into reader_books(id, reader_id, book_id, book_out_date)
values (1007, 1002, 1004, '2021-01-01 23:59:59');
insert into reader_books(id, reader_id, book_id, book_out_date, book_return_date)
values (1008, 1002, 1004, '2021-01-01 23:59:59', '2021-01-05 23:59:59');
insert into reader_books(reader_id, book_id, book_out_date)
values (1003, 1004, '2021-01-01 23:59:59');
insert into reader_books(reader_id, book_id, book_out_date)
values (7777, 1004, '2021-01-01 23:59:59');



