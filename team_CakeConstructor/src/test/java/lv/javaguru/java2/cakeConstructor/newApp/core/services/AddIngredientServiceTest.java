package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.InMemoryDatabaseImpl;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.AddIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.AddIngredientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.AddIngredientRequestValidator;
import lv.javaguru.java2.cakeConstructor.newApp.matchers.IngredientMatcher;

@RunWith(MockitoJUnitRunner.class)
public class AddIngredientServiceTest {

    @Mock
    private InMemoryDatabaseImpl inMemoryDatabaseImpl;
    @Mock private AddIngredientRequestValidator validator;
    @InjectMocks
    private AddIngredientService service;

    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFails() {
        AddIngredientRequest notValidRequest = new AddIngredientRequest(null, "Vanilla");
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("type", "Must not be empty!")));
        AddIngredientResponse response = service.execute(notValidRequest);
        assertTrue(response.hasErrors());
    }

    @Test
    public void shouldReturnResponseWithErrorsReceivedFromValidator() {
        AddIngredientRequest notValidRequest = new AddIngredientRequest(null, "Vanilla");
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("type", "Must not be empty!")));
        AddIngredientResponse response = service.execute(notValidRequest);
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "type");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldNotInvokeDatabaseWhenRequestValidationFails() {
        AddIngredientRequest notValidRequest = new AddIngredientRequest(null, "Vanilla");
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("type", "Must not be empty!")));
        service.execute(notValidRequest);
        verifyNoInteractions(inMemoryDatabaseImpl);
    }

    @Test
    public void shouldAddIngredientToDatabaseWhenRequestIsValid() {
        AddIngredientRequest validRequest = new AddIngredientRequest("Biscuit", "Vanilla");
        when(validator.validate(validRequest)).thenReturn(List.of());
        service.execute(validRequest);
        verify(inMemoryDatabaseImpl).save(argThat(new IngredientMatcher("Biscuit", "Vanilla")));
    }

    @Test
    public void shouldReturnResponseWithoutErrorsWhenRequestIsValid() {
        AddIngredientRequest validRequest = new AddIngredientRequest("Biscuit", "Vanilla");
        when(validator.validate(validRequest)).thenReturn(List.of());
        AddIngredientResponse response = service.execute(validRequest);
        assertFalse(response.hasErrors());
    }

    @Test
    public void shouldReturnResponseWithIngredientWhenRequestIsValid() {
        AddIngredientRequest validRequest = new AddIngredientRequest("Biscuit", "Vanilla");
        when(validator.validate(validRequest)).thenReturn(List.of());
        AddIngredientResponse response = service.execute(validRequest);
        assertNotNull(response.getNewIngredient());
        assertEquals(response.getNewIngredient().getType(), validRequest.getType());
        assertEquals(response.getNewIngredient().getTaste(), validRequest.getTaste());
    }

}