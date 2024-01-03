insert into ingredients(type, taste)
values ('Biscuit', 'Vanilla');

insert into ingredients(type, taste)
values ('Biscuit', 'Chocolate');

insert into ingredients(id, type, taste)
values (1004, 'Filling', 'Creme strawberry');

insert into ingredients(id, type, taste)
values (1005, 'Filling', 'Curd lemon');

insert into ingredients(id, type, taste)
values (1006, 'Shell', 'Ganache with liqueur');

insert into ingredients(id, type, taste)
values (1007, 'Shell', 'Mascarpone mousse');

insert into ingredients(id, type, taste)
values (1008, 'Decor', 'Red velvet');

insert into ingredients(type, taste)
values ('Biscuit', 'French biscuit with berry');



insert into cakes(cake_name)
values ('Lemon Cheese Cake');

insert into cakes(id, cake_name)
values (1005, 'Chocolate Cake');

insert into cakes(id, cake_name)
values (7777, 'Birthday Cake');



insert into cake_ingredients(cake_id, ingredient_id, quantity)
values (1002, 1002, 300);
insert into cake_ingredients(cake_id, ingredient_id, quantity)
values (1002, 1005, 250);
insert into cake_ingredients(id, cake_id, ingredient_id, quantity)
values (1004, 1002, 1007, 250);


insert into cake_ingredients(cake_id, ingredient_id, quantity)
values (1005, 1003, 300);
insert into cake_ingredients(cake_id, ingredient_id, quantity)
values (1005, 1004, 250);
insert into cake_ingredients(id, cake_id, ingredient_id, quantity)
values (1008, 1005, 1006, 250);


insert into cake_ingredients(cake_id, ingredient_id, quantity)
values (7777, 1002, 300);
insert into cake_ingredients(cake_id, ingredient_id, quantity)
values (7777, 1004, 250);
insert into cake_ingredients(id, cake_id, ingredient_id, quantity)
values (1012, 7777, 1007, 250);
insert into cake_ingredients(id, cake_id, ingredient_id, quantity)
values (1014, 7777, 1008, 200);


insert into clients(first_name, last_name, personal_code)
values ('Liza', 'Muller', '31234567891');

insert into clients(first_name, last_name, personal_code)
values ('Emily', 'Berg', '32345678910');

insert into clients(id, first_name, last_name, personal_code)
values (1004, 'David', 'Smith', '33456789101');


insert into orders(client_id, cake_id, order_date)
values (1002, 1002, '2023-12-05 23:59:59');

insert into orders(client_id, cake_id, order_date)
values (1003, 1005, '2023-12-07 23:59:59');

insert into orders(id, client_id, cake_id, order_date)
values (1004, 1004, 7777, '2023-12-10 23:59:59');







