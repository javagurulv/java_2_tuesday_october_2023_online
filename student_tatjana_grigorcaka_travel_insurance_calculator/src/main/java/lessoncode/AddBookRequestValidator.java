package lessoncode;

import lessoncode.database.Database;
import lessoncode.domain.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddBookRequestValidator {

    private Database database;

    public AddBookRequestValidator(Database database) {
        this.database = database;
    }

    public List<BusinessError> validate(AddBookRequest request) {

        List<BusinessError> errors = new ArrayList<>();
        validateBookAuthor(request, errors);
        validateBookTitle(request, errors);
        validateUniqueBook(request, errors);
        return errors;
    }

    private void validateUniqueBook(AddBookRequest request, List<BusinessError> errors) {
        //shodith v bazu dannix
        //naiti knogu
        //esli estj to vernutj oshibku
        Optional<Book> bookOpt = database.findBookByTitleAndAuthor(
                request.getBookAuthor(), request.getBookTitle());
        if (bookOpt.isPresent()) {
            errors.add(new BusinessError("uniqueBook", "Book must be unique!"));


        }


        if (request.getBookTitle() == null
                || request.getBookTitle().isBlank()) {
            errors.add(new BusinessError("bookTitle", "Must not be empty!"));
        }
    }

    private void validateBookTitle(AddBookRequest request, List<BusinessError> errors) {
        if (request.getBookTitle() == null
                || request.getBookTitle().isBlank()) {
            errors.add(new BusinessError("bookTitle", "Must not be empty!"));
        }
    }

    private void validateBookAuthor(AddBookRequest request, List<BusinessError> errors) {
        if (request.getBookAuthor() == null
                || request.getBookAuthor().isBlank()) {
            errors.add(new BusinessError("bookAuthor", "Must not be empty!"));
        }
    }
}
