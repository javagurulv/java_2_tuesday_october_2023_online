package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.jpa.JpaCustomerRepository;
import lv.javaguru.java2.product.storage.core.requests.RemoveCustomerRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.responses.RemoveCustomerResponse;
import lv.javaguru.java2.product.storage.core.services.validators.RemoveCustomerRequestValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class RemoveCustomerServiceTest {

    @Mock
    private JpaCustomerRepository customerRepository;
    @Mock private RemoveCustomerRequestValidator validator;
    @InjectMocks
    private RemoveCustomerService service;

    @Test
    public void shouldReturnErrorWhenCustomerIdNotProvided() {
        RemoveCustomerRequest request = new RemoveCustomerRequest(null);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("customerIdToRemove", "Must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);
        RemoveCustomerResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "customerIdToRemove");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldDeleteCustomerWithIdFromDatabase() {
        Mockito.when(validator.validate(any())).thenReturn(new ArrayList<>());
        RemoveCustomerRequest request = new RemoveCustomerRequest(1L);
        RemoveCustomerResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertTrue(response.isCustomerRemoved());
    }

}