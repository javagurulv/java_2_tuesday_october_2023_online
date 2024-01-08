package classWork.core.response;

import classWork.domen.Book;
import classWork.core.CoreError;
import classWork.core.CoreResponse;

import java.util.List;

public class AddBookResponse extends CoreResponse {
    Book Book;

    public AddBookResponse(List<CoreError> errors) {
        super(errors);
    }

    public AddBookResponse(Book book) {
        Book = book;
    }

    public classWork.domen.Book getBook() {
        return Book;
    }
}
