package lv.javaguru.travel.insurance.core.underwriting.calculators.medical;

import lv.javaguru.travel.insurance.core.underwriting.TravelRiskPremiumCalculator;
import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class TravelMedicalRiskPremiumCalculator implements TravelRiskPremiumCalculator {

    @Autowired private DayCountCalculator dayCountCalculator;
    @Autowired private CountryDefaultDayRateCalculator countryDefaultDayRateCalculator;
    @Autowired private AgeCoefficientCalculator ageCoefficientCalculator;
    @Autowired private MedicalRiskLimitLevelCalculator medicalRiskLimitLevelCalculator;

    @Override
    public BigDecimal calculatePremium(TravelCalculatePremiumRequest request) {
        var daysCount = dayCountCalculator.calculate(request);
        var countryDefaultRate = countryDefaultDayRateCalculator.calculate(request);
        var ageCoefficient = ageCoefficientCalculator.calculate(request);
        var limitLevelCalculator = medicalRiskLimitLevelCalculator.calculate(request);
        return countryDefaultRate
                .multiply(daysCount)
                .multiply(ageCoefficient)
                .multiply(limitLevelCalculator)
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String getRiskIc() {
        return "TRAVEL_MEDICAL";
    }

}
