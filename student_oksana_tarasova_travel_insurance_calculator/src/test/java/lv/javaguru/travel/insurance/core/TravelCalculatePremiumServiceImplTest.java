package lv.javaguru.travel.insurance.core;

import lv.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TravelCalculatePremiumServiceImplTest {

    TravelCalculatePremiumServiceImpl serviceImpl = new TravelCalculatePremiumServiceImpl();
    TravelCalculatePremiumResponse response = new TravelCalculatePremiumResponse();


    @BeforeEach
    public void setUpRequest() {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                "Ivan", "Ivanov", new Date((long) 2023.05 / 01),
                new Date((long) 2023.05 / 16));
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
    public void getDateFrom() {

        Date dateFrom = response.getAgreementDateFrom();
        assertEquals(new Date((long)2023.05 / 01), dateFrom);
    }

    @Test
    public void getDateTo() {

        Date dateTo = response.getAgreementDateTo();
        assertEquals(new Date((long) 2023.05 / 16), dateTo);
    }



}