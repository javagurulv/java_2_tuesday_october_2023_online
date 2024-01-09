package lv.javaguru.java2.product.storage.core.services.validators;

import lv.javaguru.java2.product.storage.core.requests.RemoveCustomerRequest;
import lv.javaguru.java2.product.storage.core.requests.RemoveProductRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RemoveCustomerRequestValidatorTest {

    private RemoveCustomerRequestValidator validator = new RemoveCustomerRequestValidator();

    @Test
    public void shouldReturnErrorWhenCustomerIdIsNull() {
        RemoveCustomerRequest request = new RemoveCustomerRequest(null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "customerId");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldSuccess() {
        RemoveCustomerRequest request = new RemoveCustomerRequest(1L);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }


}