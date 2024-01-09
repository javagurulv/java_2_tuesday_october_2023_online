package lv.javaguru.java2.lessoncode.book.app.core.services;

import lv.javaguru.java2.lessoncode.book.app.core.database.BookRepository;
import lv.javaguru.java2.lessoncode.book.app.core.requests.UpdateBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import lv.javaguru.java2.lessoncode.book.app.core.responses.UpdateBookResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.validators.UpdateBookRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class UpdateBookService {

	@Autowired private BookRepository bookRepository;
	@Autowired private UpdateBookRequestValidator validator;

	public UpdateBookResponse execute(UpdateBookRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new UpdateBookResponse(errors);
		}

		return bookRepository.getById(request.getId())
				.map(book -> {
					book.setTitle(request.getNewTitle());
					book.setAuthor(request.getNewAuthor());
					book.setIssueYear(request.getNewIssueYear());
					return new UpdateBookResponse(book);
				})
				.orElseGet(() -> {
					errors.add(new CoreError("id", "Not found!"));
					return new UpdateBookResponse(errors);
				});
	}

}