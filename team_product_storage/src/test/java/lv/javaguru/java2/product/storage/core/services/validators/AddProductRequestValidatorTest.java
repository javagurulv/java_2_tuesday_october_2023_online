package lv.javaguru.java2.product.storage.core.services.validators;

import static org.junit.Assert.*;

import java.util.List;

import lv.javaguru.java2.product.storage.core.requests.AddProductRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import org.junit.Test;


public class AddProductRequestValidatorTest {

    private AddProductRequestValidator validator = new AddProductRequestValidator();

    @Test
    public void shouldReturnErrorWhenProductNameIsNull() {
        AddProductRequest request = new AddProductRequest(null, "Apple", "iPhone 15");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "productName");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenProductBrandIsNull() {
        AddProductRequest request = new AddProductRequest("Smartphone", null, "iPhone 15");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "productBrand");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenProductModelIsNull() {
        AddProductRequest request = new AddProductRequest("Smartphone", "Apple", null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "productModel");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorsWhenProductNameAndProductBrandAndProductModelIsNull() {
        AddProductRequest request = new AddProductRequest(null, null, null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 3);
    }

    @Test
    public void shouldSuccess() {
        AddProductRequest request = new AddProductRequest("Smartphone", "Apple", "iPhone 15");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }


}