package lv.javaguru.travel.insurance.core.validations.person;


import lv.javaguru.travel.insurance.core.api.dto.PersonDTO;
import lv.javaguru.travel.insurance.core.api.dto.ValidationErrorDTO;
import lv.javaguru.travel.insurance.core.validations.ValidationErrorFactory;
import lv.javaguru.travel.insurance.core.validations.person.PersonLastNameValidation;
import org.junit.jupiter.api.Assertions;
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
class PersonLastNameValidationTest {
    @Mock
    private ValidationErrorFactory errorFactory;

    @InjectMocks
    private PersonLastNameValidation validation;

    @Test
    public void shouldReturnErrorWhenPersonLastNameIsNull() {
        PersonDTO request = mock(PersonDTO.class);
        when(request.getPersonLastName()).thenReturn(null);
        ValidationErrorDTO validationError = mock(ValidationErrorDTO.class);
        when(errorFactory.buildError("ERROR_CODE_2")).thenReturn(validationError);
        Optional<ValidationErrorDTO> errorOpt = validation.validate(request);
        assertTrue(errorOpt.isPresent());
        assertSame(errorOpt.get(), validationError);
    }

    @Test
    public void shouldReturnErrorWhenPersonLastNameIsEmpty() {
        PersonDTO request = mock(PersonDTO.class);
        when(request.getPersonLastName()).thenReturn("");
        ValidationErrorDTO validationError = mock(ValidationErrorDTO.class);
        when(errorFactory.buildError("ERROR_CODE_2")).thenReturn(validationError);
        Optional<ValidationErrorDTO> errorOpt = validation.validate(request);
        assertTrue(errorOpt.isPresent());
        Assertions.assertEquals(errorOpt.get(), validationError);
    }

    @Test
    public void shouldNotReturnErrorWhenPersonLastNameIsPresent() {
        PersonDTO request = mock(PersonDTO.class);
        when(request.getPersonLastName()).thenReturn("Pupkin");
        Optional<ValidationErrorDTO> errorOpt = validation.validate(request);
        assertTrue(errorOpt.isEmpty());
        verifyNoInteractions(errorFactory);
    }
}