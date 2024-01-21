package lv.javaguru.java2.lessoncode.book.app.core.responses;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Reader;

import java.util.List;

public class DeleteReaderResponse extends CoreResponse {

	private Reader deletedReader;

	public DeleteReaderResponse(List<CoreError> errors) {
		super(errors);
	}

	public DeleteReaderResponse(Reader deletedReader) {
		this.deletedReader = deletedReader;
	}

	public Reader getDeletedReader() {
		return deletedReader;
	}

}
