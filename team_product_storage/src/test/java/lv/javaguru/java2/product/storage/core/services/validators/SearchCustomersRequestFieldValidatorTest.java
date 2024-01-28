package lv.javaguru.java2.product.storage.core.services.validators;

import lv.javaguru.java2.product.storage.core.requests.SearchCustomersRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchCustomersRequestFieldValidatorTest {

    private SearchCustomersRequestFieldValidator validator = new SearchCustomersRequestFieldValidator();

    @Test
    public void shouldNotReturnErrorsWhenCustomerNameIsProvided() {
        SearchCustomersRequest request = new SearchCustomersRequest("Store Akropole Alfa", null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldNotReturnErrorsWhenRegistrationCodeIsProvided() {
        SearchCustomersRequest request = new SearchCustomersRequest(null, "123456A");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldNotReturnErrorsWhenCustomerNameAndRegistrationCodeIsProvided() {
        SearchCustomersRequest request = new SearchCustomersRequest("Store Akropole Alfa", "123456A");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorWhenSearchFieldsAreEmpty() {
        SearchCustomersRequest request = new SearchCustomersRequest(null, null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 2);
        assertEquals(errors.get(0).getErrorCode(), "customerName");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
        assertEquals(errors.get(1).getErrorCode(), "registrationCode");
        assertEquals(errors.get(1).getMessage(), "Must not be empty!");
    }
}