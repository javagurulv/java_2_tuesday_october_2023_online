package lv.javaguru.travel.insurance.core.underwriting.calculators;

import lv.javaguru.travel.insurance.core.underwriting.TravelRiskPremiumCalculator;
import lv.javaguru.travel.insurance.dto.v1.TravelCalculatePremiumRequestV1;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class TravelSportActivitiesRiskPremiumCalculator implements TravelRiskPremiumCalculator {
    @Override
    public BigDecimal calculatePremium(TravelCalculatePremiumRequestV1 request) {
        return BigDecimal.ZERO;
    }

    @Override
    public String getRiskIc() {
        return "TRAVEL_SPORT_ACTIVITIES";
    }
}
