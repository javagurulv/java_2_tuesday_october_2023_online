package fitness_club.core.services.vlidators;

import fitness_club.core.requests.ChangeClientFitnessCenterRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.services.vlidators.fitnessCenter.ChangeClientFitnessCenterValidator;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ChangeClientFitnessCentreValidatorTest {
    private ChangeClientFitnessCenterValidator validator = new ChangeClientFitnessCenterValidator();

    @Test
    public void shouldReturnErrorWhenClientIdIsNull() {
        ChangeClientFitnessCenterRequest request = Mockito.mock(ChangeClientFitnessCenterRequest.class);
        {
            when(request.getClientId()).thenReturn(null);
            when(request.getFitnessCenterId()).thenReturn(1L);
            List<CoreError> errors = validator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.get(0).getField(), "clientId");
            assertEquals(errors.get(0).getMessage(),"Field client id must not be empty!");
        }
    }
    @Test
    public void shouldReturnErrorWhenFitnessCenterIdIsNull() {
        ChangeClientFitnessCenterRequest request = Mockito.mock(ChangeClientFitnessCenterRequest.class);
        {
            when(request.getClientId()).thenReturn(1L);
            when(request.getFitnessCenterId()).thenReturn(null);
            List<CoreError> errors = validator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.get(0).getField(), "fitnessCenterId");
            assertEquals(errors.get(0).getMessage(),"Field fitness center id must not be empty!");
        }
    }

    @Test
    public void shouldNotReturnErrorWhenClientIdAndFitnessCenterIdIsEntered() {
        ChangeClientFitnessCenterRequest request = Mockito.mock(ChangeClientFitnessCenterRequest.class);
        {
            when(request.getClientId()).thenReturn(1L);
            when(request.getFitnessCenterId()).thenReturn(1L);
            List<CoreError> errors = validator.validate(request);
            assertEquals(errors.size(),0);
        }
    }
}