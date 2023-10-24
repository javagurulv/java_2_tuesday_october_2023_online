package classWork.core.service;

import classWork.core.CoreError;
import classWork.core.response.AddBookResponse;
import classWork.core.requests.AddBookRequest;
import classWork.Book;
import classWork.Database;
import classWork.core.service.valigators.AddBookValidator;

import java.util.List;

public class AddBookService {
    Database data;
    AddBookValidator validator;

    public AddBookService(Database data, AddBookValidator validator) {
        this.data = data;
        this.validator = validator;
    }

    public AddBookResponse execute(AddBookRequest request) {
        List <CoreError> errorlist = validator.errorlist(request);
        if (!errorlist.isEmpty())
            return new AddBookResponse(errorlist);
        Book book = new Book(request.getTitle(), request.getAuthor());
        data.addBook(book);
        return new AddBookResponse(book);
    }
}
