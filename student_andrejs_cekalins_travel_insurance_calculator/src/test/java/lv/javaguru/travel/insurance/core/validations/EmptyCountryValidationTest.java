package lv.javaguru.travel.insurance.core.validations;

import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.dto.ValidationError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmptyCountryValidationTest {
    @Mock
    ValidationErrorFactory errorFactory;
    @InjectMocks
    EmptyCountryValidation validation;

    @Test
    public void shouldReturnNoErrorWhenCountryIsPresent() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getCountry()).thenReturn("Latvia");
        Optional<ValidationError> errorOpt = validation.validate(request);
        assertTrue(errorOpt.isEmpty());
    }

    @Test
    public void shouldReturnErrorWhenCountryIsNull() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getCountry()).thenReturn(null);
        when(errorFactory.buildError("ERROR_CODE_10")).
                thenReturn(new ValidationError("ERROR_CODE_10", "Field country must not be empty!"));
        Optional<ValidationError> errorOpt = validation.validate(request);
        assertTrue(errorOpt.isPresent());
        assertEquals("ERROR_CODE_10", errorOpt.get().getErrorCode());
        assertEquals("Field country must not be empty!", errorOpt.get().getDescription());
    }

    @Test
    public void shouldReturnErrorWhenCountryIsEmpty() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getCountry()).thenReturn("");
        when(errorFactory.buildError("ERROR_CODE_10")).
                thenReturn(new ValidationError("ERROR_CODE_10", "Field country must not be empty!"));
        Optional<ValidationError> errorOpt = validation.validate(request);
        assertTrue(errorOpt.isPresent());
        assertEquals("ERROR_CODE_10", errorOpt.get().getErrorCode());
        assertEquals("Field country must not be empty!", errorOpt.get().getDescription());
    }
}