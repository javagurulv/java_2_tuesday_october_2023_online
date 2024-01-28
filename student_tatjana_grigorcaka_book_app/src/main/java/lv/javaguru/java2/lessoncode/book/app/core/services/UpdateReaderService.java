package lv.javaguru.java2.lessoncode.book.app.core.services;

import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaReaderRepository;
import lv.javaguru.java2.lessoncode.book.app.core.requests.UpdateReaderRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import lv.javaguru.java2.lessoncode.book.app.core.responses.UpdateReaderResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.validators.UpdateReaderRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class UpdateReaderService {

	@Autowired private JpaReaderRepository readerRepository;
	@Autowired private UpdateReaderRequestValidator validator;

	public UpdateReaderResponse execute(UpdateReaderRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new UpdateReaderResponse(errors);
		}

		return readerRepository.findById(request.getId())
				.map(reader -> {
					reader.setFirstName(request.getNewFirstName());
					reader.setLastName(request.getNewLastName());
					reader.setPersonalCode(request.getNewPersonalCode());
					return new UpdateReaderResponse(reader);
				})
				.orElseGet(() -> {
					errors.add(new CoreError("id", "Not found!"));
					return new UpdateReaderResponse(errors);
				});
	}

}