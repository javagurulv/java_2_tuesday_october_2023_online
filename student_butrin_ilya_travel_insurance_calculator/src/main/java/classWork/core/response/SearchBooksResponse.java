package classWork.core.response;

import classWork.Book;
import classWork.core.CoreError;
import classWork.core.CoreResponse;

import java.util.List;

public class SearchBooksResponse extends CoreResponse {
    public SearchBooksResponse(List<Book> bookSearch) {
        this.bookSearch = bookSearch;
    }

    public SearchBooksResponse(List<CoreError> errors, List<Book> bookSearch) {
        super(errors);

    }

    public SearchBooksResponse() {
    }

    List<Book> bookSearch;

    public List<Book> getBookSearch() {
        return bookSearch;
    }
}
