package lv.javaguru.travel.insurance.core.validations.agreement;

import lv.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.core.api.dto.ValidationErrorDTO;
import lv.javaguru.travel.insurance.core.domain.ClassifierValue;
import lv.javaguru.travel.insurance.core.repositories.ClassifierValueRepository;
import lv.javaguru.travel.insurance.core.validations.ValidationErrorFactory;
import lv.javaguru.travel.insurance.core.validations.agreement.CountryValidation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CountryValidationTest {

    @Mock
    private ClassifierValueRepository classifierValueRepository;

    @Mock
    private ValidationErrorFactory errorFactory;

    @InjectMocks
    private CountryValidation validation;

    @Test
    public void shouldNotReturnErrorWhenNotContainTravelMedicalRisk() {
        AgreementDTO request = mock(AgreementDTO.class);
        when(request.getSelectedRisks()).thenReturn(List.of("TRAVEL_EVACUATION"));
        Optional<ValidationErrorDTO> validationErrorOpt = validation.validate(request);
        assertTrue(validationErrorOpt.isEmpty());
        verifyNoInteractions(classifierValueRepository, errorFactory);
    }
    @Test
    public void shouldReturnNoErrorWhenSelectedRisksIsNull() {
        AgreementDTO request = mock(AgreementDTO.class);
        when(request.getSelectedRisks()).thenReturn(null);
        Optional<ValidationErrorDTO> errorOpt = validation.validate(request);
        assertTrue(errorOpt.isEmpty());
    }

    @Test
    public void shouldNotReturnErrorWhenContainTravelMedicalRiskAndCountryIsBlank() {
        AgreementDTO request = mock(AgreementDTO.class);
        when(request.getSelectedRisks()).thenReturn(List.of("TRAVEL_MEDICAL"));
        when(request.getCountry()).thenReturn("");
        Optional<ValidationErrorDTO> validationErrorOpt = validation.validate(request);
        assertTrue(validationErrorOpt.isEmpty());
        verifyNoInteractions(classifierValueRepository, errorFactory);
    }
    @Test
    public void shouldNotReturnErrorWhenContainTravelMedicalRiskAndCountryIsNull() {
        AgreementDTO request = mock(AgreementDTO.class);
        when(request.getSelectedRisks()).thenReturn(List.of("TRAVEL_MEDICAL"));
        when(request.getCountry()).thenReturn(null);
        Optional<ValidationErrorDTO> validationErrorOpt = validation.validate(request);
        assertTrue(validationErrorOpt.isEmpty());
        verifyNoInteractions(classifierValueRepository, errorFactory);
    }

    @Test
    public void shouldReturnErrorWhenCountryNotExistInDb() {
        AgreementDTO request = mock(AgreementDTO.class);
        when(request.getSelectedRisks()).thenReturn(List.of("TRAVEL_MEDICAL"));
        when(request.getCountry()).thenReturn("LATVIA");
        when(classifierValueRepository.findByClassifierTitleAndIc("COUNTRY", "LATVIA"))
                .thenReturn(Optional.empty());
        ValidationErrorDTO validationError = mock(ValidationErrorDTO.class);
        when(errorFactory.buildError("ERROR_CODE_15")).thenReturn(validationError);
        Optional<ValidationErrorDTO> validationErrorOpt = validation.validate(request);
        assertTrue(validationErrorOpt.isPresent());
        assertSame(validationError, validationErrorOpt.get());
    }

    @Test
    public void shouldNotReturnErrorWhenCountryExistInDb() {
        AgreementDTO request = mock(AgreementDTO.class);
        when(request.getSelectedRisks()).thenReturn(List.of("TRAVEL_MEDICAL"));
        when(request.getCountry()).thenReturn("LATVIA");
        ClassifierValue classifierValue = mock(ClassifierValue.class);
        when(classifierValueRepository.findByClassifierTitleAndIc("COUNTRY", "LATVIA"))
                .thenReturn(Optional.of(classifierValue));
        Optional<ValidationErrorDTO> validationErrorOpt = validation.validate(request);
        assertTrue(validationErrorOpt.isEmpty());
        verifyNoInteractions(errorFactory);
    }
}