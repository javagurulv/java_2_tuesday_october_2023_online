package lv.javaguru.java2.lessoncode.book.app.core.services.validators;

import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaReaderRepository;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Reader;
import lv.javaguru.java2.lessoncode.book.app.core.requests.DeleteReaderRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DeleteReaderValidator {

	@Autowired private JpaReaderRepository readerRepository;

	public List<CoreError> validate(DeleteReaderRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateId(request).ifPresent(errors::add);
		validateIdExistInDb(request).ifPresent(errors::add);
		return errors;
	}

	private Optional<CoreError> validateId(DeleteReaderRequest request) {
		return (request.getId() == null)
				? Optional.of(new CoreError("readerId", "Must not be empty!"))
				: Optional.empty();
	}

	private Optional<CoreError> validateIdExistInDb(DeleteReaderRequest request) {
		if (request.getId() != null) {
			Optional<Reader> readerOpt = readerRepository.findById(request.getId());
			return (readerOpt.isEmpty())
					? Optional.of(new CoreError("readerId", "Not exist!"))
					: Optional.empty();
		} else {
			return Optional.empty();
		}
	}

}