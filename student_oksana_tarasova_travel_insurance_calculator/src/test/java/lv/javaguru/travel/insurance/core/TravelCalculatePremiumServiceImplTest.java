package lv.javaguru.travel.insurance.core;

import lv.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TravelCalculatePremiumServiceImplTest {

    TravelCalculatePremiumServiceImpl serviceImpl = new TravelCalculatePremiumServiceImpl();
    TravelCalculatePremiumResponse response = new TravelCalculatePremiumResponse();


    @BeforeEach
    public void setUpRequest() throws ParseException {
        Date dateFrom = new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2000");
        Date dateTo = new SimpleDateFormat("dd/MM/yyyy").parse("16/05/2000");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                "Ivan", "Ivanov", dateFrom,
                dateTo);
        response = serviceImpl.calculatePremium(request);
    }


    @Test
    public void getFirstNameResponse() {

        String firstNameActual = response.getPersonFirstName();
        assertEquals("Ivan", firstNameActual);
    }

    @Test
    public void getLastNameResponse() {

        String lastNameActual = response.getPersonLastName();
        assertEquals("Ivanov", lastNameActual);
    }

    @Test
    public void getDateFrom() throws ParseException {

        Date dateFrom1 = response.getAgreementDateFrom();
        assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2000"), dateFrom1);
    }

    @Test
    public void getDateTo() throws ParseException {

        Date dateTo1 = response.getAgreementDateTo();
        assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("16/05/2000"), dateTo1);
    }

    @Test
    public void getAgreementPrice() {
        response.setAgreementPrice();
        BigDecimal agreementPrice = response.getAgreementPrice();
        assertEquals(new BigDecimal(15), agreementPrice);
    }

}