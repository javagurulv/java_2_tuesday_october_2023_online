package lv.javaguru.travel.insurance.tests;

import lv.javaguru.travel.insurance.core.DateTimeService;
import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.core.TravelCalculatePremiumRequestValidator;
import lv.javaguru.travel.insurance.dto.ValidationError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TravelCalculatePremiumRequestValidatorTest {
    @InjectMocks
    private TravelCalculatePremiumRequestValidator requestValidator;
    SimpleDateFormat dates = new SimpleDateFormat("dd.MM.yyyy");
    @Mock
    private DateTimeService dateTimeService = new DateTimeService();

    @Test
    void shouldReturnErrorWhenPersonFirstNameIsNull() throws ParseException {

        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        Date date1 = dates.parse("02.11.2023");
        Date date2 = dates.parse("03.11.2023");
        Date currentDateTime = dates.parse("01.11.2023");
        when(request.getPersonFirstName()).thenReturn(null);
        when(request.getPersonLastName()).thenReturn("lastName");
        when(request.getAgreementDateFrom()).thenReturn(date1);
        when(request.getAgreementDateTo()).thenReturn(date2);
        when(dateTimeService.getCurrentDateTime()).thenReturn(currentDateTime);
        List<ValidationError> errors = requestValidator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "personFirstName");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    void shouldReturnErrorWhenPersonFirstNameIsEmpty() throws ParseException {
        Date date1 = dates.parse("02.11.2023");
        Date date2 = dates.parse("03.11.2023");
        Date currentDateTime = dates.parse("01.11.2023");
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("");
        when(request.getPersonLastName()).thenReturn("lastName");
        when(request.getAgreementDateFrom()).thenReturn(date1);
        when(request.getAgreementDateTo()).thenReturn(date2);
        when(dateTimeService.getCurrentDateTime()).thenReturn(currentDateTime);
        List<ValidationError> errors = requestValidator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "personFirstName");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    void shouldReturnErrorWhenPersonLastNameIsNull() throws ParseException {
        Date date1 = dates.parse("02.11.2023");
        Date date2 = dates.parse("03.11.2023");
        Date currentDateTime = dates.parse("01.11.2023");
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("firstName");
        when(request.getPersonLastName()).thenReturn(null);
        when(request.getAgreementDateFrom()).thenReturn(date1);
        when(request.getAgreementDateTo()).thenReturn(date2);
        when(dateTimeService.getCurrentDateTime()).thenReturn(currentDateTime);
        List<ValidationError> errors = requestValidator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "personLastName");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    void shouldReturnErrorWhenPersonLastNameIsEmpty() throws ParseException {
        Date date1 = dates.parse("02.11.2023");
        Date date2 = dates.parse("03.11.2023");
        Date currentDateTime = dates.parse("01.11.2023");
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("firstName");
        when(request.getPersonLastName()).thenReturn("");
        when(request.getAgreementDateFrom()).thenReturn(date1);
        when(request.getAgreementDateTo()).thenReturn(date2);
        when(dateTimeService.getCurrentDateTime()).thenReturn(currentDateTime);
        List<ValidationError> errors = requestValidator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "personLastName");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    void shouldReturnErrorWhenAgreementDateFromIsNull() throws ParseException {
        Date date2 = dates.parse("02.11.2023");
        Date currentDateTime = dates.parse("01.11.2023");
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("firstName");
        when(request.getPersonLastName()).thenReturn("lastName");
        when(request.getAgreementDateFrom()).thenReturn(null);
        when(request.getAgreementDateTo()).thenReturn(date2);
        when(dateTimeService.getCurrentDateTime()).thenReturn(currentDateTime);
        List<ValidationError> errors = requestValidator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "agreementDateFrom");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    void shouldReturnErrorWhenAgreementDateToIsNull() throws ParseException {
        Date date1 = dates.parse("02.11.2023");
        Date currentDateTime = dates.parse("01.11.2023");
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("firstName");
        when(request.getPersonLastName()).thenReturn("lastName");
        when(request.getAgreementDateFrom()).thenReturn(date1);
        when(request.getAgreementDateTo()).thenReturn(null);
        when(dateTimeService.getCurrentDateTime()).thenReturn(currentDateTime);
        List<ValidationError> errors = requestValidator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "agreementDateTo");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    void shouldNotReturnErrorWhenAllFieldsArePresent() throws ParseException {
        Date date1 = dates.parse("02.11.2023");
        Date date2 = dates.parse("03.11.2023");
        Date currentDateTime = dates.parse("01.11.2023");
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("firstName");
        when(request.getPersonLastName()).thenReturn("lastName");
        when(request.getAgreementDateFrom()).thenReturn(date1);
        when(request.getAgreementDateTo()).thenReturn(date2);
        when(dateTimeService.getCurrentDateTime()).thenReturn(currentDateTime);
        List<ValidationError> errors = requestValidator.validate(request);
        assertTrue(errors.isEmpty());
    }

    @Test
    void shouldReturnErrorWhenAgreementDateFromIsAfterThanDateTo() throws ParseException {
        Date date1 = dates.parse("04.11.2023");
        Date date2 = dates.parse("03.11.2023");
        Date currentDateTime = dates.parse("02.11.2023");
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("firstName");
        when(request.getPersonLastName()).thenReturn("lastName");
        when(request.getAgreementDateFrom()).thenReturn(date1);
        when(request.getAgreementDateTo()).thenReturn(date2);
        when(dateTimeService.getCurrentDateTime()).thenReturn(currentDateTime);
        List<ValidationError> errors = requestValidator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "agreementDateFrom");
        assertEquals(errors.get(0).getMessage(), "Must be less then agreementDateTo!");
    }

    @Test
    void shouldReturnErrorWhenAgreementDateFromIsEqualDateTo() throws ParseException {
        Date date1 = dates.parse("03.11.2023");
        Date date2 = dates.parse("03.11.2023");
        Date currentDateTime = dates.parse("02.11.2023");
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("firstName");
        when(request.getPersonLastName()).thenReturn("lastName");
        when(request.getAgreementDateFrom()).thenReturn(date1);
        when(request.getAgreementDateTo()).thenReturn(date2);
        when(dateTimeService.getCurrentDateTime()).thenReturn(currentDateTime);
        List<ValidationError> errors = requestValidator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "agreementDateFrom");
        assertEquals(errors.get(0).getMessage(), "Must be less then agreementDateTo!");
    }

    @Test
    void shouldReturnErrorWhenAgreementDateFromInThePast() throws ParseException {
        Date dateFrom = dates.parse("01.11.2023");
        Date dateTo = dates.parse("03.11.2023");
        Date currentDateTime = dates.parse("02.11.2023");
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("firstName");
        when(request.getPersonLastName()).thenReturn("lastName");
        when(request.getAgreementDateFrom()).thenReturn(dateFrom);
        when(request.getAgreementDateTo()).thenReturn(dateTo);
        when(dateTimeService.getCurrentDateTime()).thenReturn(currentDateTime);
        List<ValidationError> errors = requestValidator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "agreementDateFrom");
        assertEquals(errors.get(0).getMessage(), "Must be in the future!");
    }
    @Test
    void shouldReturnErrorWhenAgreementDateToInThePast() throws ParseException {
        Date dateFrom = dates.parse("03.11.2023");
        Date dateTo = dates.parse("04.11.2020");
        Date currentDateTime = dates.parse("02.11.2023");
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("firstName");
        when(request.getPersonLastName()).thenReturn("lastName");
        when(request.getAgreementDateFrom()).thenReturn(dateFrom);
        when(request.getAgreementDateTo()).thenReturn(dateTo);
        when(dateTimeService.getCurrentDateTime()).thenReturn(currentDateTime);
        List<ValidationError> errors = requestValidator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 2);
        assertEquals(errors.get(1).getField(), "agreementDateTo");
        assertEquals(errors.get(1).getMessage(), "Must be in the future!");
    }
}