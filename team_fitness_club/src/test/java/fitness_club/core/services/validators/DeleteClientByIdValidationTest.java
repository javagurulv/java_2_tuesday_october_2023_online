package fitness_club.core.services.validators;

import fitness_club.core.requests.DeleteClientByIdRequest;
import fitness_club.core.requests.DeleteClientByPersonalCodeRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.services.validators.client.DeleteClientByIdRequestValidator;
import fitness_club.core.services.validators.client.DeleteClientByPersonalCodeRequestValidator;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeleteClientByIdValidationTest {
    private DeleteClientByIdRequestValidator validator = new DeleteClientByIdRequestValidator();

    @Test
    public void shouldReturnErrorWhenClientPersonalCodeIsNull() {
        DeleteClientByIdRequest request = mock(DeleteClientByIdRequest.class);
        {
            when(request.getId()).thenReturn(null);
            List<CoreError> errors = validator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "Id");
            assertEquals(errors.get(0).getMessage(), "Must not be empty!");
        }
    }


    @Test
    public void shouldNotReturnErrorWhenPersonalCodeIsPresent() {
        DeleteClientByIdRequest request = mock(DeleteClientByIdRequest.class);
        {
            when(request.getId()).thenReturn(1L);
            List<CoreError> errors = validator.validate(request);
            assertTrue(errors.isEmpty());
        }
    }
}