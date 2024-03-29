package lv.javaguru.java2.lessoncode.book.app.core.services;

import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaReaderBookRepository;
import lv.javaguru.java2.lessoncode.book.app.core.domain.ReaderBook;
import lv.javaguru.java2.lessoncode.book.app.core.requests.GetAllReaderBooksRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.GetAllReaderBooksResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class GetAllReaderBooksService {

	@Autowired private JpaReaderBookRepository readerBookRepository;

	public GetAllReaderBooksResponse execute(GetAllReaderBooksRequest request) {
		List<ReaderBook> readerBooks = readerBookRepository.findAll();
		return new GetAllReaderBooksResponse(readerBooks);
	}

}