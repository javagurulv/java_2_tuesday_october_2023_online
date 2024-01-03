DELETE FROM ingredients;  //не работает
DELETE FROM cakes;
DELETE FROM cake_ingredients;

DELETE FROM ingredients WHERE id != 0;
DELETE FROM cakes WHERE id != 0;
DELETE FROM cake_ingredients WHERE id != 0;

DELETE FROM ingredients WHERE id = 1008;


DROP TABLE IF EXISTS `ingredients`

DROP SCHEMA `cake_constructor` ;


DROP INDEX ix_ingredients_type_taste
ON cake_constructor.ingredients;

DROP INDEX ix_clients_first_name_last_name_personal_code
ON cake_constructor.clients;




