package lv.javaguru.java2.cakeConstructor.newApp.core.database;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Ingredient;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredientRowMapper implements RowMapper<Ingredient> {

	@Override
	public Ingredient mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ingredient ingredient = new Ingredient();
		ingredient.setId(rs.getLong("id"));
		ingredient.setType(rs.getString("type"));
		ingredient.setTaste(rs.getString("taste"));
		return ingredient;
	}

}