package lv.javaguru.java2.lessoncode.book.app.core.services.validators;

import lv.javaguru.java2.lessoncode.book.app.core.requests.RemoveReaderRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RemoveReaderRequestValidator {

    public List<CoreError> validate(RemoveReaderRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateReaderId(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateReaderId(RemoveReaderRequest request) {
        return (request.getReaderIdToRemove() == null)
                ? Optional.of(new CoreError("readerId", "Must not be empty!"))
                : Optional.empty();
    }

}
