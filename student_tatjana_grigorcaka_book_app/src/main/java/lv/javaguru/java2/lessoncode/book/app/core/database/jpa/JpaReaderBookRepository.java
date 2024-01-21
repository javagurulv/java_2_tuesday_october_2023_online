package lv.javaguru.java2.lessoncode.book.app.core.database.jpa;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Book;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Reader;
import lv.javaguru.java2.lessoncode.book.app.core.domain.ReaderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface JpaReaderBookRepository extends JpaRepository<ReaderBook, Long> {

      @Query(value = "SELECT * FROM book_app.reader_books rb WHERE rb.book_id = :bookId AND rb.book_out_date IS NOT NULL AND rb.book_return_date IS NULL order by rb.id desc limit 1", nativeQuery = true)
      Optional<ReaderBook> findByBookId(@Param("bookId") Long bookId);









}
