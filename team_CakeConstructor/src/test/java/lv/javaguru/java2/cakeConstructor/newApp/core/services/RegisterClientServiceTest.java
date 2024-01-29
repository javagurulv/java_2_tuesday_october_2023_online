package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaClientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.RegisterClientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.RegisterClientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.RegisterClientRequestValidator;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import  lv.javaguru.java2.cakeConstructor.newApp.matchers.ClientMatcher;
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
public class RegisterClientServiceTest {

    @Mock private JpaClientRepository clientRepository;
    @Mock private RegisterClientRequestValidator validator;
    @InjectMocks
    private RegisterClientService service;

    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFailsWhenFirstNameIsEmpty() {
        RegisterClientRequest notValidRequest = new RegisterClientRequest(null, "Muller", "31234567891");
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("firstName", "Must not be empty!")));
        RegisterClientResponse response = service.execute(notValidRequest);
        assertTrue(response.hasErrors());
    }

    @Test
    public void shouldReturnResponseWithErrorsReceivedFromValidatorWhenFirstNameIsEmpty() {
        RegisterClientRequest notValidRequest = new RegisterClientRequest( null, "Muller", "31234567891");
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("firstName", "Must not be empty!")));
        RegisterClientResponse response = service.execute(notValidRequest);
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "firstName");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldNotInvokeDatabaseWhenRequestValidationFailsWhenFirstNameIsEmpty() {
        RegisterClientRequest notValidRequest = new RegisterClientRequest(null, "Muller", "31234567891");
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("firstName", "Must not be empty!")));
        service.execute(notValidRequest);
        verifyNoInteractions(clientRepository);
    }

    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFailsWhenLastNameIsEmpty() {
        RegisterClientRequest notValidRequest = new RegisterClientRequest("Liza", null, "31234567891");
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("lastName", "Must not be empty!")));
        RegisterClientResponse response = service.execute(notValidRequest);
        assertTrue(response.hasErrors());
    }

    @Test
    public void shouldReturnResponseWithErrorsReceivedFromValidatorWhenLastNameIsEmpty() {
        RegisterClientRequest notValidRequest = new RegisterClientRequest("Liza", null, "31234567891");
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("lastName", "Must not be empty!")));
        RegisterClientResponse response = service.execute(notValidRequest);
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "lastName");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldNotInvokeDatabaseWhenRequestValidationFailsWhenLastNameIsEmpty() {
        RegisterClientRequest notValidRequest = new RegisterClientRequest("Liza", null, "31234567891");
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("lastName", "Must not be empty!")));
        service.execute(notValidRequest);
        verifyNoInteractions(clientRepository);
    }

    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFailsWhenPersonalCodeIsNull() {
        RegisterClientRequest notValidRequest = new RegisterClientRequest("Liza", "Muller", null);
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("personalCode", "Must not be empty!")));
        RegisterClientResponse response = service.execute(notValidRequest);
        assertTrue(response.hasErrors());
    }

    @Test
    public void shouldReturnResponseWithErrorsReceivedFromValidatorWhenPersonalCodeIsNull() {
        RegisterClientRequest notValidRequest = new RegisterClientRequest("Liza", "Muller", null);
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("personalCode", "Must not be empty!")));
        RegisterClientResponse response = service.execute(notValidRequest);
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "personalCode");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldNotInvokeDatabaseWhenRequestValidationFailsWhenPersonasCodeIsNull() {
        RegisterClientRequest notValidRequest = new RegisterClientRequest("Liza", "Muller", null);
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("personalCode", "Must not be empty")));
        service.execute(notValidRequest);
        verifyNoInteractions(clientRepository);
    }


    @Test
    public void shouldRegisterClientToDatabaseWhenRequestIsValid() {
        RegisterClientRequest validRequest = new RegisterClientRequest("Liza", "Muller", "31234567891");
        when(validator.validate(validRequest)).thenReturn(List.of());
        service.execute(validRequest);
        verify(clientRepository).save(argThat(new ClientMatcher("Liza", "Muller", "31234567891")));
    }

    @Test
    public void shouldReturnResponseWithoutErrorsWhenRequestIsValid() {
        RegisterClientRequest validRequest = new RegisterClientRequest("Liza", "Muller", "31234567891");
        when(validator.validate(validRequest)).thenReturn(List.of());
        RegisterClientResponse response = service.execute(validRequest);
        assertFalse(response.hasErrors());
    }

    @Test
    public void shouldReturnResponseWithClientWhenRequestIsValid() {
        RegisterClientRequest validRequest = new RegisterClientRequest("Liza", "Muller", "31234567891");
        when(validator.validate(validRequest)).thenReturn(List.of());
        RegisterClientResponse response = service.execute(validRequest);
        assertNotNull(response.getNewClient());
        assertEquals(response.getNewClient().getFirstName(), validRequest.getFirstName());
        assertEquals(response.getNewClient().getLastName(), validRequest.getLastName());
        assertEquals(response.getNewClient().getPersonalCode(), validRequest.getPersonalCode());
    }
}