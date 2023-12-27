package lv.javaguru.travel.insurance.core.validations.agreement;

import lv.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.core.api.dto.ValidationErrorDTO;
import lv.javaguru.travel.insurance.core.validations.ValidationErrorFactory;
import lv.javaguru.travel.insurance.core.validations.agreement.EmptySelectedRiskValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmptySelectedRiskValidationTest {
    @Mock
    private ValidationErrorFactory errorFactory;
    @InjectMocks
    private EmptySelectedRiskValidation validation;

    @Test
    void shouldReturnErrorWhenRiskIsNull() {
        AgreementDTO request = mock(AgreementDTO.class);
        when(request.getSelectedRisks()).thenReturn(null);
        ValidationErrorDTO validationError = mock(ValidationErrorDTO.class);
        when(errorFactory.buildError("ERROR_CODE_8")).thenReturn(validationError);
        Optional<ValidationErrorDTO> errorOpt = validation.validate(request);
        assertTrue(errorOpt.isPresent());
        Assertions.assertEquals(errorOpt.get(), validationError);
    }

    @Test
    void shouldReturnErrorWhenRiskIsEmpty() {
        AgreementDTO request = mock(AgreementDTO.class);
        when(request.getSelectedRisks()).thenReturn(List.of());
        ValidationErrorDTO validationError = mock(ValidationErrorDTO.class);
        when(errorFactory.buildError("ERROR_CODE_8")).thenReturn(validationError);
        Optional<ValidationErrorDTO> errorOpt = validation.validate(request);
        assertTrue(errorOpt.isPresent());
        Assertions.assertEquals(errorOpt.get(), validationError);
    }

    @Test
    void shouldNotReturnErrorWhenSelectedRisksIsNotEmpty() {
        AgreementDTO request = mock(AgreementDTO.class);
        when(request.getSelectedRisks()).thenReturn(List.of("TRAVEL_CANCELLATION"));
        Optional<ValidationErrorDTO> errorOpt = validation.validate(request);
        assertTrue(errorOpt.isEmpty());
        verifyNoInteractions(errorFactory);
    }
}