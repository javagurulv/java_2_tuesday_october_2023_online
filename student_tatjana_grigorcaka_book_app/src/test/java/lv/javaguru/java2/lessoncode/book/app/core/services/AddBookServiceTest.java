package lv.javaguru.java2.lessoncode.book.app.core.services;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.util.List;

import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaBookRepository;
import lv.javaguru.java2.lessoncode.book.app.core.requests.AddBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.AddBookResponse;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import lv.javaguru.java2.lessoncode.book.app.core.services.validators.AddBookRequestValidator;
import lv.javaguru.java2.lessoncode.book.app.matchers.BookMatcher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AddBookServiceTest  {

    @Mock private JpaBookRepository bookRepository;
    @Mock private AddBookRequestValidator validator;
    @InjectMocks
    private AddBookService service;

    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFailsWhenBookTitleIsEmpty() {
        AddBookRequest notValidRequest = new AddBookRequest(null, "Antoine de Saint-Exupery", 1943);
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("bookTitle", "Must not be empty!")));
        AddBookResponse response = service.execute(notValidRequest);
        assertTrue(response.containsErrors());
    }

    @Test
    public void shouldReturnResponseWithErrorsReceivedFromValidatorWhenBookTitleIsEmpty() {
        AddBookRequest notValidRequest = new AddBookRequest( null, "Antoine de Saint-Exupery", 1943);
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("bookTitle", "Must not be empty!")));
        AddBookResponse response = service.execute(notValidRequest);
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "bookTitle");
        assertEquals(response.getErrors().get(0).getErrorMessage(), "Must not be empty!");
    }

    @Test
    public void shouldNotInvokeDatabaseWhenRequestValidationFailsWhenBookTitleIsEmpty() {
        AddBookRequest notValidRequest = new AddBookRequest(null, "Antoine de Saint-Exupery", 1943);
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("bookTitle", "Must not be empty!")));
        service.execute(notValidRequest);
        verifyNoInteractions(bookRepository);
    }

    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFailsWhenBookAuthorIsEmpty() {
        AddBookRequest notValidRequest = new AddBookRequest("The Little Prince", null, 1943);
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("bookAuthor", "Must not be empty!")));
        AddBookResponse response = service.execute(notValidRequest);
        assertTrue(response.containsErrors());
    }

    @Test
    public void shouldReturnResponseWithErrorsReceivedFromValidatorWhenBookAuthorIsEmpty() {
        AddBookRequest notValidRequest = new AddBookRequest("The Little Price", null, 1943);
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("bookAuthor", "Must not be empty!")));
        AddBookResponse response = service.execute(notValidRequest);
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "bookAuthor");
        assertEquals(response.getErrors().get(0).getErrorMessage(), "Must not be empty!");
    }

    @Test
    public void shouldNotInvokeDatabaseWhenRequestValidationFailsWhenBookAuthorIsEmpty() {
        AddBookRequest notValidRequest = new AddBookRequest("The Little Price", null, 1943);
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("bookAuthor", "Must not be empty!")));
        service.execute(notValidRequest);
        verifyNoInteractions(bookRepository);
    }

    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFailsWhenIssueYearIsNull() {
        AddBookRequest notValidRequest = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery", 0);
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("issueYear", "Must be greater than 0!")));
        AddBookResponse response = service.execute(notValidRequest);
        assertTrue(response.containsErrors());
    }

    @Test
    public void shouldReturnResponseWithErrorsReceivedFromValidatorWhenIssueYearIsNull() {
        AddBookRequest notValidRequest = new AddBookRequest("The Little Price", "Antoine de Saint-Exupery", 0);
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("issueYear", "Must be greater than 0!")));
        AddBookResponse response = service.execute(notValidRequest);
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "issueYear");
        assertEquals(response.getErrors().get(0).getErrorMessage(), "Must be greater than 0!");
    }

    @Test
    public void shouldNotInvokeDatabaseWhenRequestValidationFailsWhenIssueYearIsNull() {
        AddBookRequest notValidRequest = new AddBookRequest("The Little Price", "Antoine de Saint-Exupery", 0);
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("issueYear", "Must be greater than 0!")));
        service.execute(notValidRequest);
        verifyNoInteractions(bookRepository);
    }


    @Test
    public void shouldAddBookToDatabaseWhenRequestIsValid() {
        AddBookRequest validRequest = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery", 1943);
        when(validator.validate(validRequest)).thenReturn(List.of());
        service.execute(validRequest);
        verify(bookRepository).save(argThat(new BookMatcher("The Little Prince", "Antoine de Saint-Exupery", 1943)));
    }

    @Test
    public void shouldReturnResponseWithoutErrorsWhenRequestIsValid() {
        AddBookRequest validRequest = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery", 1943);
        when(validator.validate(validRequest)).thenReturn(List.of());
        AddBookResponse response = service.execute(validRequest);
        assertFalse(response.containsErrors());
    }

    @Test
    public void shouldReturnResponseWithBookWhenRequestIsValid() {
        AddBookRequest validRequest = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery", 1943);
        when(validator.validate(validRequest)).thenReturn(List.of());
        AddBookResponse response = service.execute(validRequest);
        assertNotNull(response.getNewBook());
        assertEquals(response.getNewBook().getTitle(), validRequest.getTitle());
        assertEquals(response.getNewBook().getAuthor(), validRequest.getAuthor());
        assertEquals(response.getNewBook().getIssueYear(), validRequest.getIssueYear());
    }
}