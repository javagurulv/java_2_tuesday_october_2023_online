package fitness_club.core.services.data_vlidation;

import fitness_club.core.domain.Workouts;
import fitness_club.core.requests.ChangeClientWorkoutsRequest;
import fitness_club.core.responses.CoreError;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ChangeClientWorkoutsValidationTest {
    private ChangeClientWorkoutsValidator requestValidator = new ChangeClientWorkoutsValidator();

    @Test
    void shouldReturnErrorWhenClientPersonalCodeIsNull() {
        ChangeClientWorkoutsRequest request = mock(ChangeClientWorkoutsRequest.class);
        {
            when(request.getPersonalCode()).thenReturn(null);
            when(request.getWorkout()).thenReturn(Workouts.GYM);
            List<CoreError> errors = requestValidator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "personalCode");
            assertEquals(errors.get(0).getMessage(), "Field personal code must not be empty!");
        }
    }

    @Test
    void shouldReturnErrorWhenClientPersonaCodeIsEmpty() {
        ChangeClientWorkoutsRequest request = mock(ChangeClientWorkoutsRequest.class);
        {
            when(request.getPersonalCode()).thenReturn("");
            when(request.getWorkout()).thenReturn(Workouts.GYM);
            List<CoreError> errors = requestValidator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "personalCode");
            assertEquals(errors.get(0).getMessage(), "Field personal code must not be empty!");
        }
    }

    @Test
    void shouldNotReturnErrorWhenPersonalCodeIsPresent() {
        ChangeClientWorkoutsRequest request = mock(ChangeClientWorkoutsRequest.class);
        {
            when(request.getPersonalCode()).thenReturn("personalCode");
            when(request.getWorkout()).thenReturn(Workouts.GYM);
            List<CoreError> errors = requestValidator.validate(request);
            assertTrue(errors.isEmpty());
        }
    }
}