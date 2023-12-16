package lv.javaguru.java2.product.storage.core.database;

import lv.javaguru.java2.product.storage.core.domain.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setId(rs.getLong("id"));
		product.setProductName(rs.getString("product_name"));
		product.setProductBrand(rs.getString("product_brand"));
		product.setProductModel(rs.getString("product_model"));
		product.setProductQuantity(rs.getInt("product_quantity"));
		product.setPriceInStock(rs.getBigDecimal("price_in_stock"));
		return product;
	}

}