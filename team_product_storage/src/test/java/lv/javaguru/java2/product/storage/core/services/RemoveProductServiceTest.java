package lv.javaguru.java2.product.storage.core.services;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import lv.javaguru.java2.product.storage.core.database.ProductRepository;
import lv.javaguru.java2.product.storage.core.requests.RemoveProductRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.responses.RemoveProductResponse;
import lv.javaguru.java2.product.storage.core.services.validators.RemoveProductRequestValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RemoveProductServiceTest {

    @Mock
    private ProductRepository productRepository;
    @Mock private RemoveProductRequestValidator validator;
    @InjectMocks
    private RemoveProductService service;

    @Test
    public void shouldReturnErrorWhenProductIdNotProvided() {
        RemoveProductRequest request = new RemoveProductRequest(null);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("productIdToRemove", "Must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);
        RemoveProductResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "productIdToRemove");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldDeleteBookWithIdFromDatabase() {
        Mockito.when(validator.validate(any())).thenReturn(new ArrayList<>());
        Mockito.when(productRepository.deleteById(1L)).thenReturn(true);
        RemoveProductRequest request = new RemoveProductRequest(1L);
        RemoveProductResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertTrue(response.isProductRemoved());
    }

}