package lv.javaguru.travel.insurance.core.underwriting.calculators.cancellation;

import lv.javaguru.travel.insurance.core.api.dto.PersonDTO;

import lv.javaguru.travel.insurance.core.domain.TravelCancellationTravelCostCoefficient;
import lv.javaguru.travel.insurance.core.repositories.TravelCancellationTravelCostCoefficientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
class TravelCostCoefficientCalculator {

    @Autowired private TravelCancellationTravelCostCoefficientRepository TCTravelCostCoefficientRepository;

    BigDecimal calculate(PersonDTO person) {
        return TCTravelCostCoefficientRepository.findCoefficient(person.getTravelCost())
                .map(TravelCancellationTravelCostCoefficient::getCoefficient)
                .orElseThrow(() -> new RuntimeException("Travel Cost coefficient not found for travel cost = " + person.getTravelCost()));
    }

}
