package lv.javaguru.travel.insurance.core;

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


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TravelCalculatePremiumServiceImplTest {

    @Mock
    private TravelCalculatePremiumRequestValidator validator;
    @Mock
    private UnderwritingPrice underwritingPrice;

    @InjectMocks
    private TravelCalculatePremiumServiceImpl service;


    @Test
    public void getErrorsResponse() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        List<ValidationError> errors = List.of(new ValidationError("errorsField", "errorsMessage"));
        when(validator.validate(request)).thenReturn(errors);
       TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertTrue(response.hasErrors());

    }

    @Test
    public void getErrorsResponseEqualsValidatorErrors() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        List<ValidationError> errors = List.of(new ValidationError("errorsField", "errorsMessage"));
        when(validator.validate(request)).thenReturn(errors);
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "errorsField");
        assertEquals(response.getErrors().get(0).getDescription(), "errorsMessage");

    }

    @Test
    public void getResponseWithoutErrorsForFirstName(){
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("Ivan");
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getPersonFirstName(), "Ivan");
    }

    @Test
    public void getResponseWithoutErrorsForLastName(){
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonLastName()).thenReturn("Ivanov");
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getPersonLastName(), "Ivanov");
    }

    @Test
    public void responseWithoutErrorsForDateFrom(){
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        Date dateFrom = new Date();
        when(request.getAgreementDateFrom()).thenReturn(dateFrom);
        when(validator.validate(request)).thenReturn(List.of());
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getAgreementDateFrom(), dateFrom);

    }

    @Test
    public void responseWithoutErrorsForDateTo(){
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        Date dateTo = new Date();
        when(request.getAgreementDateTo()).thenReturn(dateTo);
        when(validator.validate(request)).thenReturn(List.of());
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getAgreementDateTo(), dateTo);

    }

    @Test
    public void agreementPrice() {
        TravelCalculatePremiumRequest request = mock((TravelCalculatePremiumRequest.class));
        when(request.getAgreementDateFrom()).thenReturn(createDate("01.04.2023"));
        when(request.getAgreementDateFrom()).thenReturn(createDate("21.04.2023"));
        when(validator.validate(request)).thenReturn(List.of());
        when(underwritingPrice.calculatePremium(request)).thenReturn(new BigDecimal(20));
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(response.getAgreementPrice(), new BigDecimal(20));
    }

    private List<ValidationError> buildValidationErrorList() {
        return List.of(
                new ValidationError("field", "errorMessage")
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

