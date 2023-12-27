SELECT *
FROM cake_constructor.ingredients_cake
JOIN cake_constructor.cakes ON cake_constructor.ingredients_cake.cake_id = cake_constructor.cakes.id
WHERE ingredient_id = 1004;

SELECT cake_name
FROM cake_constructor.ingredients_cake
JOIN cake_constructor.cakes ON cake_constructor.ingredients_cake.cake_id = cake_constructor.cakes.id
WHERE ingredient_id = 1004;


SELECT ingredient_id, type, taste, count(ingredient_id)
FROM cake_constructor.ingredients_cake
JOIN cake_constructor.ingredients ON cake_constructor.ingredients_cake.ingredient_id = cake_constructor.ingredients.id
GROUP BY taste
ORDER BY count(ingredient_id) desc;

SELECT ingredient_id, type, taste, count(ingredient_id)
FROM cake_constructor.ingredients_cake
JOIN cake_constructor.ingredients ON cake_constructor.ingredients_cake.ingredient_id = cake_constructor.ingredients.id
GROUP BY taste
ORDER BY count(ingredient_id) asc;




