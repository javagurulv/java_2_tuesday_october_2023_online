package fitness_club.core.services.validators;

import fitness_club.core.requests.RemoveClientByPersonalCodeRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.services.validators.client.RemoveClientByIdRequestValidator;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RemoveClientByIdValidationTest {
    private RemoveClientByIdRequestValidator validator = new RemoveClientByIdRequestValidator();

    @Test
    public void shouldReturnErrorWhenClientPersonalCodeIsNull() {
        RemoveClientByPersonalCodeRequest request = mock(RemoveClientByPersonalCodeRequest.class);
        {
            when(request.getPersonalCode()).thenReturn(null);
            List<CoreError> errors = validator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "PersonalCode");
            assertEquals(errors.get(0).getMessage(), "Must not be empty!");
        }
    }


    @Test
    public void shouldNotReturnErrorWhenPersonalCodeIsPresent() {
        RemoveClientByPersonalCodeRequest request = mock(RemoveClientByPersonalCodeRequest.class);
        {
            when(request.getPersonalCode()).thenReturn("123");
            List<CoreError> errors = validator.validate(request);
            assertTrue(errors.isEmpty());
        }
    }
}