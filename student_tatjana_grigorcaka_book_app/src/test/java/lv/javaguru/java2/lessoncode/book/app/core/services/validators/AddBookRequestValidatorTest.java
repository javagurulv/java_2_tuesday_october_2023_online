package lv.javaguru.java2.lessoncode.book.app.core.services.validators;

import lv.javaguru.java2.lessoncode.book.app.core.database.BookRepository;
import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaBookRepository;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Book;
import lv.javaguru.java2.lessoncode.book.app.core.requests.AddBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;

import java.util.List;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AddBookRequestValidatorTest {

    @Mock private JpaBookRepository bookRepository;
    @InjectMocks
    private AddBookRequestValidator validator;


    @Test
    public void shouldReturnErrorWhenTitleIsNull() {
        AddBookRequest request = new AddBookRequest(null, "Antoine de Saint-Exupery", 1943);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "title");
        assertEquals(errors.get(0).getErrorMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenAuthorIsNull() {
        AddBookRequest request = new AddBookRequest("The Little Prince", null, 1943);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "author");
        assertEquals(errors.get(0).getErrorMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenIssueYearIsNull() {
        AddBookRequest request = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery", null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "issueYear");
        assertEquals(errors.get(0).getErrorMessage(), "Must be greater than 0!");
    }

    @Test
    public void shouldReturnErrorsWhenAuthorTitleYIssueYearIsNull() {
        AddBookRequest request = new AddBookRequest(null, null, null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 3);
    }

    @Test
    public void shouldSuccess() {
        AddBookRequest request = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery", 1943);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorWhenDuplicateFound() {
        bookRepository = Mockito.mock(JpaBookRepository.class);
        Mockito.when(bookRepository.findByTitleAndAuthorAndIssueYear("The Little Prince", "Antoine de Saint-Exupery", 1943)).thenReturn(List.of(new Book("The Little Prince","Antoine de Saint-Exupery", 1943)));
        validator = new AddBookRequestValidator(bookRepository);
        AddBookRequest request = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery", 1943);
        List<CoreError> errors = validator.validate(request);
        assertTrue(!errors.isEmpty());
        assertEquals(errors.get(0).getErrorCode(), "duplicate");
        assertEquals(errors.get(0).getErrorMessage(), "Duplicate book not accepted!");
    }

    @Test
    public void shouldNotReturnErrorWhenDuplicateNotFound() {
        bookRepository = Mockito.mock(JpaBookRepository.class);
        Mockito.when(bookRepository.findByTitleAndAuthorAndIssueYear("The Little Prince", "Antoine de Saint-Exupery", 1943)).thenReturn(List.of());
        validator = new AddBookRequestValidator(bookRepository);
        AddBookRequest request = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery", 1943);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

}
