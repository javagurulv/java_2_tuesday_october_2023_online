package classWork.core.service;

import classWork.core.CoreError;
import classWork.core.database.BookRepository;
import classWork.core.response.AddBookResponse;
import classWork.core.requests.AddBookRequest;
import classWork.domen.Book;

import classWork.core.service.valigators.AddBookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddBookService {
    @Autowired
    BookRepository data;
    @Autowired AddBookValidator validator;

    public AddBookResponse execute(AddBookRequest request) {
        List <CoreError> errorlist = validator.errorlist(request);
        if (!errorlist.isEmpty())
            return new AddBookResponse(errorlist);
        Book book = new Book(request.getTitle(), request.getAuthor());
        data.addBook(book);
        return new AddBookResponse(book);
    }

}
