SELECT * FROM ingredients;
SELECT * FROM cakes;
SELECT * FROM cake_ingredients;

SELECT * FROM ingredients WHERE id = 1002;
SELECT * FROM cakes WHERE id = 1005;
SELECT * FROM cake_ingredients WHERE id = 1004;

SELECT type, taste FROM ingredients WHERE id = 1002;
SELECT cake_name FROM cakes WHERE id = 1005;
SELECT ingredient_id FROM cake_ingredients WHERE cake_id = 1002;

SELECT * FROM ingredients WHERE type = "Biscuit";
Select * FROM cakes WHERE cake_name = "Lemon Cheese Cake";


SELECT * FROM ingredients WHERE type = "Biscuit" OR taste = "Vanilla";
SELECT * FROM ingredients WHERE type = "Biscuit" AND taste = "Vanilla";

SELECT * FROM ingredients
LIMIT 1,3;

SELECT type, taste FROM ingredients
ORDER BY type ASC;

SELECT type, taste FROM ingredients
ORDER BY type DESC;

SELECT COUNT(*) FROM ingredients;


