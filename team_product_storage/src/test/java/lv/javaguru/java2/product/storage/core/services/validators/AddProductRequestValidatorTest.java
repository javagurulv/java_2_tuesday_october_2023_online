package lv.javaguru.java2.product.storage.core.services.validators;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import lv.javaguru.java2.product.storage.core.database.Database;
import lv.javaguru.java2.product.storage.core.domain.Category;
import lv.javaguru.java2.product.storage.core.domain.Product;
import lv.javaguru.java2.product.storage.core.requests.AddProductRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AddProductRequestValidatorTest {

    @Mock private Database database;
    @InjectMocks
    private AddProductRequestValidator validator;

    @Test
    public void shouldReturnErrorWhenProductNameIsNull() {
        AddProductRequest request = new AddProductRequest(null, "Apple", "iPhone 15", 1, new BigDecimal("1000.00"), Category.PHONES);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "productName");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenProductBrandIsNull() {
        AddProductRequest request = new AddProductRequest("Smartphone", null, "iPhone 15", 1, new BigDecimal("1000.00"), Category.PHONES);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "productBrand");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenProductModelIsNull() {
        AddProductRequest request = new AddProductRequest("Smartphone", "Apple", null, 1, new BigDecimal("1000.00"), Category.PHONES);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "productModel");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenProductQuantityIsNull() {
        AddProductRequest request = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 0, new BigDecimal("1000.00"), Category.PHONES);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "productQuantity");
        assertEquals(errors.get(0).getMessage(), "Must be greater than 0!");
    }

    @Test
    public void shouldReturnErrorWhenPriceInStockIsNull() {
        AddProductRequest request = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("0.00"), Category.PHONES);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "priceInStock");
        assertEquals(errors.get(0).getMessage(), "Must be greater than 0.01!");
    }

    @Test
    public void shouldReturnErrorsWhenProductNameProductBrandProductModeAndProductQuantityIsNull() {
        AddProductRequest request = new AddProductRequest(null, null, null, 0, new BigDecimal("0.00"), Category.PHONES);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 5);
    }

    @Test
    public void shouldSuccess() {
        AddProductRequest request = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00"), Category.PHONES);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorWhenDuplicateFound() {
        database = Mockito.mock(Database.class);
        Mockito.when(database.findByProductBrandAndProductModel("Apple", "iPhone 15")).thenReturn(List.of(new Product("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00"), Category.PHONES)));
        validator = new AddProductRequestValidator(database);
        AddProductRequest request = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00"), Category.PHONES);
        List<CoreError> errors = validator.validate(request);
        assertTrue(!errors.isEmpty());
        assertEquals(errors.get(0).getErrorCode(), "duplicate");
        assertEquals(errors.get(0).getMessage(), "Duplicate product not accepted!");
    }

    @Test
    public void shouldNotReturnErrorWhenDuplicateNotFound() {
        database = Mockito.mock(Database.class);
        Mockito.when(database.findByProductBrandAndProductModel("Apple", "iPhone 15")).thenReturn(List.of());
        validator = new AddProductRequestValidator(database);
        AddProductRequest request = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00"), Category.PHONES);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }


}