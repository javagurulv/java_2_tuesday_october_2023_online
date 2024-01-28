package lv.javaguru.java2.lessoncode.book.app.core.database.jpa;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JpaBookRepository extends JpaRepository<Book, Long> {

	List<Book> findByTitle(String title);

	@Query("SELECT b FROM Book b WHERE b.title LIKE %:title%")
	List<Book> findByTitleLike(@Param("title") String title);

	@Query(value = "select * from books where author = :author",
			nativeQuery = true)
	List<Book> findByAuthor(@Param("author") String author);

	@Query("SELECT b FROM Book b WHERE b.author LIKE %:author%")
	List<Book> findByAuthorLike(@Param("author") String author);

	List<Book> findByTitleAndAuthor(String title, String author);

	@Query("SELECT b FROM Book b WHERE b.title LIKE %:title% AND b.author LIKE %:author%")
	List<Book> findByTitleAndAuthorLike(@Param("title") String title,
										@Param("author") String author);

	List<Book> findByTitleAndAuthorAndIssueYear(String title, String author, Integer issueYear);


	@Query("SELECT b FROM Book b WHERE b.title LIKE %:title% AND b.author LIKE %:author% AND b.issueYear LIKE %:issueYear%")
	List<Book> findByTitleAndAuthorAndIssueYearLike(@Param("title") String title,
													@Param("author") String author,
	                                                @Param("issueYear") Integer issueYear);

}

