package lv.javaguru.java2.lessoncode.bookapp.core.services;

import lv.javaguru.java2.lessoncode.bookapp.core.requests.AddBookRequest;
import lv.javaguru.java2.lessoncode.bookapp.core.responses.AddBookResponse;
import lv.javaguru.java2.lessoncode.bookapp.core.responses.CoreError;
import lv.javaguru.java2.lessoncode.bookapp.core.database.Database;
import lv.javaguru.java2.lessoncode.bookapp.core.domain.Book;

import java.util.List;


public class AddBookService {

    private Database database;
    private AddBookRequestValidator validator;

    public AddBookService(Database database,
                          AddBookRequestValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public AddBookResponse execute(AddBookRequest request) {
        List<CoreError> errors = validator.validate(request);
        return errors.isEmpty()
                ? executeBusinessLogic(request)
                : buildErrorResponse(errors);
    }
    private AddBookResponse buildErrorResponse(List<CoreError> errors) {
        return new AddBookResponse(errors);
    }

    private AddBookResponse executeBusinessLogic(AddBookRequest request) {
        Book book = new Book(
                request.getBookTitle(),
                request.getBookAuthor());
        database.save(book);
        return new AddBookResponse(book);
    }

}

