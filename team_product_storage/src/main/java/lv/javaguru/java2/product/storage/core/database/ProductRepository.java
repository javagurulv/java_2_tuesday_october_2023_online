package lv.javaguru.java2.product.storage.core.database;

import lv.javaguru.java2.product.storage.core.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductRepository {

	@Autowired private JdbcTemplate jdbcTemplate;

	public void save(Product product) {
		jdbcTemplate.update(
				"INSERT INTO products (product_name, product_brand, product_model, product_quantity, price_in_stock) "
						+ "VALUES (?, ?, ?, ?, ?)",
				product.getProductName(), product.getProductBrand(), product.getProductModel(), product.getProductQuantity(), product.getPriceInStock()
		);
	}



}
