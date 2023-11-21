package fitness_club.core.services.data_vlidation;

import fitness_club.core.requests.RemoveClientRequest;
import fitness_club.core.services.data_vlidation.CoreError;
import fitness_club.core.services.data_vlidation.RemoveClientRequestValidator;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RemoveClientValidationTest {
    private RemoveClientRequestValidator requestValidator = new RemoveClientRequestValidator();

    @Test
    void shouldReturnErrorWhenClientPersonalCodeIsNull() {
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
    void shouldReturnErrorWhenClientPersonaCodeIsEmpty() {
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
    void shouldNotReturnErrorWhenPersonalCodeIsPresent() {
        RemoveClientRequest request = mock(RemoveClientRequest.class);
        {
            when(request.getPersonalCode()).thenReturn("personalCode");
            List<CoreError> errors = requestValidator.validate(request);
            assertTrue(errors.isEmpty());
        }
    }
}