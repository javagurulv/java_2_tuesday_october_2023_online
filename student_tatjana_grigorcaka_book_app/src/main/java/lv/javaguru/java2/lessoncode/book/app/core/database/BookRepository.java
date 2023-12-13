package lv.javaguru.java2.lessoncode.book.app.core.database;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BookRepository {

	@Autowired private JdbcTemplate jdbcTemplate;

	public void save(Book book) {
		jdbcTemplate.update(
				"INSERT INTO books (title, author, issue_year) "
						+ "VALUES (?, ?, ?)",
				book.getTitle(), book.getAuthor(), book.getIssueYear()
		);
	}



}
