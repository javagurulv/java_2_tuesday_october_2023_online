package lv.javaguru.java2.lessoncode.book.app.core.services.validators;

import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaBookRepository;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Book;
import lv.javaguru.java2.lessoncode.book.app.core.requests.UpdateBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UpdateBookRequestValidator {

	@Autowired private JpaBookRepository bookRepository;

	public List<CoreError> validate(UpdateBookRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateBookIdEmpty(request).ifPresent(errors::add);
		validateBookIdExistInDb(request).ifPresent(errors::add);
		validateTitle(request).ifPresent(errors::add);
		validateAuthor(request).ifPresent(errors::add);
		validateIssueYear(request).ifPresent(errors::add);
		return errors;
	}


	private Optional<CoreError> validateBookIdEmpty(UpdateBookRequest request) {
		return (request.getId() == null)
				? Optional.of(new CoreError("bookId", "Must not be empty!"))
				: Optional.empty();
	}


	private Optional<CoreError> validateBookIdExistInDb(UpdateBookRequest request) {
		if (request.getId() != null) {
			Optional<Book> bookOpt = bookRepository.findById(request.getId());
			return (bookOpt.isEmpty())
					? Optional.of(new CoreError("bookId", "Not exist!"))
					: Optional.empty();
		} else {
			return Optional.empty();
		}
	}

	private Optional<CoreError> validateTitle(UpdateBookRequest request) {
		return (request.getNewTitle() == null || request.getNewTitle().isEmpty())
			? Optional.of(new CoreError("newTitle", "Must not be empty!"))
			: Optional.empty();
	}

	private Optional<CoreError> validateAuthor(UpdateBookRequest request) {
		return (request.getNewAuthor() == null || request.getNewAuthor().isEmpty())
				? Optional.of(new CoreError("newAuthor", "Must not be empty!"))
				: Optional.empty();
	}

	private Optional<CoreError> validateIssueYear(UpdateBookRequest request) {
		return ((request.getNewIssueYear() == null))
				? Optional.of(new CoreError("newIssueYear", "Must be greater than 0!"))
				: Optional.empty();
	}


}
