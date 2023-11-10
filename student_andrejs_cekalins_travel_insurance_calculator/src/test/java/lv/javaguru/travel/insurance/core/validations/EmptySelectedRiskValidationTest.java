package lv.javaguru.travel.insurance.core.validations;

import lv.javaguru.travel.insurance.core.ErrorCodeUnit;
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
    private ErrorCodeUnit errorCodeUnit;
    @InjectMocks
    private EmptySelectedRiskValidation validation;

    @Test
    void shouldReturnErrorWhenRiskIsNull(){
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getSelectedRisks()).thenReturn(null);
        when(errorCodeUnit.getErrorDescription("ERROR_CODE_8")).thenReturn("Field selectRisk must not be empty!");
        Optional<ValidationError> errorOpt = validation.execute(request);
        assertTrue(errorOpt.isPresent());
        assertEquals(errorOpt.get().getErrorCode(),"ERROR_CODE_8");
        assertEquals(errorOpt.get().getDescription(), "Field selectRisk must not be empty!");
    }
    @Test
    void shouldReturnErrorWhenRiskIsEmpty(){
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getSelectedRisks()).thenReturn(List.of());
        when(errorCodeUnit.getErrorDescription("ERROR_CODE_8")).thenReturn("Field selectRisk must not be empty!");
        Optional<ValidationError> errorOpt = validation.execute(request);
        assertTrue(errorOpt.isPresent());
        assertEquals(errorOpt.get().getErrorCode(),"ERROR_CODE_8");
        assertEquals(errorOpt.get().getDescription(), "Field selectRisk must not be empty!");
    }
    @Test
    void shouldNotReturnErrorWhenSelectedRisksIsNotEmpty() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getSelectedRisks()).thenReturn(List.of("TRAVEL_CANCELLATION"));
        Optional<ValidationError> errorOpt = validation.execute(request);
        assertTrue(errorOpt.isEmpty());
        verifyNoInteractions(errorCodeUnit);
    }
}