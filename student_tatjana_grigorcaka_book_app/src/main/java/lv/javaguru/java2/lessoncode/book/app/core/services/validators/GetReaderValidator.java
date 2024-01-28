package lv.javaguru.java2.lessoncode.book.app.core.services.validators;

import lv.javaguru.java2.lessoncode.book.app.core.requests.GetReaderRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GetReaderValidator {

	public List<CoreError> validate(GetReaderRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateId(request).ifPresent(errors::add);
		return errors;
	}

	private Optional<CoreError> validateId(GetReaderRequest request) {
		return (request.getId() == null)
				? Optional.of(new CoreError("id", "Must not be empty!"))
				: Optional.empty();
	}

}