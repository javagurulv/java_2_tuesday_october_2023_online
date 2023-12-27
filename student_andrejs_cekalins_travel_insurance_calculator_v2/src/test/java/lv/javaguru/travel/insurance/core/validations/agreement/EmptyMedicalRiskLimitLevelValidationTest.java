package lv.javaguru.travel.insurance.core.validations.agreement;

import lv.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.core.api.dto.ValidationErrorDTO;
import lv.javaguru.travel.insurance.core.validations.ValidationErrorFactory;
import lv.javaguru.travel.insurance.core.validations.agreement.EmptyMedicalRiskLimitLevelValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmptyMedicalRiskLimitLevelValidationTest {
    @Mock
    private ValidationErrorFactory errorFactory;

    @InjectMocks
    EmptyMedicalRiskLimitLevelValidation validation;

    private AgreementDTO request;

    @BeforeEach
    void setUp() {
        request = new AgreementDTO();
    }


    @Test
    void shouldReturnValidationErrorWhenMedicalRiskLimitLevelEnabledAndNullOrBlank() {
        request.setSelectedRisks(List.of("TRAVEL_MEDICAL"));
        request.setMedicalRiskLimitLevel(null);
        ValidationErrorDTO expectedError = mock(ValidationErrorDTO.class);
        when(errorFactory.buildError("ERROR_CODE_13")).thenReturn(expectedError);

        ReflectionTestUtils.setField(validation, "medicalRiskLimitLevelEnabled", true);

        Optional<ValidationErrorDTO> result = validation.validate(request);

        assertTrue(result.isPresent());
        Assertions.assertEquals(expectedError, result.get());
    }

    @Test
    void shouldNotReturnValidationErrorWhenMedicalRiskLimitLevelEnabledAndIsNotBlank() {
        request.setSelectedRisks(List.of("TRAVEL_MEDICAL"));
        request.setMedicalRiskLimitLevel("LEVEL_10000");
        ReflectionTestUtils.setField(validation, "medicalRiskLimitLevelEnabled", true);
        Optional<ValidationErrorDTO> result = validation.validate(request);
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldNotReturnValidationErrorWhenMedicalRiskLimitLevelNotEnabledAndIsBlank() {
        request.setSelectedRisks(List.of("TRAVEL_MEDICAL"));
        request.setMedicalRiskLimitLevel("");
        ReflectionTestUtils.setField(validation, "medicalRiskLimitLevelEnabled", false);
        Optional<ValidationErrorDTO> result = validation.validate(request);
        assertTrue(result.isEmpty());
    }
}