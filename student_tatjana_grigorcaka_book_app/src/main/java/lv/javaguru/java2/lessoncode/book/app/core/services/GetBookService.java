package lv.javaguru.java2.lessoncode.book.app.core.services;

import lv.javaguru.java2.lessoncode.book.app.core.database.BookRepository;
import lv.javaguru.java2.lessoncode.book.app.core.requests.GetBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import lv.javaguru.java2.lessoncode.book.app.core.responses.GetBookResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.validators.GetBookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetBookService {

	@Autowired private BookRepository bookRepository;
	@Autowired private GetBookValidator validator;

	public GetBookResponse execute(GetBookRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new GetBookResponse(errors);
		}
		return bookRepository.getById(request.getId())
				.map(GetBookResponse::new)
				.orElseGet(() -> {
					errors.add(new CoreError("id", "Not found!"));
					return new GetBookResponse(errors);
				});
	}

}