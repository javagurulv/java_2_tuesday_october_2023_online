INSERT INTO `category` (title)
VALUES ("FRONT-WHEEL");

INSERT INTO `category` (title)
VALUES ("BACK-WHEEL");

INSERT INTO `category` (title)
VALUES ("BRAKE");

INSERT INTO `category` (title)
VALUES ("FOOTREST");


INSERT INTO components (
	category_key,
	marking,
	information,
	price)

SELECT
cl.id,
'MH 01',
'На уровне коленей пользователя, стандарт',
0.0
FROM `category` as cl
WHERE cl.title = 'BRAKE';

INSERT INTO components (
	category_key,
	marking,
	information,
	price)

SELECT
cl.id,
'MH 02',
'На уровне коленей пользователя, стандарт, короткая ручка тормоза',
1500.0
FROM `category` as cl
WHERE cl.title = 'BRAKE';

INSERT INTO components (
	category_key,
	marking,
	information,
	price)

SELECT
cl.id,
'MH 07',
'На уровне коленей пользователя, регулируемая по длине ручка тормоза',
5700.0
FROM `category` as cl
WHERE cl.title = 'BRAKE';

INSERT INTO components (
	category_key,
	marking,
	information,
	price)

SELECT
cl.id,
'MF 30',
'4" литые, резиновые, черные',
0.0
FROM `category` as cl
WHERE cl.title = 'FRONT-WHEEL';

INSERT INTO components (
	category_key,
	marking,
	information,
	price)

SELECT
cl.id,
'MF 35',
'4" Froglegs  мягкие, алючиниевые',
10500.0
FROM `category` as cl
WHERE cl.title = 'FRONT-WHEEL';

INSERT INTO components (
	category_key,
	marking,
	information,
	price)

SELECT
cl.id,
'MF 31',
'5" литые, резиновые, черные',
0.0
FROM `category` as cl
WHERE cl.title = 'FRONT-WHEEL';

INSERT INTO components (
	category_key,
	marking,
	information,
	price)

SELECT
cl.id,
'MF 36',
'5" мягкие, алюминиевые',
10500.0
FROM `category` as cl
WHERE cl.title = 'FRONT-WHEEL';

INSERT INTO components (
	category_key,
	marking,
	information,
	price)

SELECT
cl.id,
'MF 04',
'5,5" мягкая резина, литые, серые',
0.0
FROM `category` as cl
WHERE cl.title = 'FRONT-WHEEL';

INSERT INTO components (
	category_key,
	marking,
	information,
	price)

SELECT
cl.id,
'MF 32',
'6" литые, резиновые, черные',
0.0
FROM `category` as cl
WHERE cl.title = 'FRONT-WHEEL';

INSERT INTO components (
	category_key,
	marking,
	information,
	price)

SELECT
cl.id,
'MF 37',
'6" мягкие, алюминиевые',
10500.0
FROM `category` as cl
WHERE cl.title = 'FRONT-WHEEL';

INSERT INTO components (
	category_key,
	marking,
	information,
	price)

SELECT
cl.id,
'MG 04',
'20"',
0.0
FROM `category` as cl
WHERE cl.title = 'BACK-WHEEL';

INSERT INTO components (
	category_key,
	marking,
	information,
	price)

SELECT
cl.id,
'MG 01',
'22"',
0.0
FROM `category` as cl
WHERE cl.title = 'BACK-WHEEL';

INSERT INTO components (
	category_key,
	marking,
	information,
	price)

SELECT
cl.id,
'MG 02',
'24" (от ГС 28 см)',
0.0
FROM `category` as cl
WHERE cl.title = 'BACK-WHEEL';

INSERT INTO components (
	category_key,
	marking,
	information,
	price)

SELECT
cl.id,
'MB 01',
'Объединенная, регулируемая по углу наклона опора, 12.5 см глубина (от ДГ 32 см)',
3500.0
FROM `category` as cl
WHERE cl.title = 'FOOTREST';

INSERT INTO components (
	category_key,
	marking,
	information,
	price)

SELECT
cl.id,
'MB 03',
'Объединенная, регулируемая по углу наклона опора, 16 см глубина (от ДГ 32 см)',
0.0
FROM `category` as cl
WHERE cl.title = 'FOOTREST';

INSERT INTO components (
	category_key,
	marking,
	information,
	price)

SELECT
cl.id,
'MB 10',
'Раздельные подножки, регулируемые по углу опоры 16 см глубина (от ДГ 32 см)',
0.0
FROM `category` as cl
WHERE cl.title = 'FOOTREST';

INSERT INTO components (
	category_key,
	marking,
	information,
	price)

SELECT
cl.id,
'MB 19',
'Раздельные укороченные подножки (для ДГ 16 - 31 см)',
2300.0
FROM `category` as cl
WHERE cl.title = 'FOOTREST';

INSERT INTO components (
	category_key,
	marking,
	information,
	price)

SELECT
cl.id,
'MB 20',
'Объединенная укороченная подножка (для ДГ 16 - 31 см)',
6600.0
FROM `category` as cl
WHERE cl.title = 'FOOTREST';