package classWork.core.response;

import classWork.Book;
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

    public classWork.Book getBook() {
        return Book;
    }
}
