package lessoncode.services;

import lessoncode.AddBookRequest;
import lessoncode.AddBookRequestValidator;
import lessoncode.AddBookResponse;
import lessoncode.BusinessError;
import lessoncode.database.Database;
import lessoncode.domain.Book;

import java.util.ArrayList;
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
        List<BusinessError> errors = validator.validate(request);
        return errors.isEmpty()
                ? executeBusinessLogic(request)
                : buildErrorResponse(errors);
    }

    private AddBookResponse buildErrorResponse(List<BusinessError> errors) {
        return new AddBookResponse(errors);
    }

    private AddBookResponse executeBusinessLogic(AddBookRequest request) {
        Book book = new Book(
                request.getBookTitle(),
                request.getBookAuthor());
        database.addBook(book);
        return new AddBookResponse();
    }

}

