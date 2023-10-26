package lv.javaguru.travel.insurance.validations;

import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.dto.ValidationError;

import java.util.Optional;

public interface TravelRequestValidation {
Optional<ValidationError> execute (TravelCalculatePremiumRequest request);
}
