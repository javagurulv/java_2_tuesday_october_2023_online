package lv.javaguru.travel.insurance.core.validations.agreement;

import lv.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.core.api.dto.ValidationErrorDTO;
import lv.javaguru.travel.insurance.core.domain.ClassifierValue;
import lv.javaguru.travel.insurance.core.repositories.ClassifierValueRepository;
import lv.javaguru.travel.insurance.core.validations.ValidationErrorFactory;
import lv.javaguru.travel.insurance.core.validations.agreement.SelectedRisksValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SelectedRisksValidationTest {
    @Mock
    private ClassifierValueRepository classifierValueRepository;
    @Mock private ValidationErrorFactory errorFactory;

    @InjectMocks
    private SelectedRisksValidation validation;

    @Test
    public void shouldNotValidateWhenSelectedRisksIsNull() {
        AgreementDTO request = mock(AgreementDTO.class);
        when(request.getSelectedRisk()).thenReturn(null);
        Assertions.assertTrue(validation.validateList(request).isEmpty());
        verifyNoInteractions(classifierValueRepository, errorFactory);
    }

    @Test
    public void shouldValidateWithoutErrors() {
        AgreementDTO request = mock(AgreementDTO.class);
        when(request.getSelectedRisk()).thenReturn(List.of("RISK_IC_1", "RISK_IC_2"));
        when(classifierValueRepository.findByClassifierTitleAndIc("RISK_TYPE", "RISK_IC_1"))
                .thenReturn(Optional.of(mock(ClassifierValue.class)));
        when(classifierValueRepository.findByClassifierTitleAndIc("RISK_TYPE", "RISK_IC_2"))
                .thenReturn(Optional.of(mock(ClassifierValue.class)));
        Assertions.assertTrue(validation.validateList(request).isEmpty());
    }

    @Test
    public void shouldValidateWithErrors() {
        AgreementDTO request = mock(AgreementDTO.class);
        when(request.getSelectedRisk()).thenReturn(List.of("RISK_IC_1", "RISK_IC_2"));
        when(classifierValueRepository.findByClassifierTitleAndIc("RISK_TYPE", "RISK_IC_1"))
                .thenReturn(Optional.empty());
        when(classifierValueRepository.findByClassifierTitleAndIc("RISK_TYPE", "RISK_IC_2"))
                .thenReturn(Optional.empty());

        ValidationErrorDTO error = mock(ValidationErrorDTO.class);
        when(errorFactory.buildError(eq("ERROR_CODE_9"), anyList())).thenReturn(error);

        Assertions.assertEquals(validation.validateList(request).size(), 2);
    }

}