package lv.javaguru.travel.insurance.dto;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TravelCalculatePremiumRequestValidator {
    public List<ValidationError> validate(TravelCalculatePremiumRequest request) {
        List<ValidationError> errors = new ArrayList<>();
        validatePersonFirstName(request).ifPresent(errors::add);
        return errors;
    }
    private Optional<ValidationError> validatePersonFirstName(TravelCalculatePremiumRequest request) {
        return (request.getPersonFirstName()==null || request.getPersonLastName().isEpty())
                ? Optional.of(new ValidationError("personFirstName", "Must not be empty"))
                : Optional.empty();
    }
}
