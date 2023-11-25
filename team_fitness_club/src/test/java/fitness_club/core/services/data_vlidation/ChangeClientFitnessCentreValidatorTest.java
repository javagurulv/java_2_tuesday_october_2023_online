package fitness_club.core.services.data_vlidation;

import fitness_club.core.domain.FitnessCentre;
import fitness_club.core.requests.ChangeClientFitnessCentreRequest;
import fitness_club.core.responses.CoreError;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ChangeClientFitnessCentreValidatorTest {
    private ChangeClientFitnessCentreValidator validator = new ChangeClientFitnessCentreValidator();

    @Test
    public void shouldReturnErrorWhenClientPersonalCodeIsNull() {
        ChangeClientFitnessCentreRequest request = Mockito.mock(ChangeClientFitnessCentreRequest.class);
        {
            when(request.getPersonalCode()).thenReturn(null);
            when(request.getFitnessCentre()).thenReturn(FitnessCentre.AKROPOLE);
            List<CoreError> errors = validator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.get(0).getField(), "personalCode");
            assertEquals(errors.get(0).getMessage(),"Field personal code must not be empty!");
        }
    }
    @Test
    public void shouldReturnErrorWhenClientPersonalCodeIsEmpty() {
        ChangeClientFitnessCentreRequest request = Mockito.mock(ChangeClientFitnessCentreRequest.class);
        {
            when(request.getPersonalCode()).thenReturn("");
            when(request.getFitnessCentre()).thenReturn(FitnessCentre.AKROPOLE);
            List<CoreError> errors = validator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.get(0).getField(), "personalCode");
            assertEquals(errors.get(0).getMessage(),"Field personal code must not be empty!");
        }
    }
    @Test
    public void shouldNotReturnErrorWhenClientPersonalCodeEntered() {
        ChangeClientFitnessCentreRequest request = Mockito.mock(ChangeClientFitnessCentreRequest.class);
        {
            when(request.getPersonalCode()).thenReturn("personalCode");
            when(request.getFitnessCentre()).thenReturn(FitnessCentre.AKROPOLE);
            List<CoreError> errors = validator.validate(request);
            assertEquals(errors.size(),0);
        }
    }
}