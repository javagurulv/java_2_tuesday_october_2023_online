package lv.javaguru.java2.lessoncode.book.app.core.responses;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Book;

import java.util.List;

public class UpdateBookResponse extends CoreResponse {

	private Book updatedBook;

	public UpdateBookResponse(List<CoreError> errors) {
		super(errors);
	}

	public UpdateBookResponse(Book updatedBook) {
		this.updatedBook = updatedBook;
	}

	public Book getUpdatedBook() {
		return updatedBook;
	}

}