package lv.javaguru.travel.insurance.core.validations;

import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.dto.ValidationError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
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
class DateFromIsLessDateToValidationTest {

    @InjectMocks
    private DateFromIsLessDateToValidation validation;

    @Test
    void validateDateFromIsLessDateTo() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        when(request.getAgreementDateFrom()).thenReturn(createDate("01.04.2024"));
        when(request.getAgreementDateTo()).thenReturn(createDate("16.05.2024"));
        Optional<ValidationError> validationError = validation.execute(request);
        assertEquals(validationError, Optional.empty());
    }

    @Test
    void validateDateToIsLessDateFrom() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        when(request.getAgreementDateFrom()).thenReturn(createDate("01.06.2024"));
        when(request.getAgreementDateTo()).thenReturn(createDate("16.05.2024"));
        Optional<ValidationError> validationError = validation.execute(request);
        ValidationError expected = (new ValidationError("agreementDateFrom", "Must be less than the agreementDateTo!"));
        assertThat(validationError).contains(expected);
    }


    private Date createDate(String dateStr) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}