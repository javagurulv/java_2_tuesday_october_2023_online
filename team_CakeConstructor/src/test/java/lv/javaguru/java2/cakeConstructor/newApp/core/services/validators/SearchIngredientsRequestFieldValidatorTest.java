package lv.javaguru.java2.cakeConstructor.newApp.core.services.validators;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.SearchIngredientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SearchIngredientsRequestFieldValidatorTest {

    private SearchIngredientsRequestFieldValidator validator = new SearchIngredientsRequestFieldValidator();

    @Test
    public void shouldNotReturnErrorsWhenTypeIsProvided() {
        SearchIngredientsRequest request = new SearchIngredientsRequest("Biscuit", null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldNotReturnErrorsWhenTasteIsProvided() {
        SearchIngredientsRequest request = new SearchIngredientsRequest(null, "Vanilla");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldNotReturnErrorsWhenTypeAndTasteIsProvided() {
        SearchIngredientsRequest request = new SearchIngredientsRequest("Biscuit", "Vanilla");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorWhenSearchFieldsAreEmpty() {
        SearchIngredientsRequest request = new SearchIngredientsRequest(null, null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 2);
        assertEquals(errors.get(0).getField(), "type");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
        assertEquals(errors.get(1).getField(), "taste");
        assertEquals(errors.get(1).getMessage(), "Must not be empty!");
    }


}