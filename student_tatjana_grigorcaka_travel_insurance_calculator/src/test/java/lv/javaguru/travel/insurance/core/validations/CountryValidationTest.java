package lv.javaguru.travel.insurance.core.validations;

import lv.javaguru.travel.insurance.core.domain.ClassifierValue;
import lv.javaguru.travel.insurance.core.repositories.ClassifierValueRepository;
import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.dto.ValidationError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CountryValidationTest {


    @Mock private ClassifierValueRepository classifierValueRepository;
    @Mock private ValidationErrorFactory errorFactory;

    @InjectMocks
    private CountryValidation validation;

    @Test
    public void shouldReturnNoErrorWhenSelectedRisksIsNull() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getSelectedRisks()).thenReturn(null);
        Optional<ValidationError> errorOpt = validation.validate(request);
        assertTrue(errorOpt.isEmpty());
    }

    @Test
    public void shouldReturnNoErrorWhenSelectedRisksNotContainsTravelMedical() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getSelectedRisks()).thenReturn(List.of("TRAVEL_EVACUATION"));
        Optional<ValidationError> errorOpt = validation.validate(request);
        assertTrue(errorOpt.isEmpty());
    }

    @Test
    public void shouldReturnNoErrorWhenContainsTravelMedicalAndCountryIsNull() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getSelectedRisks()).thenReturn(List.of("TRAVEL_MEDICAL"));
        when(request.getCountry()).thenReturn(null);
        Optional<ValidationError> validationErrorOpt = validation.validate(request);
        assertTrue(validationErrorOpt.isEmpty());
        verifyNoInteractions(classifierValueRepository, errorFactory);
    }

    @Test
    public void shouldReturnNoErrorWhenContainsTravelMedicalAndCountryIsBlank() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getSelectedRisks()).thenReturn(List.of("TRAVEL_MEDICAL"));
        when(request.getCountry()).thenReturn("");
        Optional<ValidationError> validationErrorOpt = validation.validate(request);
        assertTrue(validationErrorOpt.isEmpty());
        verifyNoInteractions(classifierValueRepository, errorFactory);
    }

    @Test
    public void shouldReturnNoErrorWhenContainsTravelMedicalAndCountryExistInDb() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getSelectedRisks()).thenReturn(List.of("TRAVEL_MEDICAL"));
        when(request.getCountry()).thenReturn("SPAIN");
        ClassifierValue classifierValue = mock(ClassifierValue.class);
        when(classifierValueRepository.findByClassifierTitleAndIc("COUNTRY", "SPAIN"))
                .thenReturn(Optional.of(classifierValue));
        Optional<ValidationError> validationErrorOpt = validation.validate(request);
        assertTrue(validationErrorOpt.isEmpty());
        verifyNoInteractions(errorFactory);
    }

    @Test
    public void shouldReturnErrorWhenContainsTravelMedicalAndCountryNotExistInDb() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getSelectedRisks()).thenReturn(List.of("TRAVEL_MEDICAL"));
        when(request.getCountry()).thenReturn("SWITZERLAND");
        when(classifierValueRepository.findByClassifierTitleAndIc("COUNTRY", "SWITZERLAND"))
                .thenReturn(Optional.empty());
        ValidationError validationError = mock(ValidationError.class);
        when(errorFactory.buildError("ERROR_CODE_15")).thenReturn(validationError);
        Optional<ValidationError> validationErrorOpt = validation.validate(request);
        assertTrue(validationErrorOpt.isPresent());
        assertSame(validationError, validationErrorOpt.get());
    }

}
