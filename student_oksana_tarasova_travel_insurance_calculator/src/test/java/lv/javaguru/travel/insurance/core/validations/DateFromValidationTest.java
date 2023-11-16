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
class DateFromValidationTest {
    @Mock
    private ErrorCodeUtil errorCodeUtil;
    @InjectMocks
    private DateFromValidation validation;

    @Test
    void validatorDateFrom() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        when(request.getAgreementDateFrom()).thenReturn(createDate("01.01.2021"));
        Optional<ValidationError> validationError = validation.execute(request);
       assertEquals(validationError, Optional.empty());

    }

    @Test
    void validatorDateFromIsNull() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        when(request.getAgreementDateFrom()).thenReturn(null);
        when(errorCodeUtil.getErrorDescription("ERROR_CODE_2")).thenReturn("error description");
        Optional<ValidationError> validationError= validation.execute(request);
        assertTrue(validationError.isPresent());
        assertEquals(validationError.get().getErrorCode(), "ERROR_CODE_2");
        assertEquals(validationError.get().getDescription(), "error description");
    }

    private Date createDate(String dateStr) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}