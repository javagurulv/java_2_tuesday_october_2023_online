package lv.javaguru.java2.lessoncode.book.app.core.services.validators;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lv.javaguru.java2.lessoncode.book.app.core.database.BookRepository;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Book;
import lv.javaguru.java2.lessoncode.book.app.core.requests.AddBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class AddBookRequestValidator {

    @Autowired private BookRepository bookRepository;


    public List<CoreError> validate(AddBookRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateTitle(request).ifPresent(errors::add);
        validateAuthor(request).ifPresent(errors::add);
        validateIssueYear(request).ifPresent(errors::add);
        validateDuplicate(request).ifPresent(errors::add);
        return errors;
    }


    private Optional<CoreError> validateTitle(AddBookRequest request) {
        return (request.getTitle() == null || request.getTitle().isEmpty())
                ? Optional.of(new CoreError("title", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateAuthor(AddBookRequest request) {
        return (request.getAuthor() == null || request.getAuthor().isEmpty())
                ? Optional.of(new CoreError("author", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateIssueYear(AddBookRequest request) {
        return ((request.getIssueYear() <= 0))
                ? Optional.of(new CoreError("issueYear", "Must be greater than 0!"))
                : Optional.empty();
    }


    private Optional<CoreError> validateDuplicate(AddBookRequest request) {
        List<Book> books = bookRepository.findByTitleAndAuthor(request.getTitle(), request.getAuthor());
        return (!books.isEmpty())
                ? Optional.of(new CoreError("duplicate", "Duplicate book not accepted!"))
                : Optional.empty();
    }

}
