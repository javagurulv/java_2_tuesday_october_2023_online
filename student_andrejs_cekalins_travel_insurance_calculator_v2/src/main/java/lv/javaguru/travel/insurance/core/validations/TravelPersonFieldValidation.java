package lv.javaguru.travel.insurance.core.validations;

import lv.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.core.api.dto.PersonDTO;
import lv.javaguru.travel.insurance.core.api.dto.ValidationErrorDTO;

import java.util.List;
import java.util.Optional;

public interface TravelPersonFieldValidation {
    Optional<ValidationErrorDTO> validate(PersonDTO request);

    List<ValidationErrorDTO> validateList(PersonDTO request);
}
