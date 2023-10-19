package lv.javaguru.travel.insurance.core;

import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumResponse;
import lv.javaguru.travel.insurance.dto.ValidationError;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TravelCalculatePremiumServiceImplTest {

    TravelCalculatePremiumServiceImpl serviceImpl = new TravelCalculatePremiumServiceImpl();
    TravelCalculatePremiumResponse response = new TravelCalculatePremiumResponse();
    TravelCalculatePremiumRequestValidator validator = new TravelCalculatePremiumRequestValidator();


    @Test
    public void getFirstNameResponse() throws ParseException {
        Date dateFrom = new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2000");
        Date dateTo = new SimpleDateFormat("dd/MM/yyyy").parse("16/05/2000");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                "Ivan", "Ivanov", dateFrom,
                dateTo);
        validator.validate(request);
        response = serviceImpl.calculatePremium(request);
        String firstNameActual = response.getPersonFirstName();
        assertEquals("Ivan", firstNameActual);



    }

    @Test
    public void getLastNameResponse() throws ParseException {
        Date dateFrom = new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2000");
        Date dateTo = new SimpleDateFormat("dd/MM/yyyy").parse("16/05/2000");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                "Ivan", "Ivanov", dateFrom,
                dateTo);
        validator.validate(request);
        response = serviceImpl.calculatePremium(request);

        String lastNameActual = response.getPersonLastName();
        assertEquals("Ivanov", lastNameActual);
    }

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
    public void getErrorFirstName() throws ParseException {
        Date dateFrom = new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2000");
        Date dateTo = new SimpleDateFormat("dd/MM/yyyy").parse("16/05/2000");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                null, "Ivanov", dateFrom,
                dateTo);
        validator.validate(request);
        response = serviceImpl.calculatePremium(request);
        assertThat(response.getErrors()).contains(new ValidationError("personFirstName", "Must not be empty!"));
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



    }

}

