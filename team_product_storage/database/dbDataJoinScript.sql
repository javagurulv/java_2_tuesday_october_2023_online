SELECT *
FROM product_storage.customers
JOIN product_storage.orders ON product_storage.customers.id = product_storage.orders.customer_id
JOIN product_storage.order_items ON product_storage.orders.id = product_storage.order_items.order_id
WHERE product_storage.order_items.product_id = 1003;

SELECT customer_id, customer_name, registration_code
FROM product_storage.customers
JOIN product_storage.orders ON product_storage.customers.id = product_storage.orders.customer_id
JOIN product_storage.order_items ON product_storage.orders.id = product_storage.order_items.order_id
WHERE product_storage.order_items.product_id = 1003;


SELECT product_id, product_name, product_brand, product_model, count(product_id)
FROM product_storage.order_items
JOIN product_storage.products ON product_storage.order_items.product_id = products.id
GROUP BY product_model
ORDER BY count(product_id) desc;


SELECT product_id, product_name, product_brand, product_model, count(product_id)
FROM product_storage.order_items
JOIN product_storage.products ON product_storage.order_items.product_id = products.id
GROUP BY product_model
ORDER BY count(product_id) asc;




