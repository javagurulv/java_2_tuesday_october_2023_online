package lv.javaguru.java2.lessoncode.book.app.core.responses;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Reader;

import java.util.List;

public class GetReaderResponse extends CoreResponse {

	private Reader reader;

	public GetReaderResponse(List<CoreError> errors) {
		super(errors);
	}

	public GetReaderResponse(Reader reader) {
		this.reader = reader;
	}

	public Reader getReader() {
		return reader;
	}

}
