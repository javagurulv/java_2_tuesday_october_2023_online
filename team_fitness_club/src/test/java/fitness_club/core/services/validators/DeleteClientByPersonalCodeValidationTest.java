package fitness_club.core.services.validators;

import fitness_club.core.requests.DeleteClientByPersonalCodeRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.services.validators.client.DeleteClientByPersonalCodeRequestValidator;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeleteClientByPersonalCodeValidationTest {
    private DeleteClientByPersonalCodeRequestValidator validator = new DeleteClientByPersonalCodeRequestValidator();

    @Test
    public void shouldReturnErrorWhenClientPersonalCodeIsNull() {
        DeleteClientByPersonalCodeRequest request = mock(DeleteClientByPersonalCodeRequest.class);
        {
            when(request.getPersonalCode()).thenReturn(null);
            List<CoreError> errors = validator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "personalCode");
            assertEquals(errors.get(0).getMessage(), "Must not be empty!");
        }
    }

    @Test
    public void shouldReturnErrorWhenClientPersonaCodeIsEmpty() {
        DeleteClientByPersonalCodeRequest request = mock(DeleteClientByPersonalCodeRequest.class);
        {
            when(request.getPersonalCode()).thenReturn("");
            List<CoreError> errors = validator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "personalCode");
            assertEquals(errors.get(0).getMessage(), "Must not be empty!");
        }
    }

    @Test
    public void shouldNotReturnErrorWhenPersonalCodeIsPresent() {
        DeleteClientByPersonalCodeRequest request = mock(DeleteClientByPersonalCodeRequest.class);
        {
            when(request.getPersonalCode()).thenReturn("personalCode");
            List<CoreError> errors = validator.validate(request);
            assertTrue(errors.isEmpty());
        }
    }
}