package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.jpa.JpaCustomerRepository;
import lv.javaguru.java2.product.storage.core.responses.CoreError;

import lv.javaguru.java2.product.storage.core.requests.RegisterCustomerRequest;
import lv.javaguru.java2.product.storage.core.responses.RegisterCustomerResponse;
import lv.javaguru.java2.product.storage.core.services.validators.RegisterCustomerRequestValidator;
import lv.javaguru.java2.product.storage.matchers.CustomerMatcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RegisterCustomerServiceTest {

    @Mock private JpaCustomerRepository readerRepository;
    @Mock private RegisterCustomerRequestValidator validator;
    @InjectMocks
    private RegisterCustomerService service;

    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFailsWhenCustomerNameIsEmpty() {
        RegisterCustomerRequest notValidRequest = new RegisterCustomerRequest(null, "12345678910");
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("customerName", "Must not be empty!")));
        RegisterCustomerResponse response = service.execute(notValidRequest);
        assertTrue(response.hasErrors());
    }

    @Test
    public void shouldReturnResponseWithErrorsReceivedFromValidatorWhenCustomerNameIsEmpty() {
        RegisterCustomerRequest notValidRequest = new RegisterCustomerRequest( null, "12345678910");
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("customerName", "Must not be empty!")));
        RegisterCustomerResponse response = service.execute(notValidRequest);
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "customerName");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldNotInvokeDatabaseWhenRequestValidationFailsWhenCustomerNameIsEmpty() {
        RegisterCustomerRequest notValidRequest = new RegisterCustomerRequest(null,  "12345678910");
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("CustomerName", "Must not be empty!")));
        service.execute(notValidRequest);
        verifyNoInteractions(readerRepository);
    }

    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFailsWhenRegistrationCodeIsNull() {
        RegisterCustomerRequest notValidRequest = new RegisterCustomerRequest("Store Akropole Alfa",  null);
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("registrationCode", "Must not be empty!")));
        RegisterCustomerResponse response = service.execute(notValidRequest);
        assertTrue(response.hasErrors());
    }

    @Test
    public void shouldReturnResponseWithErrorsReceivedFromValidatorWhenRegistrationCodeIsNull() {
        RegisterCustomerRequest notValidRequest = new RegisterCustomerRequest("Store Akropole Alfa",  null);
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("registrationCode", "Must not be empty!")));
        RegisterCustomerResponse response = service.execute(notValidRequest);
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "registrationCode");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldNotInvokeDatabaseWhenRequestValidationFailsWhenREgistrationCodeIsNull() {
        RegisterCustomerRequest notValidRequest = new RegisterCustomerRequest("Store Akropole Alfa",  null);
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("registrationCode", "Must not be empty")));
        service.execute(notValidRequest);
        verifyNoInteractions(readerRepository);
    }


    @Test
    public void shouldRegisterReaderToDatabaseWhenRequestIsValid() {
        RegisterCustomerRequest validRequest = new RegisterCustomerRequest("Store Akropole Alfa", "12345678910");
        when(validator.validate(validRequest)).thenReturn(List.of());
        service.execute(validRequest);
        verify(readerRepository).save(argThat(new CustomerMatcher("Store Akropole Alfa", "12345678910")));
    }

    @Test
    public void shouldReturnResponseWithoutErrorsWhenRequestIsValid() {
        RegisterCustomerRequest validRequest = new RegisterCustomerRequest("Store Akropole Alfa", "12345678910");
        when(validator.validate(validRequest)).thenReturn(List.of());
        RegisterCustomerResponse response = service.execute(validRequest);
        assertFalse(response.hasErrors());
    }

    @Test
    public void shouldReturnResponseWithCustomerWhenRequestIsValid() {
        RegisterCustomerRequest validRequest = new RegisterCustomerRequest("Store Akropole Alfa", "12345678910");
        when(validator.validate(validRequest)).thenReturn(List.of());
        RegisterCustomerResponse response = service.execute(validRequest);
        assertNotNull(response.getNewCustomer());
        assertEquals(response.getNewCustomer().getCustomerName(), validRequest.getCustomerName());
        assertEquals(response.getNewCustomer().getRegistrationCode(), validRequest.getRegistrationCode());
    }
}