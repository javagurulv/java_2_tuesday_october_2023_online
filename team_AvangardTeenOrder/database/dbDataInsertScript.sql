insert into clients (
nameSurname,
personalCode,
phone,
address)
VALUES(
"Ivanov",
22222,
12345678,
"Lesnaja 2_22");


insert into wheelchairs (
client_id,
seatWidth,
seatDepth,
footrestLength,
bachHeight,
price)
select
cl.id,
22,
22,
22,
22, 177000.0
from clients as cl
where cl.id = 10;


 insert into `order_components`
 (wheelchair_id,
 component_id)
 select
 w.id,
 c.id
from wheelchair as w
join components as c
where w.id = 10
and c.id = 1;

insert into `order_components`
 (wheelchair_id,
 component_id, price_component)
 select
 w.id,
 c.id,
 c.price
from wheelchairs as w
join components as c
where w.id = 10
and c.id = 5;

 insert into `order_components`
 (wheelchair_id,
 component_id, price_component)
 select
 w.id,
 c.id,
 c.price
from wheelchairs as w
join components as c
where w.id = 10
and c.id = 16;

 insert into `order_components`
 (wheelchair_id,
 component_id, price_component)
 select
 w.id,
 c.id, c.price
from wheelchairs as w
join components as c
where w.id = 10
and c.id = 11;

insert into parameters (
client_id,
pelvisWidth,
thighLength,
backHeight,
shinLength
)
select
cl.id,
22,
22,
22,
22
from clients as cl
where cl.id = 10;



INSERT INTO components (
	category,
	marking,
	information,
	price)

VALUE (
'BRAKE',
'MH 01',
'На уровне коленей пользователя, стандарт',
0.0);


INSERT INTO components (
	category,
	marking,
	information,
	price)

VALUE (
'BRAKE',
'MH 02',
'На уровне коленей пользователя, стандарт, короткая ручка тормоза',
1500.0);


INSERT INTO components (
	category,
	marking,
	information,
	price)

VALUE (
'BRAKE',
'MH 07',
'На уровне коленей пользователя, регулируемая по длине ручка тормоза',
5700.0);


INSERT INTO components (
	category,
	marking,
	information,
	price)

VALUE (
'FRONT-WHEEL',
'MF 30',
'4" литые, резиновые, черные',
0.0);


INSERT INTO components (
	category,
	marking,
	information,
	price)

VALUE (
'FRONT-WHEEL',
'MF 35',
'4" Froglegs  мягкие, алючиниевые',
10500.0);


INSERT INTO components (
	category,
	marking,
	information,
	price)

VALUE (
'FRONT-WHEEL',
'MF 31',
'5" литые, резиновые, черные',
0.0);


INSERT INTO components (
	category,
	marking,
	information,
	price)

VALUE (
'FRONT-WHEEL',
'MF 36',
'5" мягкие, алюминиевые',
10500.0);


INSERT INTO components (
	category,
	marking,
	information,
	price)

VALUE (
'FRONT-WHEEL',
'MF 04',
'5,5" мягкая резина, литые, серые',
0.0);


INSERT INTO components (
	category,
	marking,
	information,
	price)

VALUE (
'FRONT-WHEEL',
'MF 32',
'6" литые, резиновые, черные',
0.0);



INSERT INTO components (
	category,
	marking,
	information,
	price)

VALUE (
'FRONT-WHEEL',
'MF 37',
'6" мягкие, алюминиевые',
10500.0);


INSERT INTO components (
	category,
	marking,
	information,
	price)

VALUE (
'BACK-WHEEL',
'MG 04',
'20"',
0.0);


INSERT INTO components (
	category,
	marking,
	information,
	price)

VALUE (
'BACK-WHEEL',
'MG 01',
'22"',
0.0);


INSERT INTO components (
	category,
	marking,
	information,
	price)

VALUE (
'BACK-WHEEL',
'MG 02',
'24" (от ГС 28 см)',
0.0);


INSERT INTO components (
	category,
	marking,
	information,
	price)

VALUE (
'FOOTREST',
'MB 01',
'Объединенная, регулируемая по углу наклона опора, 12.5 см глубина (от ДГ 32 см)',
3500.0);


INSERT INTO components (
	category,
	marking,
	information,
	price)

VALUE (
'FOOTREST',
'MB 03',
'Объединенная, регулируемая по углу наклона опора, 16 см глубина (от ДГ 32 см)',
0.0);


INSERT INTO components (
	category,
	marking,
	information,
	price)

VALUE (
'FOOTREST',
'MB 10',
'Раздельные подножки, регулируемые по углу опоры 16 см глубина (от ДГ 32 см)',
0.0);


INSERT INTO components (
	category,
	marking,
	information,
	price)

VALUE (
'FOOTREST',
'MB 19',
'Раздельные укороченные подножки (для ДГ 16 - 31 см)',
2300.0);


INSERT INTO components (
	category,
	marking,
	information,
	price)

VALUE (
'FOOTREST',
'MB 20',
'Объединенная укороченная подножка (для ДГ 16 - 31 см)',
6600.0);