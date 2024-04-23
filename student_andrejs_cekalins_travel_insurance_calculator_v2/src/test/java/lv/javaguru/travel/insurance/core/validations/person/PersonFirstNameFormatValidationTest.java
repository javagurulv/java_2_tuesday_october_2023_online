package lv.javaguru.travel.insurance.core.validations.person;

import lv.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.core.api.dto.PersonDTO;
import lv.javaguru.travel.insurance.core.api.dto.ValidationErrorDTO;
import lv.javaguru.travel.insurance.core.validations.ValidationErrorFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonFirstNameFormatValidationTest {

    @Mock
    private ValidationErrorFactory errorFactory;


    @InjectMocks
    private PersonFirstNameFormatValidation validation;

    @Test
    public void shouldNotReturnErrorWhenPersonFirstNameIsNull() {
        AgreementDTO agreement = mock(AgreementDTO.class);
        PersonDTO person = mock(PersonDTO.class);
        when(person.getPersonFirstName()).thenReturn(null);
        Optional<ValidationErrorDTO> errorOpt = validation.validate(agreement, person);
        assertTrue(errorOpt.isEmpty());
        verifyNoInteractions(errorFactory);
    }
    @Test
    public void shouldNotReturnErrorWhenPersonFirstNameIsEmpty() {
        AgreementDTO agreement = mock(AgreementDTO.class);
        PersonDTO person = mock(PersonDTO.class);
        when(person.getPersonFirstName()).thenReturn("");
        Optional<ValidationErrorDTO> errorOpt = validation.validate(agreement, person);
        assertTrue(errorOpt.isEmpty());
        verifyNoInteractions(errorFactory);
    }

    @Test
    public void shouldNotReturnErrorWhenPersonFirstNameContainCapitalLetters() {
        AgreementDTO agreement = mock(AgreementDTO.class);
        PersonDTO person = mock(PersonDTO.class);
        when(person.getPersonFirstName()).thenReturn("ADREJS");
        Optional<ValidationErrorDTO> errorOpt = validation.validate(agreement, person);
        assertTrue(errorOpt.isEmpty());
        verifyNoInteractions(errorFactory);
    }

    @Test
    public void shouldNotReturnErrorWhenPersonFirstNameContainSmallLetters() {
        AgreementDTO agreement = mock(AgreementDTO.class);
        PersonDTO person = mock(PersonDTO.class);
        when(person.getPersonFirstName()).thenReturn("andrejs");
        Optional<ValidationErrorDTO> errorOpt = validation.validate(agreement, person);
        assertTrue(errorOpt.isEmpty());
        verifyNoInteractions(errorFactory);
    }

    @Test
    public void shouldNotReturnErrorWhenPersonFirstNameContainDash() {
        AgreementDTO agreement = mock(AgreementDTO.class);
        PersonDTO person = mock(PersonDTO.class);
        when(person.getPersonFirstName()).thenReturn("Andrejs-Viktors");
        Optional<ValidationErrorDTO> errorOpt = validation.validate(agreement, person);
        assertTrue(errorOpt.isEmpty());
        verifyNoInteractions(errorFactory);
    }
    @Test
    public void shouldNotReturnErrorWhenPersonFirstNameContainSpace() {
        AgreementDTO agreement = mock(AgreementDTO.class);
        PersonDTO person = mock(PersonDTO.class);
        when(person.getPersonFirstName()).thenReturn("Andrejs Viktors");
        Optional<ValidationErrorDTO> errorOpt = validation.validate(agreement, person);
        assertTrue(errorOpt.isEmpty());
        verifyNoInteractions(errorFactory);
    }

    @Test
    public void shouldReturnErrorWhenPersonCodeIsNotRightFormatted() {
        AgreementDTO agreement = mock(AgreementDTO.class);
        PersonDTO person = mock(PersonDTO.class);
        when(person.getPersonFirstName()).thenReturn("Andr1js Viktors");
        ValidationErrorDTO validationError = mock(ValidationErrorDTO.class);
        when(errorFactory.buildError(eq("ERROR_CODE_22"), anyList())).thenReturn(validationError);
        Optional<ValidationErrorDTO> errorOpt = validation.validate(agreement, person);
        assertTrue(errorOpt.isPresent());
        assertSame(errorOpt.get(), validationError);
    }
}

