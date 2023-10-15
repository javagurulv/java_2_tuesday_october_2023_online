package lv.javaguru.travel.insurance.core;

import lv.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import static org.junit.jupiter.api.Assertions.*;

class TravelCalculatePremiumServiceImplTest {
    String pattern = "MM-dd-yyyy";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);


    private TravelCalculatePremiumServiceImpl service = new TravelCalculatePremiumServiceImpl();
    private TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("John", "Smith", simpleDateFormat.parse("01-05-2024"), simpleDateFormat.parse("01-15-2024"));
    private TravelCalculatePremiumResponse response = new TravelCalculatePremiumResponse();

    TravelCalculatePremiumServiceImplTest() throws ParseException {
    }

    @Test
    public void testCalculatePremium() throws ParseException {
        response = service.calculatePremium(request);
        String resultPersonFirstName = request.getPersonFirstName();
        String resultPersonLastName = request.getPersonLastName();
        Date resultAgreementDateFrom = request.getAgreementDateFrom();
        Date resultAgreementDateTo = request.getAgreementDateTo();

        assertEquals(resultPersonFirstName, "John");
        assertEquals(resultPersonLastName, "Smith");
        assertEquals(resultAgreementDateFrom, simpleDateFormat.parse("01-05-2024"));
        assertEquals(resultAgreementDateTo, simpleDateFormat.parse("01-15-2024"));
    }

    @Test
    public void testPersonFirstName() {
        response = service.calculatePremium(request);
        String result = request.getPersonFirstName();
        assertEquals(result, "John");
    }

    @Test
    public void testPersonLastName() {
        response = service.calculatePremium(request);
        String result = response.getPersonLastName();
        assertEquals(result, "Smith");
    }

    @Test
    public void testAgreementDateFrom() throws ParseException {
        response = service.calculatePremium(request);
        Date result = response.getAgreementDateFrom();
        assertEquals(result, simpleDateFormat.parse("01-05-2024"));
    }

    @Test
    public void testAgreementDateTo() throws ParseException {
        response = service.calculatePremium(request);
        Date result = response.getAgreementDateTo();
        assertEquals(result, simpleDateFormat.parse("01-15-2024"));
    }
}
