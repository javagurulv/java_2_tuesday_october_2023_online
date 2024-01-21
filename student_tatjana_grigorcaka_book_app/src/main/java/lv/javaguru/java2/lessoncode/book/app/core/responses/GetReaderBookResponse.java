package lv.javaguru.java2.lessoncode.book.app.core.responses;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Book;
import lv.javaguru.java2.lessoncode.book.app.core.domain.ReaderBook;

import java.util.List;

public class GetReaderBookResponse extends CoreResponse {

	private ReaderBook readerBook;

	public GetReaderBookResponse(List<CoreError> errors) {
		super(errors);
	}

	public GetReaderBookResponse(ReaderBook readerBook) {
		this.readerBook = readerBook;
	}

	public ReaderBook getReaderBook() {
		return readerBook;
	}

}
