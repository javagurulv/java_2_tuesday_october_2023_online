package lv.javaguru.travel.insurance.core.validations;

import lv.javaguru.travel.insurance.core.util.DateTimeUtil;
import lv.javaguru.travel.insurance.core.util.ErrorCodeUnit;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AgreementDateToInTheFutureValidationTest {

    @Mock
    private DateTimeUtil dateTimeService;
    @Mock
    private ErrorCodeUnit errorCodeUnit;

    @InjectMocks
    private AgreementDateToInTheFutureValidation validation;

    @Test
    public void shouldReturnErrorWhenAgreementDateToInThePast() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getAgreementDateTo()).thenReturn(createDate("01.11.2021"));
        when(dateTimeService.getCurrentDateTime()).thenReturn(createDate("01.11.2023"));
        when(errorCodeUnit.getErrorDescription("ERROR_CODE_7")).thenReturn("Field agreementDayTo must be in the future!");
        Optional<ValidationError> errorOpt = validation.execute(request);
        assertTrue(errorOpt.isPresent());
        assertEquals(errorOpt.get().getErrorCode(), "ERROR_CODE_7");
        assertEquals(errorOpt.get().getDescription(), "Field agreementDayTo must be in the future!");
    }

    @Test
    public void shouldNotReturnErrorWhenAgreementDateToInTheFuture() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getAgreementDateTo()).thenReturn(createDate("01.11.2025"));
        when(dateTimeService.getCurrentDateTime()).thenReturn(createDate("01.11.2023"));
        Optional<ValidationError> errorOpt = validation.execute(request);
        assertTrue(errorOpt.isEmpty());
        verifyNoInteractions(errorCodeUnit);
    }

    private Date createDate(String dateStr) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}