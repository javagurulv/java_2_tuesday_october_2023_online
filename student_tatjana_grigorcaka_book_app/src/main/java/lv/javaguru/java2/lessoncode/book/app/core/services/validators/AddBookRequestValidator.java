package lv.javaguru.java2.lessoncode.book.app.core.services.validators;

import lv.javaguru.java2.lessoncode.book.app.core.database.Database;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Book;
import lv.javaguru.java2.lessoncode.book.app.core.requests.AddBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import lv.javaguru.java2.lessoncode.book.app.dependency_injection.DIComponent;
import lv.javaguru.java2.lessoncode.book.app.dependency_injection.DIDependency;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DIComponent
public class AddBookRequestValidator {

    @DIDependency private Database database;


    public List<CoreError> validate(AddBookRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateTitle(request).ifPresent(errors::add);
        validateAuthor(request).ifPresent(errors::add);
        validateDuplicate(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateTitle(AddBookRequest request) {
        return (request.getBookTitle() == null || request.getBookTitle().isEmpty())
                ? Optional.of(new CoreError("title", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateAuthor(AddBookRequest request) {
        return (request.getBookAuthor() == null || request.getBookAuthor().isEmpty())
                ? Optional.of(new CoreError("author", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateDuplicate(AddBookRequest request) {
        List<Book> books = database.findByTitleAndAuthor(request.getBookTitle(), request.getBookAuthor());
        return (!books.isEmpty())
                ? Optional.of(new CoreError("duplicate", "Duplicate book not accepted!"))
                : Optional.empty();
    }

}
