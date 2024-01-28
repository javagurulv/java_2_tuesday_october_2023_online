package lv.javaguru.java2.lessoncode.book.app.core.services.validators;

import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaBookRepository;
import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaReaderBookRepository;
import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaReaderRepository;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Book;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Reader;
import lv.javaguru.java2.lessoncode.book.app.core.domain.ReaderBook;
import lv.javaguru.java2.lessoncode.book.app.core.requests.AddBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.requests.ReturnBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.requests.TakeBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TakeBookRequestValidator {

	@Autowired
	private JpaReaderRepository readerRepository;
	@Autowired
	private JpaBookRepository bookRepository;
	@Autowired
	private JpaReaderBookRepository readerBookRepository;

	public List<CoreError> validate(TakeBookRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateReaderIdEmpty(request).ifPresent(errors::add);
		validateBookIdEmpty(request).ifPresent(errors::add);
		validateReaderIdExistInDb(request).ifPresent(errors::add);
		validateBookIdExistInDb(request).ifPresent(errors::add);
		validateBookAvailable(request).ifPresent(errors::add);
		return errors;
	}

	private Optional<CoreError> validateReaderIdEmpty(TakeBookRequest request) {
		return (request.getReaderId() == null)
				? Optional.of(new CoreError("readerId", "Must not be empty!"))
				: Optional.empty();
	}

	private Optional<CoreError> validateBookIdEmpty(TakeBookRequest request) {
		return (request.getBookId() == null)
				? Optional.of(new CoreError("bookId", "Must not be empty!"))
				: Optional.empty();
	}

	private Optional<CoreError> validateReaderIdExistInDb(TakeBookRequest request) {
		if (request.getReaderId() != null) {
			Optional<Reader> readerOpt = readerRepository.findById(request.getReaderId());
			return (readerOpt.isEmpty())
					? Optional.of(new CoreError("readerId", "Not exist!"))
					: Optional.empty();
		} else {
			return Optional.empty();
		}
	}

	private Optional<CoreError> validateBookIdExistInDb(TakeBookRequest request) {
		if (request.getBookId() != null) {
			Optional<Book> bookOpt = bookRepository.findById(request.getBookId());
			return (bookOpt.isEmpty())
					? Optional.of(new CoreError("bookId", "Not exist!"))
					: Optional.empty();
		} else {
			return Optional.empty();
		}
	}

	private Optional<CoreError> validateBookAvailable(TakeBookRequest request) {
		if (request.getBookId() != null) {
			Optional<ReaderBook> readerBookOpt = readerBookRepository.findByBookId(request.getBookId());
			return (!readerBookOpt.isEmpty())
					? Optional.of(new CoreError("bookOutDate / bookReturnDate", "Book not available!"))
					: Optional.empty();
		} else {
			return Optional.empty();
		}
	}
}







