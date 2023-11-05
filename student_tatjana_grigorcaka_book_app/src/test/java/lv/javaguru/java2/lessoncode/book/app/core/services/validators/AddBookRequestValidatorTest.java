package lv.javaguru.java2.lessoncode.book.app.core.services.validators;

import lv.javaguru.java2.lessoncode.book.app.core.requests.AddBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import lv.javaguru.java2.lessoncode.book.app.core.services.validators.AddBookRequestValidator;

import java.util.List;

import static org.junit.Assert.*;

import org.junit.Test;


public class AddBookRequestValidatorTest {

    private AddBookRequestValidator validator = new AddBookRequestValidator();

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

}