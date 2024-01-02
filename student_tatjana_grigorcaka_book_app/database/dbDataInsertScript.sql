insert into books(title, author, issue_year)
values ('The Little Prince', 'Antoine de Saint-Exupery', 1943);

insert into books(title, author, issue_year)
values ('The Alchemist', 'Paulo Coelho', 1988);

insert into books(title, author, issue_year)
values ('The Hunger Games', 'Suzanne Collins', 2012);

insert into books(id, title, author, issue_year)
values (1005, 'Rich Dad Poor Dad', 'Robert Kiyosaki', 1997);

insert into books(id, title, author, issue_year)
values (1012, 'Harry Potter and the Philosophers Stone', 'Joanne Rowling', 1997);





insert into readers(first_name, last_name, personal_code)
values ('John', 'Smith', '123456Y');

insert into readers(first_name, last_name, personal_code)
values ('Emily', 'Davies', '789101X');

insert into readers(id, first_name, last_name, personal_code)
values (7777, 'William', 'Taylor', '112131K');



insert into reader_books(reader_id, book_id, book_out_date, book_return_date)
values (7777, 1005, '2023-12-03 23:59:59', '2023-12-08 23:59:59');
insert into reader_books(reader_id, book_id, book_out_date, book_return_date)
values (1002, 1002, '2023-12-05 23:59:59', '2023-12-10 23:59:59');
insert into reader_books(reader_id, book_id, book_out_date, book_return_date)
values (7777, 1004, '2023-12-01 23:59:59', '2023-12-10 23:59:59');
insert into reader_books(reader_id, book_id, book_out_date)
values (1002, 1004, '2023-12-01 23:59:59');
insert into reader_books(id, reader_id, book_id, book_out_date)
values (1007, 1002, 1004, '2023-12-01 23:59:59');
insert into reader_books(id, reader_id, book_id, book_out_date, book_return_date)
values (1008, 1002, 1004, '2023-12-01 23:59:59', '2023-12-12 23:59:59');
insert into reader_books(reader_id, book_id, book_out_date)
values (1003, 1003, '2023-12-01 23:59:59');
insert into reader_books(reader_id, book_id, book_out_date)
values (7777, 1004, '2023-12-01 23:59:59');



