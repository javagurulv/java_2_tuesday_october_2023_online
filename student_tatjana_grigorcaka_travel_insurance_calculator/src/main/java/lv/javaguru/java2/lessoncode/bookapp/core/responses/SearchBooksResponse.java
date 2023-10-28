package lv.javaguru.java2.lessoncode.bookapp.core.responses;

import lv.javaguru.java2.lessoncode.bookapp.core.domain.Book;

import java.util.List;

public class SearchBooksResponse extends CoreResponse {

    private List<Book> books;

    public SearchBooksResponse(List<Book> books, List<CoreError> errors) {
        super(errors);
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }
}
