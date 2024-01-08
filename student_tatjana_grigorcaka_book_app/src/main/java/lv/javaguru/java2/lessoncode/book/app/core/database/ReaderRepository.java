package lv.javaguru.java2.lessoncode.book.app.core.database;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Book;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Reader;

import java.util.List;
import java.util.Optional;

public interface ReaderRepository {

    void save(Reader reader);

    Reader findById(Long id);

    Optional<Reader> getById(Long id);

    boolean deleteById(Long id);

    List<Reader> getAllReaders();

    List<Reader> findByFirstName(String firstName);

    List<Reader> findByLastName(String lastName);

    List<Reader> findByPersonalCode(String personalCode);

    List<Reader> findByFirstNameAndLastName(String firstName, String lastName);

    List<Reader> findByFirstNameAndLastNameAndPersonalCode(String firstName, String lastName, String personalCode);

}
