package lv.javaguru.travel.insurance.core.services;

import lv.javaguru.travel.insurance.core.underwriting.TravelPremiumCalculationResult;
import lv.javaguru.travel.insurance.core.underwriting.TravelPremiumUnderwriting;
import lv.javaguru.travel.insurance.core.validations.TravelCalculatePremiumRequestValidatorImpl;
import lv.javaguru.travel.insurance.dto.v1.TravelCalculatePremiumRequestV1;
import lv.javaguru.travel.insurance.dto.v1.TravelCalculatePremiumResponseV1;
import lv.javaguru.travel.insurance.dto.ValidationError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TravelCalculatePremiumServiceImplTest {
    @Mock
    private TravelCalculatePremiumRequestValidatorImpl requestValidator;
    @Mock
    private TravelPremiumUnderwriting travelPremiumUnderwriting;
    SimpleDateFormat dates = new SimpleDateFormat("dd.MM.yyyy");
    @InjectMocks
    private TravelCalculatePremiumServiceImpl service;

    @Test
    void shouldReturnResponseWithErrors() {
        TravelCalculatePremiumRequestV1 request = mock(TravelCalculatePremiumRequestV1.class);
        List<ValidationError> errors = buildValidationErrorList();
        when(requestValidator.validate(request)).thenReturn(errors);
        TravelCalculatePremiumResponseV1 response = service.calculatePremium(request);
        assertTrue(response.hasErrors());
    }

    @Test
    void shouldReturnResponseWithValidationErrors() {
        TravelCalculatePremiumRequestV1 request = mock(TravelCalculatePremiumRequestV1.class);
        List<ValidationError> errors = buildValidationErrorList();
        when(requestValidator.validate(request)).thenReturn(errors);
        TravelCalculatePremiumResponseV1 response = service.calculatePremium(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "field");
        assertEquals(errors.get(0).getDescription(), "errorMessage!");
    }

    @Test
    void shouldReturnResponseWithCorrectFirstName() {
        TravelCalculatePremiumRequestV1 request = mock(TravelCalculatePremiumRequestV1.class);
        when(request.getPersonFirstName()).thenReturn("firstName");
        when(requestValidator.validate(request)).thenReturn(List.of());
        TravelPremiumCalculationResult calculationResult = mock(TravelPremiumCalculationResult.class);
        when(travelPremiumUnderwriting.calculatePremium(request)).thenReturn(calculationResult);
        TravelCalculatePremiumResponseV1 response = service.calculatePremium(request);
        assertEquals(response.getPersonFirstName(), "firstName");
    }

    @Test
    void shouldReturnResponseWithCorrectLastName() {
        TravelCalculatePremiumRequestV1 request = mock(TravelCalculatePremiumRequestV1.class);
        when(request.getPersonLastName()).thenReturn("lastName");
        when(requestValidator.validate(request)).thenReturn(List.of());
        when(requestValidator.validate(request)).thenReturn(List.of());
        TravelPremiumCalculationResult calculationResult = mock(TravelPremiumCalculationResult.class);
        when(travelPremiumUnderwriting.calculatePremium(request)).thenReturn(calculationResult);
        TravelCalculatePremiumResponseV1 response = service.calculatePremium(request);
        assertEquals(response.getPersonLastName(), "lastName");
    }

    @Test
    void shouldReturnResponseWithCorrectAgreementDateFrom() throws ParseException {
        Date dateFrom = new Date();
        TravelCalculatePremiumRequestV1 request = mock(TravelCalculatePremiumRequestV1.class);
        when(request.getAgreementDateFrom()).thenReturn(dateFrom);
        when(requestValidator.validate(request)).thenReturn(List.of());
        TravelPremiumCalculationResult calculationResult = mock(TravelPremiumCalculationResult.class);
        when(travelPremiumUnderwriting.calculatePremium(request)).thenReturn(calculationResult);
        TravelCalculatePremiumResponseV1 response = service.calculatePremium(request);
        assertEquals(response.getAgreementDateFrom(), dateFrom);
    }

    @Test
    void shouldReturnResponseWithCorrectAgreementDateTo() throws ParseException {
        Date dateTo = new Date();
        TravelCalculatePremiumRequestV1 request = mock(TravelCalculatePremiumRequestV1.class);
        when(request.getAgreementDateTo()).thenReturn(dateTo);
        when(requestValidator.validate(request)).thenReturn(List.of());
        TravelPremiumCalculationResult calculationResult = mock(TravelPremiumCalculationResult.class);
        when(travelPremiumUnderwriting.calculatePremium(request)).thenReturn(calculationResult);
        TravelCalculatePremiumResponseV1 response = service.calculatePremium(request);
        assertEquals(response.getAgreementDateTo(), dateTo);
    }

    @Test
    void shouldReturnResponseWithCorrectAgreementPrice() throws ParseException {
        Date dateFrom = dates.parse("01.10.2023");
        Date dateTo = dates.parse("05.10.2023");
        TravelCalculatePremiumRequestV1 request = mock(TravelCalculatePremiumRequestV1.class);
        when(request.getAgreementDateFrom()).thenReturn(dateFrom);
        when(request.getAgreementDateTo()).thenReturn(dateTo);
        when(requestValidator.validate(request)).thenReturn(List.of());
        TravelPremiumCalculationResult premiumCalculationResult = new TravelPremiumCalculationResult(new BigDecimal(9), null);
        when(travelPremiumUnderwriting.calculatePremium(request)).thenReturn(premiumCalculationResult);
        TravelCalculatePremiumResponseV1 response = service.calculatePremium(request);
        assertEquals(response.getAgreementPremium(), new BigDecimal(9));
    }

    private List<ValidationError> buildValidationErrorList() {
        return List.of(new ValidationError("field", "errorMessage!"));
    }
}