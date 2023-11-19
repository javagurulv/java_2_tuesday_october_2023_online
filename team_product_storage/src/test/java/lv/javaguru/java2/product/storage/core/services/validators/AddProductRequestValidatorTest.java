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
        AddProductRequest request = new AddProductRequest(null, "Apple", "iPhone 15", 1);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "productName");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenProductBrandIsNull() {
        AddProductRequest request = new AddProductRequest("Smartphone", null, "iPhone 15", 1);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "productBrand");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenProductModelIsNull() {
        AddProductRequest request = new AddProductRequest("Smartphone", "Apple", null, 1);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "productModel");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenProductQuantityIsNull() {
        AddProductRequest request = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 0);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "productQuantity");
        assertEquals(errors.get(0).getMessage(), "Must be greater than 0!");
    }

    @Test
    public void shouldReturnErrorsWhenProductNameProductBrandProductModeAndProductQuantityIsNull() {
        AddProductRequest request = new AddProductRequest(null, null, null, 0);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 4);
    }

    @Test
    public void shouldSuccess() {
        AddProductRequest request = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 1);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }


}