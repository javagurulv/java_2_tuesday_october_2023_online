package lv.javaguru.java2.lessoncode.bookapp.core.services;

import lv.javaguru.java2.lessoncode.bookapp.core.database.Database;
import lv.javaguru.java2.lessoncode.bookapp.core.domain.Book;
import lv.javaguru.java2.lessoncode.bookapp.core.requests.AddBookRequest;
import lv.javaguru.java2.lessoncode.bookapp.core.responses.CoreError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddBookRequestValidator {

    private Database database;

    public AddBookRequestValidator(Database database) {
        this.database = database;
    }

    public List<CoreError> validate(AddBookRequest request) {

        List<CoreError> errors = new ArrayList<>();
        validateBookAuthor(request, errors);
        validateBookTitle(request, errors);
        validateUniqueBook(request, errors);
        return errors;
    }

    private void validateUniqueBook(AddBookRequest request, List<CoreError> errors) {
        //shodith v bazu dannix
        //naiti knogu
        //esli estj to vernutj oshibku
        Optional<Book> bookOpt = database.findBookByTitleAndAuthor(
                request.getBookAuthor(), request.getBookTitle());
        if (bookOpt.isPresent()) {
            errors.add(new CoreError("uniqueBook", "Book must be unique!"));
        }
        if (request.getBookTitle() == null
                || request.getBookTitle().isBlank()) {
            errors.add(new CoreError("bookTitle", "Must not be empty!"));
        }
    }

    private void validateBookTitle(AddBookRequest request, List<CoreError> errors) {
        if (request.getBookTitle() == null
                || request.getBookTitle().isBlank()) {
            errors.add(new CoreError("bookTitle", "Must not be empty!"));
        }
    }

    private void validateBookAuthor(AddBookRequest request, List<CoreError> errors) {
        if (request.getBookAuthor() == null
                || request.getBookAuthor().isBlank()) {
            errors.add(new CoreError("bookAuthor", "Must not be empty!"));
        }
    }
}