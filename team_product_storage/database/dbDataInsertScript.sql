insert into products(id, product_name, product_brand, product_model, product_quantity, price)
values (1002, 'Smartphone', 'Apple', 'iPhone 15', 1, 1000);

insert into products(id, product_name, product_brand, product_model, product_quantity, price)
values (1003, 'Smartphone', 'Apple', 'iPhone 14', 1, 800);

insert into products(id, product_name, product_brand, product_model, product_quantity, price)
values (1004, 'Drone', 'DJI', 'Air 3 Fly More Combo', 1, 1200);

insert into products(id, product_name, product_brand, product_model, product_quantity, price)
values (1007, 'PC', 'Apple', 'iMac 24" (2021)', 1, 1200);

insert into products(id, product_name, product_brand, product_model, product_quantity, price)
values (1009, 'Espresso Machine', 'JURA', 'E8 Piano White', 1, 1000);

insert into products(id, product_name, product_brand, product_model, product_quantity, price)
values (1012, 'Robot vacuum cleaner', 'Miele', 'Scout RX3 Runner', 1, 550);

insert into products(id, product_name, product_brand, product_model, product_quantity, price)
values (1015, 'Hand Blender', 'Braun', 'Braun MultiQuick 9', 1, 180);


insert into customers(id, customer_name, registration_code)
values (1002, 'Store Akropole Alfa', '123456Y');

insert into customers(id, customer_name, registration_code)
values (1003, 'Store Stockmann', '789101X');

insert into customers(id, customer_name, registration_code)
values (1004, 'Store Spice', '189101Z');

insert into customers(id, customer_name, registration_code)
values (1005, 'Store Mols', '159101A');

insert into customers(id, customer_name, registration_code)
values (7777, 'Store Riga Plaza', '112131K');


insert into orders(id, customer_id, order_date, total_amount)
values (1002, 1002,'2023-12-05 23:59:59', 3800);

insert into orders(id, customer_id, order_date, total_amount)
values (1003, 1003, '2023-12-07 23:59:59', 2400);

insert into orders(id, customer_id, order_date, total_amount)
values (1004, 1004, '2023-12-10 23:59:59', 3600);


insert into order_items(id, order_id, product_id, quantity, amount)
values (1002, 1002, 1002, 1, 1000);

insert into order_items(id, order_id, product_id, quantity, amount)
values (1004, 1002, 1003, 2, 1600);

insert into order_items(id, order_id, product_id, quantity, amount)
values (1005, 1002, 1004, 1, 1200);

insert into order_items(id, order_id, product_id, quantity, amount)
values (1014, 1003, 1003, 3, 2400);

insert into order_items(id, order_id, product_id, quantity, amount)
values (1018, 1004, 1004, 3, 3600);







