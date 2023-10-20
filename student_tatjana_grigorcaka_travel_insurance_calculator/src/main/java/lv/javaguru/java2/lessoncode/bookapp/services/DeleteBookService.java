package lv.javaguru.java2.lessoncode.bookapp.services;

import lv.javaguru.java2.lessoncode.bookapp.database.Database;
import lv.javaguru.java2.lessoncode.bookapp.requests.RemoveBookRequest;
import lv.javaguru.java2.lessoncode.bookapp.responses.CoreError;
import lv.javaguru.java2.lessoncode.bookapp.responses.RemoveBookResponse;


import java.util.ArrayList;
import java.util.List;


public class DeleteBookService {

    private Database database;

    public DeleteBookService(Database database) {
        this.database = database;
    }

    public RemoveBookResponse execute(RemoveBookRequest request) {
        if (request.getBookIdToRemove() == null) {
            CoreError error = new CoreError("id", "Must not be empty!");
            List<CoreError> errors = new ArrayList<>();
            errors.add(error);
            return new RemoveBookResponse(errors);
        }
        boolean isBookRemoved = database.deleteById(request.getBookIdToRemove());
        return new RemoveBookResponse(isBookRemoved);
    }
}

