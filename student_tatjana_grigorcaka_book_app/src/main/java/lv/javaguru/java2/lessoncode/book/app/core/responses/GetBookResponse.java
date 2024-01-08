package lv.javaguru.java2.lessoncode.book.app.core.responses;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Book;

import java.util.List;

public class GetBookResponse extends CoreResponse {

	private Book book;

	public GetBookResponse(List<CoreError> errors) {
		super(errors);
	}

	public GetBookResponse(Book book) {
		this.book = book;
	}

	public Book getBook() {
		return book;
	}

}
