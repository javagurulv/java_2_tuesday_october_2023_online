DELETE FROM products;  //не работает
DELETE FROM customers;
DELETE FROM orders;
DELETE FROM order_items;

DELETE FROM products WHERE id != 0;
DELETE FROM customers WHERE id != 0;
DELETE FROM orders WHERE id != 0;
DELETE FROM order_items WHERE id != 0;

DELETE FROM products WHERE id = 1020;

DROP TABLE IF EXISTS `products`

DROP SCHEMA `product_storage` ;



