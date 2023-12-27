package lv.javaguru.travel.insurance.core.validations.agreement;

import lv.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.core.api.dto.ValidationErrorDTO;
import lv.javaguru.travel.insurance.core.validations.ValidationErrorFactory;
import lv.javaguru.travel.insurance.core.validations.agreement.EmptyCountryValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
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
        AgreementDTO request = mock(AgreementDTO.class);
        when(request.getCountry()).thenReturn("Latvia");
        Optional<ValidationErrorDTO> errorOpt = validation.validate(request);
        assertTrue(errorOpt.isEmpty());
    }

    @Test
    public void shouldReturnErrorWhenCountryIsNull() {
        AgreementDTO request = mock(AgreementDTO.class);
        when(request.getCountry()).thenReturn(null);
        when(errorFactory.buildError("ERROR_CODE_10")).
                thenReturn(new ValidationErrorDTO("ERROR_CODE_10", "Field country must not be empty!"));
        Optional<ValidationErrorDTO> errorOpt = validation.validate(request);
        assertTrue(errorOpt.isPresent());
        Assertions.assertEquals("ERROR_CODE_10", errorOpt.get().getErrorCode());
        Assertions.assertEquals("Field country must not be empty!", errorOpt.get().getDescription());
    }

    @Test
    public void shouldReturnErrorWhenCountryIsEmpty() {
        AgreementDTO request = mock(AgreementDTO.class);
        when(request.getCountry()).thenReturn("");
        when(errorFactory.buildError("ERROR_CODE_10")).
                thenReturn(new ValidationErrorDTO("ERROR_CODE_10", "Field country must not be empty!"));
        Optional<ValidationErrorDTO> errorOpt = validation.validate(request);
        assertTrue(errorOpt.isPresent());
        Assertions.assertEquals("ERROR_CODE_10", errorOpt.get().getErrorCode());
        Assertions.assertEquals("Field country must not be empty!", errorOpt.get().getDescription());
    }
}