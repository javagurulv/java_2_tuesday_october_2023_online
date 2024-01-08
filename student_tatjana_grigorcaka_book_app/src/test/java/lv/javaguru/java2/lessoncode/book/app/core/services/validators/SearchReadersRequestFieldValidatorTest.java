package lv.javaguru.java2.lessoncode.book.app.core.services.validators;

import lv.javaguru.java2.lessoncode.book.app.core.requests.SearchBooksRequest;
import lv.javaguru.java2.lessoncode.book.app.core.requests.SearchReadersRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchReadersRequestFieldValidatorTest {

    private SearchReadersRequestFieldValidator validator = new SearchReadersRequestFieldValidator();

    @Test
    public void shouldNotReturnErrorsWhenFirstNameIsProvided() {
        SearchReadersRequest request = new SearchReadersRequest("John", null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldNotReturnErrorsWhenLastNameIsProvided() {
        SearchReadersRequest request = new SearchReadersRequest(null, "Smith");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldNotReturnErrorsWhenFirstNameAndLastNameIsProvided() {
        SearchReadersRequest request = new SearchReadersRequest("John", "Smith");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorWhenSearchFieldsAreEmpty() {
        SearchReadersRequest request = new SearchReadersRequest(null, null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 2);
        assertEquals(errors.get(0).getErrorCode(), "firstName");
        assertEquals(errors.get(0).getErrorMessage(), "Must not be empty!");
        assertEquals(errors.get(1).getErrorCode(), "lastName");
        assertEquals(errors.get(1).getErrorMessage(), "Must not be empty!");
    }

}