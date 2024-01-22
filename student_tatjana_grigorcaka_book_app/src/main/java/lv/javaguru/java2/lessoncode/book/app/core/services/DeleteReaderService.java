package lv.javaguru.java2.lessoncode.book.app.core.services;

import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaReaderRepository;
import lv.javaguru.java2.lessoncode.book.app.core.requests.DeleteReaderRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import lv.javaguru.java2.lessoncode.book.app.core.responses.DeleteReaderResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.validators.DeleteReaderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class DeleteReaderService {

	@Autowired private JpaReaderRepository readerRepository;
	@Autowired private DeleteReaderValidator validator;

	public DeleteReaderResponse execute(DeleteReaderRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new DeleteReaderResponse(errors);
		}
		return readerRepository.findById(request.getId())
				.map(reader -> {
					readerRepository.deleteById(request.getId());
					return new DeleteReaderResponse(reader);
				})
				.orElseGet(() -> {
					errors.add(new CoreError("id", "Not found!"));
					return new DeleteReaderResponse(errors);
				});
	}

}