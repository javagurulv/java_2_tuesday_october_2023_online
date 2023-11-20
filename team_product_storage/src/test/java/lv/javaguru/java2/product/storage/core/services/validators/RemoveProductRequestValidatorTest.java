package lv.javaguru.java2.product.storage.core.services.validators;

import lv.javaguru.java2.product.storage.core.requests.RemoveProductRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class RemoveProductRequestValidatorTest {

    private RemoveProductRequestValidator validator = new RemoveProductRequestValidator();

    @Test
    public void shouldReturnErrorWhenProductIdIsNull() {
        RemoveProductRequest request = new RemoveProductRequest(null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "productId");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldSuccess() {
        RemoveProductRequest request = new RemoveProductRequest(1L);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }


}