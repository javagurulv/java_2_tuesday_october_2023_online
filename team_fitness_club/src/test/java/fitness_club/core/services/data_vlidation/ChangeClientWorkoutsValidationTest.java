package fitness_club.core.services.data_vlidation;

import fitness_club.core.domain.Workouts;
import fitness_club.core.requests.ChangeClientWorkoutRequest;
import fitness_club.core.responses.CoreError;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ChangeClientWorkoutsValidationTest {
    private ChangeClientWorkoutsValidator requestValidator = new ChangeClientWorkoutsValidator();

    @Test
    public void shouldReturnErrorWhenClientPersonalCodeIsNull() {
        ChangeClientWorkoutRequest request = mock(ChangeClientWorkoutRequest.class);
        {
            when(request.getPersonalCode()).thenReturn(null);
            when(request.getWorkout()).thenReturn(1L);
            List<CoreError> errors = requestValidator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "personalCode");
            assertEquals(errors.get(0).getMessage(), "Field personal code must not be empty!");
        }
    }

    @Test
    public void shouldReturnErrorWhenClientPersonaCodeIsEmpty() {
        ChangeClientWorkoutRequest request = mock(ChangeClientWorkoutRequest.class);
        {
            when(request.getPersonalCode()).thenReturn("");
            when(request.getWorkout()).thenReturn(1L);
            List<CoreError> errors = requestValidator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "personalCode");
            assertEquals(errors.get(0).getMessage(), "Field personal code must not be empty!");
        }
    }

    @Test
    public void shouldNotReturnErrorWhenPersonalCodeIsPresent() {
        ChangeClientWorkoutRequest request = mock(ChangeClientWorkoutRequest.class);
        {
            when(request.getPersonalCode()).thenReturn("personalCode");
            when(request.getWorkout()).thenReturn(1L);
            List<CoreError> errors = requestValidator.validate(request);
            assertTrue(errors.isEmpty());
        }
    }
}