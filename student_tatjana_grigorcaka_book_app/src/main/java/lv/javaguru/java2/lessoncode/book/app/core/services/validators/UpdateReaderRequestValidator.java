package lv.javaguru.java2.lessoncode.book.app.core.services.validators;

import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaReaderRepository;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Reader;
import lv.javaguru.java2.lessoncode.book.app.core.requests.UpdateReaderRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UpdateReaderRequestValidator {

	@Autowired
	private JpaReaderRepository readerRepository;

	public List<CoreError> validate(UpdateReaderRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateReaderIdEmpty(request).ifPresent(errors::add);
		validateReaderIdExistInDb(request).ifPresent(errors::add);
		validateFirstName(request).ifPresent(errors::add);
		validateLastName(request).ifPresent(errors::add);
		validatePersonalCode(request).ifPresent(errors::add);

		return errors;
	}

	private Optional<CoreError> validateReaderIdEmpty(UpdateReaderRequest request) {
		return (request.getId() == null)
				? Optional.of(new CoreError("readerId", "Must not be empty!"))
				: Optional.empty();
	}

	private Optional<CoreError> validateReaderIdExistInDb(UpdateReaderRequest request) {
		if (request.getId() != null) {
			Optional<Reader> readerOpt = readerRepository.findById(request.getId());
			return (readerOpt.isEmpty())
					? Optional.of(new CoreError("readerId", "Not exist!"))
					: Optional.empty();
		} else {
			return Optional.empty();
		}
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
