UPDATE products
SET product_name = 'Hand Blender',
	product_brand = 'Tefal',
	product_model = 'Infiny Force',
	product_quantity = 1,
	price_in_stock = 90,
	category = 'KITCHEN'
where id = 1002;

UPDATE products
SET category = "HOME_APPLIANCES"
where id = 1002;

UPDATE products
SET id = "1020"
where id = 1012;


