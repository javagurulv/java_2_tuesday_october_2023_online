package lv.javaguru.travel.insurance.core.validations;

import lv.javaguru.travel.insurance.core.ErrorCodeUnit;
import lv.javaguru.travel.insurance.core.validations.AgreementDateLessThanDateToValidation;
import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.dto.ValidationError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class AgreementDateLessThanDateToValidationTest {
@Mock
private ErrorCodeUnit errorCodeUnit;

@InjectMocks
    private AgreementDateLessThanDateToValidation validation;
    @Test
    public void shouldReturnErrorWhenDateFromIsAfterDateTo() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getAgreementDateFrom()).thenReturn(createDate("02.11.2023"));
        when(request.getAgreementDateTo()).thenReturn(createDate("01.11.2023"));
        when(errorCodeUnit.getErrorDescription("ERROR_CODE_5")).thenReturn("Field agreementDateFrom must be less than agreementDateTo!");
        Optional<ValidationError> errorOpt = validation.execute(request);
        assertTrue(errorOpt.isPresent());
        assertEquals(errorOpt.get().getErrorCode(), "ERROR_CODE_5");
        assertEquals(errorOpt.get().getDescription(), "Field agreementDateFrom must be less than agreementDateTo!");
    }

    @Test
    public void shouldReturnErrorWhenDateFromIsEqualsDateTo() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getAgreementDateFrom()).thenReturn(createDate("01.11.2023"));
        when(request.getAgreementDateTo()).thenReturn(createDate("01.11.2023"));
        when(errorCodeUnit.getErrorDescription("ERROR_CODE_5")).thenReturn("Field agreementDateFrom must be less than agreementDateTo!");
        Optional<ValidationError> errorOpt = validation.execute(request);
        assertTrue(errorOpt.isPresent());
        assertEquals(errorOpt.get().getErrorCode(), "ERROR_CODE_5");
        assertEquals(errorOpt.get().getDescription(), "Field agreementDateFrom must be less than agreementDateTo!");
    }

    @Test
    public void shouldNotReturnErrorWhenDateFromIsLessDateTo() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getAgreementDateFrom()).thenReturn(createDate("01.11.2023"));
        when(request.getAgreementDateTo()).thenReturn(createDate("03.11.2023"));
        Optional<ValidationError> errorOpt = validation.execute(request);
        assertTrue(errorOpt.isEmpty());
    }

    private Date createDate(String dateStr) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}