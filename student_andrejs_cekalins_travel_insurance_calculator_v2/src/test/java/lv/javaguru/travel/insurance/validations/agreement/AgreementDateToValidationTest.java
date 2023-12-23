package lv.javaguru.travel.insurance.validations.agreement;

import lv.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.core.api.dto.ValidationErrorDTO;
import lv.javaguru.travel.insurance.core.validations.ValidationErrorFactory;
import lv.javaguru.travel.insurance.core.validations.agreement.AgreementDateToValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AgreementDateToValidationTest {
    @Mock
    private ValidationErrorFactory errorFactory;

    @InjectMocks
    private AgreementDateToValidation validation;

    @Test
    public void shouldReturnErrorWhenAgreementDateToIsNull() {
        AgreementDTO request = mock(AgreementDTO.class);
        when(request.getAgreementDateTo()).thenReturn(null);
        ValidationErrorDTO validationError = mock(ValidationErrorDTO.class);
        when(errorFactory.buildError("ERROR_CODE_6")).thenReturn(validationError);
        Optional<ValidationErrorDTO> errorOpt = validation.validate(request);
        assertTrue(errorOpt.isPresent());
        Assertions.assertEquals(errorOpt.get(), validationError);
    }

    @Test
    public void shouldNotReturnErrorWhenAgreementDateToIsPresent() {
        AgreementDTO request = mock(AgreementDTO.class);
        when(request.getAgreementDateTo()).thenReturn(createDate("01.11.2025"));
        Optional<ValidationErrorDTO> errorOpt = validation.validate(request);
        assertTrue(errorOpt.isEmpty());
        verifyNoInteractions(errorFactory);
    }

    private Date createDate(String dateStr) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}