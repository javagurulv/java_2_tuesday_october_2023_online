package lv.javaguru.travel.insurance.core.validations.agreement;

import lv.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.core.api.dto.ValidationErrorDTO;
import lv.javaguru.travel.insurance.core.validations.ValidationErrorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AgreementDateToValidation extends TravelAgreementFieldValidationImpl{
    @Autowired
    private ValidationErrorFactory errorFactory;

    public Optional<ValidationErrorDTO> validate(AgreementDTO request) {
        return (request.getAgreementDateTo() == null)
                ? Optional.of(errorFactory.buildError("ERROR_CODE_6"))
                : Optional.empty();
    }
}
