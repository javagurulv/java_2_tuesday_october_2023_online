package lv.javaguru.travel.insurance.core.underwriting;

import lv.javaguru.travel.insurance.core.util.DateTimeUtil;
import lv.javaguru.travel.insurance.dto.RiskPremium;
import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class UnderwritingPriceTest {

    @Mock private SelectedRisksPremiumCalculator selectedRisksPremiumCalculator;

    @InjectMocks
    private UnderwritingPrice premiumUnderwriting;

    @Test
    void shouldCalculateTotalPremiumAsSumOfRiskPremiums() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        List<RiskPremium> riskPremiums = List.of(
                new RiskPremium("TRAVEL_MEDICAL", BigDecimal.ONE),
                new RiskPremium("TRAVEL_EVACUATION", BigDecimal.ONE)
        );
        when(selectedRisksPremiumCalculator.calculatePremiumForAllRisks(request)).thenReturn(riskPremiums);
        TravelPremiumCalculationResult premiumCalculationResult = premiumUnderwriting.calculatePremium(request);
        assertEquals(premiumCalculationResult.getTotalPremium(), new BigDecimal(2));
    }

}