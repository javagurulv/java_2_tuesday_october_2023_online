package lv.javaguru.java2.product.storage.core.database;

import lv.javaguru.java2.product.storage.core.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
class JdbcProductRepositoryImpl implements ProductRepository {

	@Autowired private JdbcTemplate jdbcTemplate;

	@Override
	public void save(Product product) {
		jdbcTemplate.update(
				"INSERT INTO products (product_name, product_brand, product_model, product_quantity, price_in_stock) "
						+ "VALUES (?, ?, ?, ?, ?)",
				product.getProductName(), product.getProductBrand(), product.getProductModel(), product.getProductQuantity(), product.getPriceInStock()
		);
	}

	@Override
	public boolean deleteById(Long id) {
		String sql = "DELETE FROM products WHERE id = ?";
		Object[] args = new Object[] {id};
		return jdbcTemplate.update(sql, args) == 1;
	}

	@Override
	public List<Product> getAllProducts() {
		String sql = "SELECT * FROM products";
		return jdbcTemplate.query(sql, new ProductRowMapper());
	}

	@Override
	public List<Product> findByProductBrand(String productBrand) {
		String sql = "SELECT * FROM products WHERE product_brand = ?";
		Object[] args = new Object[] {productBrand};
		return jdbcTemplate.query(sql, new ProductRowMapper(), args);
	}

	@Override
	public List<Product> findByProductModel(String productModel) {
		String sql = "SELECT * FROM products WHERE product_model = ?";
		Object[] args = new Object[] {productModel};
		return jdbcTemplate.query(sql, new ProductRowMapper(), args);
	}

	@Override
	public List<Product> findByProductBrandAndProductModel(String productBrand, String productModel) {
		String sql = "SELECT * FROM products WHERE product_brand = ? AND product_model = ? ";
		Object[] args = new Object[] {productBrand, productModel};
		return jdbcTemplate.query(sql, new ProductRowMapper(), args);
	}
}
