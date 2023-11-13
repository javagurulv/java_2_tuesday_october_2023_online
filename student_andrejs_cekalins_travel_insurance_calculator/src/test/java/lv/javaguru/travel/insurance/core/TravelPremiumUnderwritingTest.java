package lv.javaguru.travel.insurance.core;

import lv.javaguru.travel.insurance.core.util.DateTimeUtil;
import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TravelPremiumUnderwritingTest {
    @Mock
    private DateTimeUtil dateTimeService;
    SimpleDateFormat dates = new SimpleDateFormat("dd.MM.yyyy");
    @InjectMocks
    private TravelPremiumUnderwriting travelPremiumUnderwriting;

    @Test
    void shouldReturnResponseWithCorrectAgreementPrice() throws ParseException {
        Date dateFrom = dates.parse("01.10.2023");
        Date dateTo = dates.parse("06.10.2023");
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getAgreementDateFrom()).thenReturn(dateFrom);
        when(request.getAgreementDateTo()).thenReturn(dateTo);
        when(dateTimeService.getDaysBetween(request.getAgreementDateFrom(), request.getAgreementDateTo())).thenReturn(5L);
        BigDecimal premium = travelPremiumUnderwriting.calculatePremium(request);
        assertEquals(premium, new BigDecimal(5));
    }
}