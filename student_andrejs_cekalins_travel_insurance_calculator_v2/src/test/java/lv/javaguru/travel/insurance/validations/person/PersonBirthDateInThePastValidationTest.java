package lv.javaguru.travel.insurance.validations.person;

import lv.javaguru.travel.insurance.core.api.dto.PersonDTO;
import lv.javaguru.travel.insurance.core.api.dto.ValidationErrorDTO;
import lv.javaguru.travel.insurance.core.util.DateTimeUtil;
import lv.javaguru.travel.insurance.core.validations.ValidationErrorFactory;
import lv.javaguru.travel.insurance.core.validations.person.PersonBirthDateInThePastValidation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonBirthDateInThePastValidationTest {
    @Mock
    private DateTimeUtil dateTimeUtil;

    @Mock
    private ValidationErrorFactory errorFactory;

    @InjectMocks
    PersonBirthDateInThePastValidation validation;

    @Test
    public void shouldReturnErrorWhenPersonBirthDateInTheFuture() {
        PersonDTO request = mock(PersonDTO.class);
        when(request.getPersonBirthDate()).thenReturn(createDate("01.01.2025"));
        when(dateTimeUtil.getCurrentDateTime()).thenReturn(createDate("02.12.2023"));
        ValidationErrorDTO validationError = mock(ValidationErrorDTO.class);
        when(errorFactory.buildError("ERROR_CODE_12")).thenReturn(validationError);
        Optional<ValidationErrorDTO> errorOpt =validation.validate(request);
        assertTrue(errorOpt.isPresent());
        assertSame(errorOpt.get(), validationError);
    }
    @Test
    public void shouldNotReturnErrorWhenPersonBirthDateDateInThePast() {
        PersonDTO request = mock(PersonDTO.class);
        when(request.getPersonBirthDate()).thenReturn(createDate("01.01.1991"));
        when(dateTimeUtil.getCurrentDateTime()).thenReturn(createDate("02.12.2023"));
        Optional<ValidationErrorDTO> errorOpt =validation.validate(request);
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