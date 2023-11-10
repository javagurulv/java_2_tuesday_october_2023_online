package lv.javaguru.java2.lessoncode.book.app.core.services.validators;

import lv.javaguru.java2.lessoncode.book.app.core.requests.SearchBooksRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;

import java.util.ArrayList;
import java.util.List;


public class SearchBooksRequestFieldValidator {

    public List<CoreError> validate(SearchBooksRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (isEmpty(request.getTitle()) && isEmpty(request.getAuthor())) {
            errors.add(new CoreError("title", "Must not be empty!"));
            errors.add(new CoreError("author", "Must not be empty!"));
        }
        return errors;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}



