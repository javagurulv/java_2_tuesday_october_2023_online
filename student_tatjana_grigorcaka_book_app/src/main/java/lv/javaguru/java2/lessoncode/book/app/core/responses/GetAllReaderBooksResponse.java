package lv.javaguru.java2.lessoncode.book.app.core.responses;

import lv.javaguru.java2.lessoncode.book.app.core.domain.ReaderBook;

import java.util.List;

public class GetAllReaderBooksResponse extends CoreResponse {

	private List<ReaderBook> readerBooks;

	public GetAllReaderBooksResponse(List<ReaderBook> readerBooks) {
		this.readerBooks = readerBooks;
	}

	public List<ReaderBook> getReaderBooks() {
		return readerBooks;
	}
}
