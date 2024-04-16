package lv.javaguru.travel.insurance.core.services;


import lv.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.core.underwriting.TravelPremiumCalculationResult;
import lv.javaguru.travel.insurance.core.underwriting.TravelPremiumUnderwriting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class AgreementPersonsPremiumCalculator {

    @Autowired private TravelPremiumUnderwriting premiumUnderwriting;

    void calculateRiskPremiums(AgreementDTO agreement) {
        agreement.getPersons().forEach(person -> {
            TravelPremiumCalculationResult calculationResult = premiumUnderwriting.calculatePremium(agreement, person);
            person.setRisks(calculationResult.getRisks());
        });
    }

}
