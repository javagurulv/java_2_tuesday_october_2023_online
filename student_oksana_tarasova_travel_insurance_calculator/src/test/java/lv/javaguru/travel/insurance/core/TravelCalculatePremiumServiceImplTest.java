package lv.javaguru.travel.insurance.core;

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
        assertEquals(response.getErrors().get(0).getField(), "errorsField");
        assertEquals(response.getErrors().get(0).getMessage(), "errorsMessage");

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
        when(underwritingPrice.calculateDaysBetween(request)).thenReturn(new BigDecimal(20));
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(response.getAgreementPrice(), new BigDecimal(20));
    }



    private Date createDate(String dateStr) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

/*


    @Test
    public void getDateFrom() throws ParseException {
        Date dateFrom = new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2000");
        Date dateTo = new SimpleDateFormat("dd/MM/yyyy").parse("16/05/2000");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                "Ivan", "Ivanov", dateFrom,
                dateTo);
        validator.validate(request);
        response = serviceImpl.calculatePremium(request);
        Date dateFrom1 = response.getAgreementDateFrom();
        assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2000"), dateFrom1);
    }

    @Test
    public void getDateTo() throws ParseException {
        Date dateFrom = new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2000");
        Date dateTo = new SimpleDateFormat("dd/MM/yyyy").parse("16/05/2000");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                "Ivan", "Ivanov", dateFrom,
                dateTo);
        validator.validate(request);
        response = serviceImpl.calculatePremium(request);
        Date dateTo1 = response.getAgreementDateTo();
        assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("16/05/2000"), dateTo1);
    }



    @Test
    public void getErrorLastName() throws ParseException {
        Date dateFrom = new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2000");
        Date dateTo = new SimpleDateFormat("dd/MM/yyyy").parse("16/05/2000");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                "Ivan", "", dateFrom,
                dateTo);
        validator.validate(request);
        response = serviceImpl.calculatePremium(request);
        assertThat(response.getErrors()).contains(new ValidationError("personLastName", "Must not be empty!"));
    }

    @Test
    public void getErrorsFirstAndLastName() throws ParseException {
        Date dateFrom = new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2000");
        Date dateTo = new SimpleDateFormat("dd/MM/yyyy").parse("16/05/2000");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                "", "", dateFrom,
                dateTo);
        validator.validate(request);
        response = serviceImpl.calculatePremium(request);
        assertThat(response.getErrors()).hasSize(2);
        assertThat(response.getErrors()).contains(new ValidationError("personFirstName", "Must not be empty!"));
        assertThat(response.getErrors()).contains(new ValidationError("personLastName", "Must not be empty!"));
    }

    @Test
    public void getErrorsFirstAndLastNameAndDateFrom() throws ParseException {
        Date dateFrom = null;
        Date dateTo = new SimpleDateFormat("dd/MM/yyyy").parse("16/05/2000");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                "", "", dateFrom,
                dateTo);
        validator.validate(request);
        response = serviceImpl.calculatePremium(request);
        assertThat(response.getErrors()).hasSize(3);
        assertThat(response.getErrors()).contains(new ValidationError("personFirstName", "Must not be empty!"));
        assertThat(response.getErrors()).contains(new ValidationError("personLastName", "Must not be empty!"));
        assertThat(response.getErrors()).contains(new ValidationError("agreementDateFrom", "Must not be empty!"));
    }
    @Test
    public void getErrorsFirstAndLastNameAndDateFromAndDateTo() throws ParseException {
        Date dateFrom = null;
        Date dateTo = null;
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                "", "", dateFrom,
                dateTo);
        validator.validate(request);
        response = serviceImpl.calculatePremium(request);
        assertThat(response.getErrors()).hasSize(4);
        assertThat(response.getErrors()).contains(new ValidationError("personFirstName", "Must not be empty!"));
        assertThat(response.getErrors()).contains(new ValidationError("personLastName", "Must not be empty!"));
        assertThat(response.getErrors()).contains(new ValidationError("agreementDateFrom", "Must not be empty!"));
        assertThat(response.getErrors()).contains(new ValidationError("agreementDateTo", "Must not be empty!"));
    }

    @Test
    public void getErrorDateFromIsLessDateTo() throws ParseException {
        Date dateFrom = new SimpleDateFormat("dd/MM/yyyy").parse("16/05/2000");
        Date dateTo = new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2000");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                "Ivan", "Ivanov", dateFrom,
                dateTo);
        validator.validate(request);
        response = serviceImpl.calculatePremium(request);
        assertThat(response.getErrors()).hasSize(1);
        assertThat(response.getErrors()).contains(new ValidationError("agreementDateFrom", "Must be less than the agreementDateTo!"));
    }

    @Test

    public void getAgreementPrice() throws ParseException {
        Date dateFrom = new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2000");
        Date dateTo = new SimpleDateFormat("dd/MM/yyyy").parse("16/05/2000");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                "Ivan", "Ivanov", dateFrom,
                dateTo);
        validator.validate(request);
        response = serviceImpl.calculatePremium(request);
        BigDecimal betweenDays = response.getAgreementPrice();
        assertEquals(betweenDays, new BigDecimal(15));



    }*/

}

