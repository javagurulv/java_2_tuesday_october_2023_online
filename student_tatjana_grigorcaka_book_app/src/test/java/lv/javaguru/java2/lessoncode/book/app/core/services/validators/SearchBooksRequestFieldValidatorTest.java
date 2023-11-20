package lv.javaguru.java2.lessoncode.book.app.core.services.validators;

import static org.junit.Assert.*;

import java.util.List;

import lv.javaguru.java2.lessoncode.book.app.core.requests.SearchBooksRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import org.junit.Test;

public class SearchBooksRequestFieldValidatorTest {

    private SearchBooksRequestFieldValidator validator = new SearchBooksRequestFieldValidator();

    @Test
    public void shouldNotReturnErrorsWhenTitleIsProvided() {
        SearchBooksRequest request = new SearchBooksRequest("The Little Prince", null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldNotReturnErrorsWhenAuthorIsProvided() {
        SearchBooksRequest request = new SearchBooksRequest(null, "Antoine de Saint-Exupery");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldNotReturnErrorsWhenTitleAndAuthorIsProvided() {
        SearchBooksRequest request = new SearchBooksRequest("The Little Prince", "Antoine de Saint-Exupery");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorWhenSearchFieldsAreEmpty() {
        SearchBooksRequest request = new SearchBooksRequest(null, null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 2);
        assertEquals(errors.get(0).getErrorCode(), "title");
        assertEquals(errors.get(0).getErrorMessage(), "Must not be empty!");
        assertEquals(errors.get(1).getErrorCode(), "author");
        assertEquals(errors.get(1).getErrorMessage(), "Must not be empty!");
    }

}