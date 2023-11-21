package lv.javaguru.travel.insurance.core.services;

import lv.javaguru.travel.insurance.core.services.TravelCalculatePremiumServiceImpl;
import lv.javaguru.travel.insurance.core.underwriting.TravelPremiumUnderwriting;
import lv.javaguru.travel.insurance.core.validations.TravelCalculatePremiumRequestValidator;
import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumResponse;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TravelCalculatePremiumServiceImplTest {

    @Mock private TravelCalculatePremiumRequestValidator requestValidator;

    @Mock private TravelPremiumUnderwriting premiumUnderwriting;
    @InjectMocks
    private TravelCalculatePremiumServiceImpl service;

    @Test
    public void shouldReturnResponseWithErrors() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        List<ValidationError> errors = buildValidationErrorList();
        when(requestValidator.validate(request)).thenReturn(errors);
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertTrue(response.hasErrors());
    }

    @Test
    public void shouldReturnResponseWithValidationErrors() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        List<ValidationError> errors = buildValidationErrorList();
        when(requestValidator.validate(request)).thenReturn(errors);
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "errorCode");
        assertEquals(response.getErrors().get(0).getDescription(), "error description");
    }

    @Test
    public void shouldNotInvokeDateTimeUtilWhenValidationErrors() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        List<ValidationError> errors = buildValidationErrorList();
        when(requestValidator.validate(request)).thenReturn(errors);
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "errorCode");
        assertEquals(response.getErrors().get(0).getDescription(), "error description");
    }

    @Test
    public void shouldReturnResponseWithCorrectPersonFirstName() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("John");
        when(requestValidator.validate(request)).thenReturn(List.of());
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        String result = response.getPersonFirstName();
        assertEquals(result, "John");
    }

    @Test
    public void shouldReturnResponseWithCorrectPersonLastName() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonLastName()).thenReturn("Smith");
        when(requestValidator.validate(request)).thenReturn(List.of());
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        String result = response.getPersonLastName();
        assertEquals(result, "Smith");
    }

    @Test
    public void shouldReturnResponseWithCorrectAgreementDateFrom() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getAgreementDateFrom()).thenReturn(createDate("05.01.2024"));
        when(requestValidator.validate(request)).thenReturn(List.of());
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        Date result = response.getAgreementDateFrom();
        assertEquals(result, createDate("05.01.2024"));
    }

    @Test
    public void shouldReturnResponseWithCorrectAgreementDateTo() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getAgreementDateTo()).thenReturn(createDate("15.01.2024"));
        when(requestValidator.validate(request)).thenReturn(List.of());
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        Date result = response.getAgreementDateTo();
        assertEquals(result, (createDate("15.01.2024")));
    }
    @Test
    public void shouldReturnResponseWithCorrectAgreementPrice() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getAgreementDateFrom()).thenReturn(createDate("05.01.2024"));
        when(request.getAgreementDateTo()).thenReturn(createDate("15.01.2024"));
        when(requestValidator.validate(request)).thenReturn(List.of());
        when(premiumUnderwriting.calculatePremium(request)).thenReturn(new BigDecimal(10));
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        BigDecimal result = response.getAgreementPrice();
        assertEquals(result, new BigDecimal(10));
    }

    private List<ValidationError> buildValidationErrorList() {
        return List.of(
                new ValidationError("errorCode", "error description")
        );
    }

    private Date createDate(String dateStr) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}