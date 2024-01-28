package lv.javaguru.java2.lessoncode.book.app.core.responses;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Book;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Reader;

import java.util.List;

public class UpdateReaderResponse extends CoreResponse {

	private Reader updatedReader;

	public UpdateReaderResponse(List<CoreError> errors) {
		super(errors);
	}

	public UpdateReaderResponse(Reader updatedReader) {
		this.updatedReader = updatedReader;
	}

	public Reader getUpdatedReader() {
		return updatedReader;
	}

}