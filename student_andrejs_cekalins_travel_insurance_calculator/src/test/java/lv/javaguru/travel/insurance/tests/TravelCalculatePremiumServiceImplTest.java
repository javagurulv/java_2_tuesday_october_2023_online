package lv.javaguru.travel.insurance.tests;

import lv.javaguru.travel.insurance.core.TravelCalculatePremiumServiceImpl;
import lv.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;

class TravelCalculatePremiumServiceImplTest {
    private TravelCalculatePremiumRequest request;
    @BeforeEach
    void setUp() {
        Date dateFrom = new Date(2023, Calendar.NOVEMBER, 15);
        Date dateTo = new Date(2023, Calendar.NOVEMBER, 31);
        request = new TravelCalculatePremiumRequest("Dmitrijs", "Ivanovs", dateFrom, dateTo);
    }

    @Test
    void calculatePremiumResponseNotNullOk() {
        Assertions.assertNotNull(new TravelCalculatePremiumServiceImpl().calculatePremium(request));
    }
    @Test
    void calculatePremiumResponseNotNullFalse() {
        Assertions.assertNotNull(new TravelCalculatePremiumServiceImpl().calculatePremium(request));
    }
    @Test
    void calculatePremiumResponseGetFirsTNameOk() {
        Assertions.assertEquals("Dmitrijs", new TravelCalculatePremiumServiceImpl().calculatePremium(request).getPersonFirstName());
    }
    @Test
    void calculatePremiumResponseGetFirsTNameFalse() {
        Assertions.assertNotEquals("Andrejs", new TravelCalculatePremiumServiceImpl().calculatePremium(request).getPersonFirstName());
    }
    @Test
    void calculatePremiumResponseGetLastNameOk() {
        Assertions.assertEquals("Ivanovs", new TravelCalculatePremiumServiceImpl().calculatePremium(request).getPersonLastName());
    }
    @Test
    void calculatePremiumResponseGetLastNameFalse() {
        Assertions.assertNotEquals("Petrovs", new TravelCalculatePremiumServiceImpl().calculatePremium(request).getPersonLastName());
    }
    @Test
    void calculatePremiumResponseGetDateFromOk() {
        Date dateFrom = new Date(2023, Calendar.NOVEMBER, 15);
        Assertions.assertEquals(dateFrom, new TravelCalculatePremiumServiceImpl().calculatePremium(request).getAgreementDateFrom());
    }
    @Test
    void calculatePremiumResponseGetDateFromFalse() {
        Date dateFrom = new Date(2023, Calendar.NOVEMBER, 10);
        Assertions.assertNotEquals(dateFrom, new TravelCalculatePremiumServiceImpl().calculatePremium(request).getAgreementDateFrom());
    }
    @Test
    void calculatePremiumResponseGetDateToOk() {
        Date dateTo = new Date(2023, Calendar.NOVEMBER, 31);
        Assertions.assertEquals(dateTo, new TravelCalculatePremiumServiceImpl().calculatePremium(request).getAgreementDateTo());
    }
    @Test
    void calculatePremiumResponseGetDateToFalse() {
        Date dateTo = new Date(2023, Calendar.NOVEMBER, 30);
        Assertions.assertNotEquals(dateTo, new TravelCalculatePremiumServiceImpl().calculatePremium(request).getAgreementDateTo());
    }

}