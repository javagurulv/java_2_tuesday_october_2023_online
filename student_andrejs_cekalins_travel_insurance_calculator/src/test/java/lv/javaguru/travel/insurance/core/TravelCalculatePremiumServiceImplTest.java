package lv.javaguru.travel.insurance.core;

import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumResponse;
import lv.javaguru.travel.insurance.dto.ValidationError;
import org.junit.jupiter.api.Disabled;
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
    private TravelCalculatePremiumRequestValidator requestValidator;
    @Mock
    private TravelPremiumUnderwriting travelPremiumUnderwriting;
     SimpleDateFormat dates = new SimpleDateFormat("dd.MM.yyyy");
    @InjectMocks
    private TravelCalculatePremiumServiceImpl service;

    @Test
    void shouldReturnResponseWithErrors() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        List<ValidationError> errors = buildValidationErrorList();
        when(requestValidator.validate(request)).thenReturn(errors);
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertTrue(response.hasError());
    }

    @Test
    void shouldReturnResponseWithValidationErrors() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        List<ValidationError> errors = buildValidationErrorList();
        when(requestValidator.validate(request)).thenReturn(errors);
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "field");
        assertEquals(errors.get(0).getMessage(), "errorMessage!");
    }

    @Test
    void shouldReturnResponseWithCorrectFirstName() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("firstName");
        when(requestValidator.validate(request)).thenReturn(List.of());
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(response.getPersonFirstName(), "firstName");
    }

    @Test
    void shouldReturnResponseWithCorrectLastName() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonLastName()).thenReturn("lastName");
        when(requestValidator.validate(request)).thenReturn(List.of());
        when(requestValidator.validate(request)).thenReturn(List.of());
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(response.getPersonLastName(), "lastName");
    }

    @Test
    void shouldReturnResponseWithCorrectAgreementDateFrom() throws ParseException {
        Date dateFrom = new Date();
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getAgreementDateFrom()).thenReturn(dateFrom);
        when(requestValidator.validate(request)).thenReturn(List.of());
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(response.getAgreementDateFrom(), dateFrom);
    }

    @Test
    void shouldReturnResponseWithCorrectAgreementDateTo() throws ParseException {
        Date dateTo = new Date();
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getAgreementDateTo()).thenReturn(dateTo);
        when(requestValidator.validate(request)).thenReturn(List.of());
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(response.getAgreementDateTo(), dateTo);
    }
    @Test
    void shouldReturnResponseWithCorrectAgreementPrice() throws ParseException {
        Date dateFrom = dates.parse("01.10.2023");
        Date dateTo = dates.parse("05.10.2023");
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getAgreementDateFrom()).thenReturn(dateFrom);
        when(request.getAgreementDateTo()).thenReturn(dateTo);
        when(requestValidator.validate(request)).thenReturn(List.of());
        when(travelPremiumUnderwriting.calculatePremium(request)).thenReturn(new BigDecimal(4L));
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(response.getAgreementPrice(), new BigDecimal(4));
    }
    private List<ValidationError> buildValidationErrorList() {
        return List.of(new ValidationError("field", "errorMessage!"));
    }
}