package lv.javaguru.java2.lessoncode.book.app.core.services.validators;

import lv.javaguru.java2.lessoncode.book.app.core.database.Database;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Book;
import lv.javaguru.java2.lessoncode.book.app.core.requests.AddBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.requests.GetAllBooksRequest;
import lv.javaguru.java2.lessoncode.book.app.core.requests.SearchBooksRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import lv.javaguru.java2.lessoncode.book.app.core.responses.GetAllBooksResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.validators.AddBookRequestValidator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AddBookRequestValidatorTest {

    @Mock private Database database;
    @InjectMocks
    private AddBookRequestValidator validator;

    @Test
    public void shouldReturnErrorWhenTitleIsNull() {
        AddBookRequest request = new AddBookRequest(null, "Antoine de Saint-Exupery");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "title");
        assertEquals(errors.get(0).getErrorMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenAuthorIsNull() {
        AddBookRequest request = new AddBookRequest("The Little Prince", null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "author");
        assertEquals(errors.get(0).getErrorMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorsWhenAuthorAndTitleIsNull() {
        AddBookRequest request = new AddBookRequest(null, null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 2);
    }

    @Test
    public void shouldSuccess() {
        AddBookRequest request = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorWhenDuplicateFound() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Little Prince", "Antoine de Saint-Exupery"));
        Mockito.when(database.findByTitleAndAuthor("The Little Prince", "Antoine de Saint-Exupery")).thenReturn(List.of(new Book("The Little Prince","Antoine de Saint-Exupery")));

        AddBookRequest request = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "duplicate");
        assertEquals(errors.get(0).getErrorMessage(), "Duplicate book not accepted!");
    }

    @Test
    public void shouldNotReturnErrorWhenDuplicateNotFound() {
        List<Book> books = new ArrayList<>();
        Mockito.when(database.findByTitleAndAuthor("The Little Prince", "Antoine de Saint-Exupery")).thenReturn(books);

        AddBookRequest request = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

}
