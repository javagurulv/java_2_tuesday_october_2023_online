package lv.javaguru.java2.lessoncode.book.app.core.services;

import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaReaderBookRepository;
import lv.javaguru.java2.lessoncode.book.app.core.requests.GetReaderBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import lv.javaguru.java2.lessoncode.book.app.core.responses.GetReaderBookResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.validators.GetReaderBookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetReaderBookService {

	@Autowired private JpaReaderBookRepository readerBookRepository;
	@Autowired private GetReaderBookValidator validator;

	public GetReaderBookResponse execute(GetReaderBookRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new GetReaderBookResponse(errors);
		}
		return readerBookRepository.findById(request.getId())
				.map(GetReaderBookResponse::new)
				.orElseGet(() -> {
					errors.add(new CoreError("id", "Not found!"));
					return new GetReaderBookResponse(errors);
				});
	}

}