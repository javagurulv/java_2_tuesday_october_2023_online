package lv.javaguru.java2.cakeConstructor.newApp.core.services.validators;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.SearchCakesRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchCakesRequestValidatorTest {

    private SearchCakesRequestValidator validator = new SearchCakesRequestValidator();

    @Test
    public void shouldNotReturnErrorsWhenCakeNameIsProvided() {
        SearchCakesRequest request = new SearchCakesRequest("Birthday Cake", 0.00);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldNotReturnErrorsWhenWeightIsProvided() {
        SearchCakesRequest request = new SearchCakesRequest(null, 1000.00);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldNotReturnErrorsWhenCakeNameAndWeightIsProvided() {
        SearchCakesRequest request = new SearchCakesRequest("Birthday Cake", 1000.00);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorWhenSearchFieldsAreEmpty() {
        SearchCakesRequest request = new SearchCakesRequest(null, null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 2);
        assertEquals(errors.get(0).getField(), "cakeName");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
        assertEquals(errors.get(1).getField(), "weight");
        assertEquals(errors.get(1).getMessage(), "Must not be greater than 0.00!");
    }

}