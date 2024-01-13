package lv.javaguru.java2.lessoncode.book.app.core.responses;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Book;

import java.util.List;

public class DeleteBookResponse extends CoreResponse {

	private Book deletedBook;

	public DeleteBookResponse(List<CoreError> errors) {
		super(errors);
	}

	public DeleteBookResponse(Book deletedBook) {
		this.deletedBook = deletedBook;
	}

	public Book getDeletedBook() {
		return deletedBook;
	}

}
