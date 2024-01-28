package lv.javaguru.java2.lessoncode.book.app.core.services;

import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaReaderRepository;
import lv.javaguru.java2.lessoncode.book.app.core.requests.GetReaderRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import lv.javaguru.java2.lessoncode.book.app.core.responses.GetReaderResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.validators.GetReaderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetReaderService {

	@Autowired private JpaReaderRepository readerRepository;
	@Autowired private GetReaderValidator validator;

	public GetReaderResponse execute(GetReaderRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new GetReaderResponse(errors);
		}
		return readerRepository.findById(request.getId())
				.map(GetReaderResponse::new)
				.orElseGet(() -> {
					errors.add(new CoreError("id", "Not found!"));
					return new GetReaderResponse(errors);
				});
	}

}