package lv.javaguru.java2.cakeConstructor.newApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseCleaner {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void clean() {
		for(String tableName : getTableNames()) {
			String sql = "delete from " + tableName;
			jdbcTemplate.execute(sql);
		}
	}

	private List<String> getTableNames() {
		List<String> tableNames = new ArrayList<>();
		tableNames.add("ingredients_cake");
		tableNames.add("cakes");
		tableNames.add("ingredients");
		return tableNames;
	}

}