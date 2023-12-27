package lv.javaguru.travel.insurance.core.validations;

import lv.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.core.api.dto.ValidationErrorDTO;
import lv.javaguru.travel.insurance.core.validations.TravelAgreementFieldValidation;
import lv.javaguru.travel.insurance.core.validations.TravelAgreementFieldValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TravelAgreementFieldValidatorTest {

@InjectMocks
    private TravelAgreementFieldValidator validator;

@Test
    public void shouldNotReturnErrors() {
    AgreementDTO agreement = mock(AgreementDTO.class);
    TravelAgreementFieldValidation validation1 = mock(TravelAgreementFieldValidation.class);
    when(validation1.validate(agreement)).thenReturn(Optional.empty());
    when(validation1.validateList(agreement)).thenReturn(List.of());
    TravelAgreementFieldValidation validation2 = mock(TravelAgreementFieldValidation.class);
    when(validation2.validate(agreement)).thenReturn(Optional.empty());
    when(validation2.validateList(agreement)).thenReturn(List.of());

    List<TravelAgreementFieldValidation> agreementValidation = List.of(validation1, validation2);
    ReflectionTestUtils.setField(validator, "agreementFieldValidations", agreementValidation);

    List<ValidationErrorDTO> errors = validator.validate(agreement);

    assertTrue(errors.isEmpty());
}

    @Test
    public void shouldReturnSingleAgreementErrors() {
        AgreementDTO agreement = mock(AgreementDTO.class);
        TravelAgreementFieldValidation validation1 = mock(TravelAgreementFieldValidation.class);
        when(validation1.validate(agreement)).thenReturn(Optional.of(new ValidationErrorDTO()));
        when(validation1.validateList(agreement)).thenReturn(List.of());
        TravelAgreementFieldValidation validation2 = mock(TravelAgreementFieldValidation.class);
        when(validation2.validate(agreement)).thenReturn(Optional.of(new ValidationErrorDTO()));
        when(validation2.validateList(agreement)).thenReturn(List.of());

        List<TravelAgreementFieldValidation> agreementValidation = List.of(validation1, validation2);
        ReflectionTestUtils.setField(validator, "agreementFieldValidations", agreementValidation);

        List<ValidationErrorDTO> errors = validator.validate(agreement);

        assertEquals(errors.size(), 2);
}

    @Test
    public void shouldReturnListAgreementErrors() {
        AgreementDTO agreement = mock(AgreementDTO.class);
        TravelAgreementFieldValidation validation1 = mock(TravelAgreementFieldValidation.class);
        when(validation1.validate(agreement)).thenReturn(Optional.empty());
        when(validation1.validateList(agreement)).thenReturn(List.of(new ValidationErrorDTO()));
        TravelAgreementFieldValidation validation2 = mock(TravelAgreementFieldValidation.class);
        when(validation2.validate(agreement)).thenReturn(Optional.empty());
        when(validation2.validateList(agreement)).thenReturn(List.of(new ValidationErrorDTO()));

        List<TravelAgreementFieldValidation> agreementValidation = List.of(validation1, validation2);
        ReflectionTestUtils.setField(validator, "agreementFieldValidations", agreementValidation);

        List<ValidationErrorDTO> errors = validator.validate(agreement);

        assertEquals(errors.size(), 2);
    }

}