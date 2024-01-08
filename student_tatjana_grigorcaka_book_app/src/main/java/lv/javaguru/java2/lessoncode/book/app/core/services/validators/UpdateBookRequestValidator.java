package lv.javaguru.java2.lessoncode.book.app.core.services.validators;

import lv.javaguru.java2.lessoncode.book.app.core.requests.UpdateBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UpdateBookRequestValidator {

	public List<CoreError> validate(UpdateBookRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateTitle(request).ifPresent(errors::add);
		validateAuthor(request).ifPresent(errors::add);
		validateIssueYear(request).ifPresent(errors::add);

		return errors;
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
		return ((request.getNewIssueYear() <= 0))
				? Optional.of(new CoreError("newIssueYear", "Must be greater than 0!"))
				: Optional.empty();
	}


}
