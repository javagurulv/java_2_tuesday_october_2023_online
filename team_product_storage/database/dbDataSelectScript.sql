SELECT * FROM products;
SELECT * FROM customers;
SELECT * FROM orders;
SELECT * FROM order_items;

SELECT * FROM products WHERE id = 1002;
SELECT * FROM customers WHERE id = 1003;
SELECT * FROM orders WHERE id = 1004;
SELECT * FROM order_items WHERE id = 1005;

SELECT product_name FROM products WHERE id = 1002;
SELECT customer_name FROM customers WHERE id = 1004;
SELECT customer_id FROM orders WHERE id = 1007;
SELECT product_id FROM order_items WHERE order_id = 1002;

SELECT * FROM products WHERE product_brand = "Apple";
Select * FROM customers WHERE customer_name = "Store Riga Plaza";
Select * FROM customers WHERE customer_code = "112131K";

SELECT * FROM products WHERE product_brand = "Apple" OR product_model = "iPhone 15";
SELECT * FROM customers WHERE customer_name = "Store Riga Plaza" AND registration_code = "112131K";

SELECT * FROM products
LIMIT 1,3;

SELECT product_brand, product_model FROM products
ORDER BY product_brand ASC;

SELECT product_brand, product_model FROM products
ORDER BY product_brand DESC;

SELECT COUNT(*) FROM products;


