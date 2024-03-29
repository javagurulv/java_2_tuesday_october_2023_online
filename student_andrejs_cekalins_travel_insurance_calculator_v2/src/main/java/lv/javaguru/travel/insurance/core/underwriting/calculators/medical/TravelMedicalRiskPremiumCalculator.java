package lv.javaguru.travel.insurance.core.underwriting.calculators.medical;

import lv.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.core.api.dto.PersonDTO;
import lv.javaguru.travel.insurance.core.underwriting.TravelRiskPremiumCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Component
public class TravelMedicalRiskPremiumCalculator implements TravelRiskPremiumCalculator {
    @Autowired
    private TravelMedicalDayCountCalculator dayCountCalculator;
    @Autowired
    private TravelMedicalCountryDefaultDayRateCalculator countryDefaultDayRateCalculator;
    @Autowired
    private TravelMedicalAgeCoefficientCalculator ageCoefficientCalculator;

    @Autowired
    private TravelMedicalRiskLimitLevelCalculator riskLimitLevelCalculator;

    @Override
    public BigDecimal calculatePremium(AgreementDTO agreement, PersonDTO person) {
        var daysCount = dayCountCalculator.calculate(agreement);
        var countryDefaultRate = countryDefaultDayRateCalculator.calculate(agreement);
        var ageCoefficient = ageCoefficientCalculator.calculate(person);
        var riskLimitLevel = riskLimitLevelCalculator.calculate(person);
        return countryDefaultRate
                .multiply(daysCount)
                .multiply(ageCoefficient)
                .multiply(riskLimitLevel)
                .setScale(2, RoundingMode.HALF_UP);
    }


    @Override
    public String getRiskIc() {
        return "TRAVEL_MEDICAL";
    }
}
