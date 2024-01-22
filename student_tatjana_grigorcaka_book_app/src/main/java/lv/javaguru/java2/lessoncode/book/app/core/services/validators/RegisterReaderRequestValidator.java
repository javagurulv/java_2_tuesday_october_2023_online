package lv.javaguru.java2.lessoncode.book.app.core.services.validators;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaReaderRepository;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Reader;
import lv.javaguru.java2.lessoncode.book.app.core.requests.RegisterReaderRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class RegisterReaderRequestValidator {

	@Autowired
	private JpaReaderRepository readerRepository;

	public List<CoreError> validate(RegisterReaderRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateFirstName(request).ifPresent(errors::add);
		validateLastName(request).ifPresent(errors::add);
		validatePersonalCode(request).ifPresent(errors::add);
		validateDuplicate(request).ifPresent(errors::add);
		return errors;
	}

	private Optional<CoreError> validateFirstName(RegisterReaderRequest request) {
		return (request.getFirstName() == null || request.getFirstName().isEmpty())
				? Optional.of(new CoreError("firstName", "Must not be empty!"))
				: Optional.empty();
	}

	private Optional<CoreError> validateLastName(RegisterReaderRequest request) {
		return (request.getLastName() == null || request.getLastName().isEmpty())
				? Optional.of(new CoreError("lastName", "Must not be empty!"))
				: Optional.empty();
	}

	private Optional<CoreError> validatePersonalCode(RegisterReaderRequest request) {
		return (request.getPersonalCode() == null || request.getPersonalCode().isEmpty())
				? Optional.of(new CoreError("personalCode", "Must not be empty!"))
				: Optional.empty();
	}

	private Optional<CoreError> validateDuplicate(RegisterReaderRequest request) {
		List<Reader> readers = readerRepository.findByFirstNameAndLastNameAndPersonalCode(request.getFirstName(), request.getLastName(), request.getPersonalCode());
		return (!readers.isEmpty())
				? Optional.of(new CoreError("duplicate", "Duplicate reader not accepted!"))
				: Optional.empty();
	}

}