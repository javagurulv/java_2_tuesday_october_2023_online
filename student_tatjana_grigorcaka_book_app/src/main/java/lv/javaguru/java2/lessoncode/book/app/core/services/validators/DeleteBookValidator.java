package lv.javaguru.java2.lessoncode.book.app.core.services.validators;

import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaBookRepository;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Book;
import lv.javaguru.java2.lessoncode.book.app.core.requests.DeleteBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DeleteBookValidator {

	@Autowired private JpaBookRepository bookRepository;

	public List<CoreError> validate(DeleteBookRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateId(request).ifPresent(errors::add);
		validateIdExistInDb(request).ifPresent(errors::add);
		return errors;
	}

	private Optional<CoreError> validateId(DeleteBookRequest request) {
		return (request.getId() == null)
				? Optional.of(new CoreError("bookId", "Must not be empty!"))
				: Optional.empty();
	}

	private Optional<CoreError> validateIdExistInDb(DeleteBookRequest request) {
		if (request.getId() != null) {
			Optional<Book> bookOpt = bookRepository.findById(request.getId());
			return (bookOpt.isEmpty())
					? Optional.of(new CoreError("bookId", "Not exist!"))
					: Optional.empty();
		} else {
			return Optional.empty();
		}
	}

}