package lv.javaguru.travel.insurance.core.validations;

import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.dto.ValidationError;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class EmptySelectedRiskValidation implements TravelRequestValidation {

   public Optional<ValidationError> execute(TravelCalculatePremiumRequest request) {
        return (request.getSelectedRisks()==null || request.getSelectedRisks().isEmpty())
                ? Optional.of(new ValidationError("selectedRisk", "Must not be empty!"))
                : Optional.empty();
    }
}
