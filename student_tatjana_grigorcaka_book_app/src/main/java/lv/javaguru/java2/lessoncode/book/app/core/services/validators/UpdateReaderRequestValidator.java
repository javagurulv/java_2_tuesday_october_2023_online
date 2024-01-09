package lv.javaguru.java2.lessoncode.book.app.core.services.validators;

import lv.javaguru.java2.lessoncode.book.app.core.requests.UpdateBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.requests.UpdateReaderRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UpdateReaderRequestValidator {

	public List<CoreError> validate(UpdateReaderRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateFirstName(request).ifPresent(errors::add);
		validateLastName(request).ifPresent(errors::add);
		validatePersonalCode(request).ifPresent(errors::add);

		return errors;
	}

	private Optional<CoreError> validateFirstName(UpdateReaderRequest request) {
		return (request.getNewFirstName() == null || request.getNewFirstName().isEmpty())
			? Optional.of(new CoreError("newFirstName", "Must not be empty!"))
			: Optional.empty();
	}

	private Optional<CoreError> validateLastName(UpdateReaderRequest request) {
		return (request.getNewLastName() == null || request.getNewLastName().isEmpty())
				? Optional.of(new CoreError("newLastName", "Must not be empty!"))
				: Optional.empty();
	}

	private Optional<CoreError> validatePersonalCode(UpdateReaderRequest request) {
		return (request.getNewLastName() == null || request.getNewLastName().isEmpty())
				? Optional.of(new CoreError("newPersonalCode", "Must not be empty!"))
				: Optional.empty();
	}


}
