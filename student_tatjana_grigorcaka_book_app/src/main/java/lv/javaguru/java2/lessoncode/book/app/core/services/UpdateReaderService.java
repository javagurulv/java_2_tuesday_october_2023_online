package lv.javaguru.java2.lessoncode.book.app.core.services;

import lv.javaguru.java2.lessoncode.book.app.core.database.ReaderRepository;
import lv.javaguru.java2.lessoncode.book.app.core.requests.UpdateBookRequest;
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

	@Autowired private ReaderRepository readerRepository;
	@Autowired private UpdateReaderRequestValidator validator;

	public UpdateReaderResponse execute(UpdateReaderRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new UpdateReaderResponse(errors);
		}

		return readerRepository.getById(request.getId())
				.map(book -> {
					book.setFirstName(request.getNewFirstName());
					book.setLastName(request.getNewLastName());
					book.setPersonalCode(request.getNewPersonalCode());
					return new UpdateReaderResponse(book);
				})
				.orElseGet(() -> {
					errors.add(new CoreError("id", "Not found!"));
					return new UpdateReaderResponse(errors);
				});
	}

}