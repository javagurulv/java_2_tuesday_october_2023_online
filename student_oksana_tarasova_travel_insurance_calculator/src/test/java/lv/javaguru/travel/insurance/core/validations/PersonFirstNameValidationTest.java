package lv.javaguru.travel.insurance.core.validations;

import lv.javaguru.travel.insurance.core.ErrorCodeUtil;
import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.dto.ValidationError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonFirstNameValidationTest {
    @Mock
    private ErrorCodeUtil errorCodeUtil;
    @InjectMocks
    private PersonFirstNameValidation validation;


    @Test
    void validatorFirstName() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("Ivan");
        Optional<ValidationError> validFirstName = validation.execute(request);
        Optional<ValidationError> expected = Optional.empty();
        assertEquals(expected, validFirstName);
    }

    @Test
    void validatorFirstNameIsNull() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn(null);
        when(errorCodeUtil.getErrorDescription("ERROR_CODE_7")).thenReturn("error description");
        Optional<ValidationError> validFirstName = validation.execute(request);
        assertTrue(validFirstName.isPresent());
        assertEquals(validFirstName.get().getErrorCode(), "ERROR_CODE_7");
        assertEquals(validFirstName.get().getDescription(), "error description");
    }

    @Test
    void validatorFirstNameIsEmpty() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("");
        when(errorCodeUtil.getErrorDescription("ERROR_CODE_7")).thenReturn("error description");
        Optional<ValidationError> validFirstName = validation.execute(request);
        assertTrue(validFirstName.isPresent());
        assertEquals(validFirstName.get().getErrorCode(), "ERROR_CODE_7");
        assertEquals(validFirstName.get().getDescription(), "error description");
    }
}