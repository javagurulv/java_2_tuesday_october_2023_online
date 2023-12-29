package lv.javaguru.java2.lessoncode.book.app.core.responses;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Reader;

import java.util.List;

public class RegisterReaderResponse extends CoreResponse {

	private Reader newReader;

	public RegisterReaderResponse(List<CoreError> errors) {
		super(errors);
	}

	public RegisterReaderResponse(Reader newReader) {
		this.newReader = newReader;
	}

	public Reader getNewReader() {
		return newReader;
	}

}