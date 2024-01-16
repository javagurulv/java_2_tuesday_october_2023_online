package fitness_club.core.services.vlidators;

import fitness_club.core.requests.ChangeClientWorkoutRequest;
import fitness_club.core.responses.CoreError;
import java.util.List;

import fitness_club.core.services.vlidators.workout.ChangeClientWorkoutsValidator;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ChangeClientWorkoutsValidationTest {
    private ChangeClientWorkoutsValidator requestValidator = new ChangeClientWorkoutsValidator();

    @Test
    public void shouldReturnErrorWhenClientIdIsNull() {
        ChangeClientWorkoutRequest request = mock(ChangeClientWorkoutRequest.class);
        {
            when(request.getClientId()).thenReturn(null);
            when(request.getWorkoutId()).thenReturn(1L);
            List<CoreError> errors = requestValidator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "clientId");
            assertEquals(errors.get(0).getMessage(), "Field client id must not be empty!");
        }
    }

    @Test
    public void shouldReturnErrorWhenWorkoutIdIsNull() {
        ChangeClientWorkoutRequest request = mock(ChangeClientWorkoutRequest.class);
        {
            when(request.getClientId()).thenReturn(1L);
            when(request.getWorkoutId()).thenReturn(null);
            List<CoreError> errors = requestValidator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "workoutId");
            assertEquals(errors.get(0).getMessage(), "Field workout id must not be empty!");
        }
    }

    @Test
    public void shouldNotReturnErrorWhenClientIdAndWorkoutIdIsPresent() {
        ChangeClientWorkoutRequest request = mock(ChangeClientWorkoutRequest.class);
        {
            when(request.getClientId()).thenReturn(1L);
            when(request.getWorkoutId()).thenReturn(1L);
            List<CoreError> errors = requestValidator.validate(request);
            assertTrue(errors.isEmpty());
        }
    }
}