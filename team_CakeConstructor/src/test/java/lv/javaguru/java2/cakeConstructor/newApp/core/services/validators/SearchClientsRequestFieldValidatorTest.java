package lv.javaguru.java2.cakeConstructor.newApp.core.services.validators;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.SearchClientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchClientsRequestFieldValidatorTest {

    private SearchClientsRequestFieldValidator validator = new SearchClientsRequestFieldValidator();

    @Test
    public void shouldNotReturnErrorsWhenFirstNameIsProvided() {
        SearchClientsRequest request = new SearchClientsRequest("Liza", null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldNotReturnErrorsWhenLastNameIsProvided() {
        SearchClientsRequest request = new SearchClientsRequest(null, "Muller");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldNotReturnErrorsWhenFirstNameAndLastNameIsProvided() {
        SearchClientsRequest request = new SearchClientsRequest("Liza", "Muller");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorWhenSearchFieldsAreEmpty() {
        SearchClientsRequest request = new SearchClientsRequest(null, null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 2);
        assertEquals(errors.get(0).getField(), "firstName");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
        assertEquals(errors.get(1).getField(), "lastName");
        assertEquals(errors.get(1).getMessage(), "Must not be empty!");
    }

}