insert into products(product_name, product_brand, product_model, product_quantity, price_in_stock, category)
values ('Smartphone', 'Apple', 'iPhone 15', 1, 1000, 'PHONES');

insert into products(product_name, product_brand, product_model, product_quantity, price_in_stock, category)
values ('Smartphone', 'Apple', 'iPhone 14', 1, 800, 'PHONES');

insert into products(id, product_name, product_brand, product_model, product_quantity, price_in_stock, category)
values (1004, 'Drone', 'DJI', 'Air 3 Fly More Combo', 1, 1200, 'FREE-TIME');

insert into products(id, product_name, product_brand, product_model, product_quantity, price_in_stock, category)
values (1007, 'PC', 'Apple', 'iMac 24" (2021)', 1, 1200, 'IT');

insert into products(id, product_name, product_brand, product_model, product_quantity, price_in_stock, category)
values (1009, 'Espresso Machine', 'JURA', 'E8 Piano White', 1, 1000, 'KITCHEN');

insert into products(id, product_name, product_brand, product_model, product_quantity, price_in_stock, category)
values (1012, 'Robot vacuum cleaner', 'Miele', 'Scout RX3 Runner', 1, 550, 'HOME_APPLIANCES');


insert into customers(customer_name, registration_code)
values ('Store Akropole Alfa', "123456Y");

insert into customers(customer_name, registration_code)
values ('Store Stockmann', "789101X");

insert into customers(customer_name, registration_code)
values ('Store Spice', "189101Z");

insert into customers(id, customer_name, registration_code)
values (1005, 'Store Mols', "159101A");

insert into customers(id, customer_name, registration_code)
values (7777, 'Store Riga Plaza', "112131K");


insert into orders(customer_id, order_date)
values (1002,'2023-12-05 23:59:59');
insert into orders(customer_id, order_date)
values (1003, '2023-12-07 23:59:59');
insert into orders(customer_id, order_date)
values (1004, '2023-12-10 23:59:59');
insert into orders(id, customer_id, order_date)
values (1007, 1005, '2023-12-12 23:59:59');
insert into orders(id, customer_id, order_date)
values (1008, 7777, '2023-12-12 23:59:59');

insert into order_items(order_id, product_id, product_quantity, price_in_stock)
values (1002, 1002, 1, 1000);
insert into order_items(order_id, product_id, product_quantity, price_in_stock)
values (1002, 1003, 1, 800);
insert into order_items(id, order_id, product_id, product_quantity, price_in_stock)
values (1004, 1002, 1003, 1, 800);
insert into order_items(id, order_id, product_id, product_quantity, price_in_stock)
values (1005, 1002, 1004, 1, 1200);


insert into order_items(order_id, product_id, product_quantity, price_in_stock)
values (1003, 1003, 1, 800);
insert into order_items(order_id, product_id, product_quantity, price_in_stock)
values (1003, 1003, 1, 800);
insert into order_items(id, order_id, product_id, product_quantity, price_in_stock)
values (1014, 1003, 1003, 1, 800);


insert into order_items(order_id, product_id, product_quantity, price_in_stock)
values (1004, 1004, 1, 1200);
insert into order_items(order_id, product_id, product_quantity, price_in_stock)
values (1004, 1004, 1, 1200);
insert into order_items(id, order_id, product_id, product_quantity, price_in_stock)
values (1018, 1004, 1004, 1, 1200);







