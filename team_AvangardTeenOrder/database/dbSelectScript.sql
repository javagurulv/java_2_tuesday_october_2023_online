sELECT * FROM clients
where nameSurname = "Ivanov"
AND personalCode = 22222;

Select sum(price) from `components`
join `order_components` on
 components.id = order_components.component_id
where wheelchair_id = 10;


select * from order_components
join components
join wheelchairs
where wheelchairs.id=order_components.wheelchair_id
and components.id=order_components.component_id
and wheelchairs.id = 10;

SELECT * FROM `components`;
SELECT * FROM `clients`;
SELECT * FROM `order_components`;
SELECT * FROM `wheelchairs`;
SELECT *FROM `parameters`;