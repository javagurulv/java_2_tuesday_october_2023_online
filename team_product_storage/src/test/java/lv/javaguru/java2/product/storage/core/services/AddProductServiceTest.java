package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.jpa.JpaProductRepository;
import lv.javaguru.java2.product.storage.core.requests.AddProductRequest;
import lv.javaguru.java2.product.storage.core.responses.AddProductResponse;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.services.validators.AddProductRequestValidator;
import lv.javaguru.java2.product.storage.matchers.ProductMatcher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class AddProductServiceTest {

    @Mock private JpaProductRepository productRepository;
    @Mock private AddProductRequestValidator validator;
    @InjectMocks private AddProductService service;

    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFailsWhenProductNameIsEmpty() {
        AddProductRequest notValidRequest = new AddProductRequest(null, "Apple", "iPhone 15", 1, new BigDecimal("1000.00"));
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("productName", "Must not be empty!")));
        AddProductResponse response = service.execute(notValidRequest);
        assertTrue(response.hasErrors());
    }

    @Test
    public void shouldReturnResponseWithErrorsReceivedFromValidatorWhenProductNameIsEmpty() {
        AddProductRequest notValidRequest = new AddProductRequest(null, "Apple", "iPhone 15", 1, new BigDecimal("1000.00"));
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("productName", "Must not be empty!")));
        AddProductResponse response = service.execute(notValidRequest);
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "productName");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldNotInvokeDatabaseWhenRequestValidationFailsWhenProductNameIsEmpty() {
        AddProductRequest notValidRequest = new AddProductRequest(null, "Apple", "iPhone 15", 1, new BigDecimal("1000.00"));
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("productName", "Must not be empty!")));
        service.execute(notValidRequest);
        verifyNoInteractions(productRepository);
    }

    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFailsWhenProductBrandIsEmpty() {
        AddProductRequest notValidRequest = new AddProductRequest("Smartphone", null, "iPhone 15", 1, new BigDecimal("1000.00"));
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("productBrand", "Must not be empty!")));
        AddProductResponse response = service.execute(notValidRequest);
        assertTrue(response.hasErrors());
    }

    @Test
    public void shouldReturnResponseWithErrorsReceivedFromValidatorWhenProductBrandIsEmpty() {
        AddProductRequest notValidRequest = new AddProductRequest("Smartphone", null, "iPhone 15", 1, new BigDecimal("1000.00"));
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("productBrand", "Must not be empty!")));
        AddProductResponse response = service.execute(notValidRequest);
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "productBrand");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldNotInvokeDatabaseWhenRequestValidationFailsWhenProductBrandIsEmpty() {
        AddProductRequest notValidRequest = new AddProductRequest("Smartphone", null, "iPhone 15", 1, new BigDecimal("1000.00"));
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("productBrand", "Must not be empty!")));
        service.execute(notValidRequest);
        verifyNoInteractions(productRepository);
    }

    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFailsWhenProductModelIsEmpty() {
        AddProductRequest notValidRequest = new AddProductRequest("Smartphone", "Apple", null, 1, new BigDecimal("1000.00"));
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("productModel", "Must not be empty!")));
        AddProductResponse response = service.execute(notValidRequest);
        assertTrue(response.hasErrors());
    }

    @Test
    public void shouldReturnResponseWithErrorsReceivedFromValidatorWhenProductModelIsEmpty() {
        AddProductRequest notValidRequest = new AddProductRequest("Smartphone", "Apple", null, 1, new BigDecimal("1000.00"));
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("productModel", "Must not be empty!")));
        AddProductResponse response = service.execute(notValidRequest);
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "productModel");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldNotInvokeDatabaseWhenRequestValidationFailsWhenProductModelIsEmpty() {
        AddProductRequest notValidRequest = new AddProductRequest("Smartphone", "Apple", null, 1, new BigDecimal("1000.00"));
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("productModel", "Must not be empty!")));
        service.execute(notValidRequest);
        verifyNoInteractions(productRepository);
    }

    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFailsWhenProductQuantityIsNull() {
        AddProductRequest notValidRequest = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 0, new BigDecimal("1000.00"));
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("productQuantity", "Must be greater than 0!")));
        AddProductResponse response = service.execute(notValidRequest);
        assertTrue(response.hasErrors());
    }

    @Test
    public void shouldReturnResponseWithErrorsReceivedFromValidatorWhenProductQuantityIsNull() {
        AddProductRequest notValidRequest = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 0, new BigDecimal("1000.00"));
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("productQuantity", "Must be greater than 0!")));
        AddProductResponse response = service.execute(notValidRequest);
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "productQuantity");
        assertEquals(response.getErrors().get(0).getMessage(), "Must be greater than 0!");
    }

    @Test
    public void shouldNotInvokeDatabaseWhenRequestValidationFailsWhenProductQuantityIsNull() {
        AddProductRequest notValidRequest = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 0, new BigDecimal("1000.00"));
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("productQuantity", "Must be greater than 0!")));
        service.execute(notValidRequest);
        verifyNoInteractions(productRepository);
    }

    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFailsWhenPriceIsNull() {
        AddProductRequest notValidRequest = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("0.00"));
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("price", "Must be greater than 0.00!")));
        AddProductResponse response = service.execute(notValidRequest);
        assertTrue(response.hasErrors());
    }

    @Test
    public void shouldReturnResponseWithErrorsReceivedFromValidatorWhenPriceIsNull() {
        AddProductRequest notValidRequest = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("0.00"));
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("price", "Must be greater than 0.00!")));
        AddProductResponse response = service.execute(notValidRequest);
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "price");
        assertEquals(response.getErrors().get(0).getMessage(), "Must be greater than 0.00!");
    }

    @Test
    public void shouldNotInvokeDatabaseWhenRequestValidationFailsWhenPriceIsNull() {
        AddProductRequest notValidRequest = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("0.00"));
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("price", "Must be greater than 0.00!")));
        service.execute(notValidRequest);
        verifyNoInteractions(productRepository);
    }

    @Test
    public void shouldAddProductToDatabaseWhenRequestIsValid() {
        AddProductRequest validRequest = new AddProductRequest("Smartphone", "Apple", "iPhone 15",1, new BigDecimal("1000.00"));
        when(validator.validate(validRequest)).thenReturn(List.of());
        service.execute(validRequest);
        verify(productRepository).save(argThat(new ProductMatcher("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00"))));
    }

    @Test
    public void shouldReturnResponseWithoutErrorsWhenRequestIsValid() {
        AddProductRequest validRequest = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00"));
        when(validator.validate(validRequest)).thenReturn(List.of());
        AddProductResponse response = service.execute(validRequest);
        assertFalse(response.hasErrors());
    }

    @Test
    public void shouldReturnResponseWithProductWhenRequestIsValid() {
        AddProductRequest validRequest = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00"));
        when(validator.validate(validRequest)).thenReturn(List.of());
        AddProductResponse response = service.execute(validRequest);
        assertNotNull(response.getNewProduct());
        assertEquals(response.getNewProduct().getProductName(), validRequest.getProductName());
        assertEquals(response.getNewProduct().getProductBrand(), validRequest.getProductBrand());
        assertEquals(response.getNewProduct().getProductModel(), validRequest.getProductModel());
        assertEquals(response.getNewProduct().getProductQuantity(), validRequest.getProductQuantity());
        assertEquals(response.getNewProduct().getPrice(), validRequest.getPrice());

    }


}