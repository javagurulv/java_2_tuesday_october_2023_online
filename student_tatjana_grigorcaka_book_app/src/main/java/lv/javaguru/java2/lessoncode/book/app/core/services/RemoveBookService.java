package lv.javaguru.java2.lessoncode.book.app.core.services;

import lv.javaguru.java2.lessoncode.book.app.core.database.Database;
import lv.javaguru.java2.lessoncode.book.app.core.requests.RemoveBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import lv.javaguru.java2.lessoncode.book.app.core.responses.RemoveBookResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.validators.RemoveBookRequestValidator;

import java.util.List;


public class RemoveBookService {

    private Database database;
    private RemoveBookRequestValidator validator;

    public RemoveBookService(Database database,
                             RemoveBookRequestValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public RemoveBookResponse execute(RemoveBookRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new RemoveBookResponse(errors);
        }
        boolean isBookRemoved = database.deleteById(request.getBookIdToRemove());
        return new RemoveBookResponse(isBookRemoved);
    }

}
