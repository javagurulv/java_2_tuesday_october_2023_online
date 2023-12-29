package lv.javaguru.java2.lessoncode.book.app.core.services;

import lv.javaguru.java2.lessoncode.book.app.core.database.ReaderRepository;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Reader;
import lv.javaguru.java2.lessoncode.book.app.core.requests.RegisterReaderRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import lv.javaguru.java2.lessoncode.book.app.core.responses.RegisterReaderResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.validators.RegisterReaderRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class RegisterReaderService {

	@Autowired private ReaderRepository readerRepository;
	@Autowired private RegisterReaderRequestValidator validator;

	public RegisterReaderResponse execute(RegisterReaderRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new RegisterReaderResponse(errors);
		}

		Reader reader = new Reader(request.getFirstName(), request.getLastName(), request.getPersonalCode());
		readerRepository.save(reader);

		return new RegisterReaderResponse(reader);
	}

}