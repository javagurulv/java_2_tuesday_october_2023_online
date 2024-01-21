package lv.javaguru.java2.lessoncode.book.app.core.services.validators;

import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaBookRepository;
import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaReaderBookRepository;
import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaReaderRepository;
import lv.javaguru.java2.lessoncode.book.app.core.domain.ReaderBook;
import lv.javaguru.java2.lessoncode.book.app.core.requests.ReturnBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ReturnBookRequestValidator {

	@Autowired private JpaReaderRepository readerRepository;
	@Autowired private JpaBookRepository bookRepository;

	@Autowired private JpaReaderBookRepository readerBookRepository;

	public List<CoreError> validate(ReturnBookRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateReaderBookIdEmpty(request).ifPresent(errors::add);
		validateReaderBookIdExistInDb(request).ifPresent(errors::add);
		return errors;
	}

	private Optional<CoreError> validateReaderBookIdEmpty(ReturnBookRequest request) {
		return (request.getId() == null)
				? Optional.of(new CoreError("readerBookId", "Must not be empty!"))
				: Optional.empty();
	}


	private Optional<CoreError> validateReaderBookIdExistInDb(ReturnBookRequest request) {
		if (request.getId() != null) {
			Optional<ReaderBook> readerBookOpt = readerBookRepository.findById(request.getId());
			return (readerBookOpt.isEmpty())
					? Optional.of(new CoreError("readerBookId", "Not exist!"))
					: Optional.empty();
		} else {
			return Optional.empty();
		}
	}



}
