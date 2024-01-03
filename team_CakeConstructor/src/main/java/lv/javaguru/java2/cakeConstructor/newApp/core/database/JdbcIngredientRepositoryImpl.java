package lv.javaguru.java2.cakeConstructor.newApp.core.database;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

//@Component
class JdbcIngredientRepositoryImpl implements IngredientRepository {

	@Autowired private JdbcTemplate jdbcTemplate;

	@Override
	public void save(Ingredient ingredient) {
		jdbcTemplate.update(
				"INSERT INTO ingredients (type, taste) "
						+ "VALUES (?, ?)",
				ingredient.getType(), ingredient.getTaste()
		);
	}

	@Override
	public Optional<Ingredient> getById(Long id) { return Optional.empty(); }

	@Override
	public boolean deleteById(Long id) {
		String sql = "DELETE FROM ingredients WHERE id = ?";
		Object[] args = new Object[] {id};
		return jdbcTemplate.update(sql, args) == 1;
	}

	@Override
	public List<Ingredient> getAllIngredients() {
		String sql = "SELECT * FROM ingredients";
		return jdbcTemplate.query(sql, new IngredientRowMapper());
	}

	@Override
	public List<Ingredient> findByType(String type) {
		String sql = "SELECT * FROM ingredients WHERE type = ?";
		Object[] args = new Object[] {type};
		return jdbcTemplate.query(sql, new IngredientRowMapper(), args);
	}

	@Override
	public List<Ingredient> findByTaste(String taste) {
		String sql = "SELECT * FROM ingredients WHERE taste = ?";
		Object[] args = new Object[] {taste};
		return jdbcTemplate.query(sql, new IngredientRowMapper(), args);
	}

	@Override
	public List<Ingredient> findByTypeAndTaste(String type, String taste) {
		String sql = "SELECT * FROM ingredients WHERE type = ? AND taste = ? ";
		Object[] args = new Object[] {type, taste};
		return jdbcTemplate.query(sql, new IngredientRowMapper(), args);
	}
}
