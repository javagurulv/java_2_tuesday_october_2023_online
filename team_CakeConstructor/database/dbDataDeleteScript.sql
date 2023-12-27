DELETE FROM ingredients;  //не работает
DELETE FROM cakes;
DELETE FROM ingredients_cake;

DELETE FROM ingredients WHERE id != 0;
DELETE FROM cakes WHERE id != 0;
DELETE FROM ingredients_cake WHERE id != 0;

DELETE FROM ingredients WHERE id = 1008;




