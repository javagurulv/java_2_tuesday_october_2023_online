package lv.javaguru.java2.lessoncode.bookapp.core.responses;

import lv.javaguru.java2.lessoncode.bookapp.core.domain.Book;

import java.util.List;

public class GetAllBooksResponse extends CoreResponse {

    private List<Book> books;

    public GetAllBooksResponse( List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }
}
