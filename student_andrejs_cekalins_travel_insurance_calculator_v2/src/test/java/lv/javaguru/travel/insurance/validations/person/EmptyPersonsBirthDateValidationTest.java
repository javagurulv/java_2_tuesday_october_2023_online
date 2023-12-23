package lv.javaguru.travel.insurance.validations.person;

import lv.javaguru.travel.insurance.core.api.dto.PersonDTO;
import lv.javaguru.travel.insurance.core.api.dto.ValidationErrorDTO;
import lv.javaguru.travel.insurance.core.validations.ValidationErrorFactory;
import lv.javaguru.travel.insurance.core.validations.person.EmptyPersonsBirthDateValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmptyPersonsBirthDateValidationTest {
    @Mock
    private ValidationErrorFactory errorFactory;

    @InjectMocks
    private EmptyPersonsBirthDateValidation validation;

    @Test
    public void shouldReturnErrorWhenPersonBirtDayIsNull() {
        PersonDTO request = mock(PersonDTO.class);
        when(request.getPersonBirthDate()).thenReturn(null);
        when(errorFactory.buildError("ERROR_CODE_11")).thenReturn(new ValidationErrorDTO("ERROR_CODE_11",
                "Person Birth Date must be provided when TRAVEL_MEDICAL is selected"));
        Optional<ValidationErrorDTO> errorOpt = validation.validate(request);
        assertTrue(errorOpt.isPresent());
        Assertions.assertEquals("ERROR_CODE_11", errorOpt.get().getErrorCode());
        Assertions.assertEquals("Person Birth Date must be provided when TRAVEL_MEDICAL is selected",
                errorOpt.get().getDescription());
    }
    @Test
    public void shouldReturnNoErrorWhenPersonBirthDateIsPresent() {
        PersonDTO request = mock(PersonDTO.class);
        when(request.getPersonBirthDate()).thenReturn(new Date());
        Optional<ValidationErrorDTO> errorOpt = validation.validate(request);
        assertTrue(errorOpt.isEmpty());
    }
}