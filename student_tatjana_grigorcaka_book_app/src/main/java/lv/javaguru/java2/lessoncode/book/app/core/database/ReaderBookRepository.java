package lv.javaguru.java2.lessoncode.book.app.core.database;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Reader;
import lv.javaguru.java2.lessoncode.book.app.core.domain.ReaderBook;

import java.util.List;
import java.util.Optional;

public interface ReaderBookRepository {

    void save(ReaderBook readerBook);

    Optional<ReaderBook> getById(Long id);

    boolean deleteById(Long id);

    List<ReaderBook> getAllReaderBooks(Reader reader);


}
