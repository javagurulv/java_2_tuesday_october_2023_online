package fitness_club.core.services.data_vlidation;

import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.requests.ChangeClientAgeGroupRequest;
import fitness_club.core.responses.CoreError;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ChangeClientAgeGroupValidationTest {
    private ChangeClientAgeGroupValidator requestValidator = new ChangeClientAgeGroupValidator();

    @Test
    public void shouldReturnErrorWhenClientPersonalCodeIsNull() {
        ChangeClientAgeGroupRequest request = mock(ChangeClientAgeGroupRequest.class);
        {
            when(request.getPersonalCode()).thenReturn(null);
            when(request.getClientAgeGroup()).thenReturn(ClientAgeGroups.CHILD);
            List<CoreError> errors = requestValidator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "personalCode");
            assertEquals(errors.get(0).getMessage(), "Field personal code must not be empty!");
        }
    }

    @Test
    public void shouldReturnErrorWhenClientPersonaCodeIsEmpty() {
        ChangeClientAgeGroupRequest request = mock(ChangeClientAgeGroupRequest.class);
        {
            when(request.getPersonalCode()).thenReturn("");
            when(request.getClientAgeGroup()).thenReturn(ClientAgeGroups.CHILD);
            List<CoreError> errors = requestValidator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "personalCode");
            assertEquals(errors.get(0).getMessage(), "Field personal code must not be empty!");
        }
    }

    @Test
    public void shouldNotReturnErrorWhenPersonalCodeIsPresent() {
        ChangeClientAgeGroupRequest request = mock(ChangeClientAgeGroupRequest.class);
        {
            when(request.getPersonalCode()).thenReturn("personalCode");
            when(request.getClientAgeGroup()).thenReturn(ClientAgeGroups.CHILD);
            List<CoreError> errors = requestValidator.validate(request);
            assertTrue(errors.isEmpty());
        }
    }
}