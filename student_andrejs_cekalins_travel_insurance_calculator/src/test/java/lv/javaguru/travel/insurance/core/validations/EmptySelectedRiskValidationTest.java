package lv.javaguru.travel.insurance.core.validations;

import lv.javaguru.travel.insurance.core.util.ErrorCodeUnit;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmptySelectedRiskValidationTest {
    @Mock
    private ValidationErrorFactory errorFactory;
    @InjectMocks
    private EmptySelectedRiskValidation validation;

    @Test
    void shouldReturnErrorWhenRiskIsNull() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getSelectedRisks()).thenReturn(null);
        ValidationError validationError = mock(ValidationError.class);
        when(errorFactory.buildError("ERROR_CODE_8")).thenReturn(validationError);
        Optional<ValidationError> errorOpt = validation.validate(request);
        assertTrue(errorOpt.isPresent());
        assertEquals(errorOpt.get(), validationError);
    }

    @Test
    void shouldReturnErrorWhenRiskIsEmpty() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getSelectedRisks()).thenReturn(List.of());
        ValidationError validationError = mock(ValidationError.class);
        when(errorFactory.buildError("ERROR_CODE_8")).thenReturn(validationError);
        Optional<ValidationError> errorOpt = validation.validate(request);
        assertTrue(errorOpt.isPresent());
        assertEquals(errorOpt.get(), validationError);
    }

    @Test
    void shouldNotReturnErrorWhenSelectedRisksIsNotEmpty() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getSelectedRisks()).thenReturn(List.of("TRAVEL_CANCELLATION"));
        Optional<ValidationError> errorOpt = validation.validate(request);
        assertTrue(errorOpt.isEmpty());
        verifyNoInteractions(errorFactory);
    }
}