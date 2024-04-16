package lv.javaguru.travel.insurance.core.underwriting.calculators.cancellation;

import lv.javaguru.travel.insurance.core.api.dto.PersonDTO;

import lv.javaguru.travel.insurance.core.domain.TCTravelCostCoefficient;
import lv.javaguru.travel.insurance.core.repositories.TCTravelCostCoefficientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
class TCTravelCostCoefficientCalculator {

    @Autowired private TCTravelCostCoefficientRepository tCTravelCostCoefficientRepository;

    BigDecimal calculate(PersonDTO person) {
        return tCTravelCostCoefficientRepository.findCoefficient(person.getTravelCost())
                .map(TCTravelCostCoefficient::getCoefficient)
                .orElseThrow(() -> new RuntimeException("Travel Cost coefficient not found for travel cost = " + person.getTravelCost()));
    }

}
