package lv.javaguru.java2.lessoncode.book.app.core.responses;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Book;

import java.util.List;

public class AddBookResponse  extends CoreResponse {

    private Book newBook;


    public AddBookResponse(List<CoreError> errors) {
        super(errors);
    }

    public AddBookResponse(Book newBook) {
        this.newBook = newBook;
    }


    public Book getNewBook() {
        return newBook;
    }

}


