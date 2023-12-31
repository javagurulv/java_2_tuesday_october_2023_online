package fitness_club.core.services.vlidators;

import fitness_club.core.requests.RemoveClientRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.services.vlidators.client.RemoveClientRequestValidator;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RemoveClientValidationTest {
    private RemoveClientRequestValidator requestValidator = new RemoveClientRequestValidator();

    @Test
    public void shouldReturnErrorWhenClientPersonalCodeIsNull() {
        RemoveClientRequest request = mock(RemoveClientRequest.class);
        {
            when(request.getPersonalCode()).thenReturn(null);
            List<CoreError> errors = requestValidator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "personalCode");
            assertEquals(errors.get(0).getMessage(), "Field personal code must not be empty!");
        }
    }

    @Test
    public void shouldReturnErrorWhenClientPersonaCodeIsEmpty() {
        RemoveClientRequest request = mock(RemoveClientRequest.class);
        {
            when(request.getPersonalCode()).thenReturn("");
            List<CoreError> errors = requestValidator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "personalCode");
            assertEquals(errors.get(0).getMessage(), "Field personal code must not be empty!");
        }
    }

    @Test
    public void shouldNotReturnErrorWhenPersonalCodeIsPresent() {
        RemoveClientRequest request = mock(RemoveClientRequest.class);
        {
            when(request.getPersonalCode()).thenReturn("personalCode");
            List<CoreError> errors = requestValidator.validate(request);
            assertTrue(errors.isEmpty());
        }
    }
}