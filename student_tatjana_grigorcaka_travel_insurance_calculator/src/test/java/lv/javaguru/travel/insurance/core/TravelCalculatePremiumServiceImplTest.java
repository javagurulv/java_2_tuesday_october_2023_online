package lv.javaguru.travel.insurance.core;

import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TravelCalculatePremiumServiceImplTest {
    String pattern = "MM-dd-yyyy";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    @Mock private DateTimeService dateTimeService;
    @Mock private TravelCalculatePremiumRequestValidator requestValidator;
    @InjectMocks
    private TravelCalculatePremiumServiceImpl service;
    private TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("John", "Smith",
            createDate("05.01.2024"),
            createDate("15.01.2024"));
    private TravelCalculatePremiumResponse response = new TravelCalculatePremiumResponse();

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

    private Date createDate(String dateStr) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
