package fitness_club.core.services.vlidators;

import fitness_club.core.requests.ChangeClientAgeGroupRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.services.vlidators.ageGroup.ChangeClientAgeGroupValidator;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ChangeClientAgeGroupValidationTest {
    private ChangeClientAgeGroupValidator requestValidator = new ChangeClientAgeGroupValidator();

    @Test
    public void shouldReturnErrorWhenClientIdIsNull() {
        ChangeClientAgeGroupRequest request = mock(ChangeClientAgeGroupRequest.class);
        {
            when(request.getClientId()).thenReturn(null);
            when(request.getClientAgeGroupId()).thenReturn(1L);
            List<CoreError> errors = requestValidator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "clientId");
            assertEquals(errors.get(0).getMessage(), "Field client Id must not be empty!");
        }
    }

    @Test
    public void shouldReturnErrorWhenAgeGroupIdIsNull() {
        ChangeClientAgeGroupRequest request = mock(ChangeClientAgeGroupRequest.class);
        {
            when(request.getClientId()).thenReturn(1L);
            when(request.getClientAgeGroupId()).thenReturn(null);
            List<CoreError> errors = requestValidator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "ageGroupId");
            assertEquals(errors.get(0).getMessage(), "Field age group Id must not be empty!");
        }
    }

    @Test
    public void shouldNotReturnErrorWhenClientIdAndAgeGroupIdIsPresent() {
        ChangeClientAgeGroupRequest request = mock(ChangeClientAgeGroupRequest.class);
        {
            when(request.getClientId()).thenReturn(1L);
            when(request.getClientAgeGroupId()).thenReturn(1L);
            List<CoreError> errors = requestValidator.validate(request);
            assertTrue(errors.isEmpty());
        }
    }
}