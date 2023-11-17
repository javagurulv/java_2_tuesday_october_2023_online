package lv.javaguru.java2.lessoncode.book.app.core.services.validators;

import lv.javaguru.java2.lessoncode.book.app.core.requests.RemoveBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import lv.javaguru.java2.lessoncode.book.app.dependency_injection.DIComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DIComponent
public class RemoveBookRequestValidator {

    public List<CoreError> validate(RemoveBookRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateBookId(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateBookId(RemoveBookRequest request) {
        return (request.getBookIdToRemove() == null)
                ? Optional.of(new CoreError("bookId", "Must not be empty!"))
                : Optional.empty();
    }

}
