package lv.javaguru.travel.insurance.core.validations.agreement;

import lv.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.core.api.dto.ValidationErrorDTO;
import lv.javaguru.travel.insurance.core.validations.ValidationErrorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmptySelectedRiskValidation extends TravelAgreementFieldValidationImpl{
    @Autowired
    private ValidationErrorFactory errorFactory;

    public Optional<ValidationErrorDTO> validate(AgreementDTO agreement) {
        return (selectedRiskIsNullOrEmpty(agreement))
                ? Optional.of(errorFactory.buildError("ERROR_CODE_8"))
                : Optional.empty();
    }

    private boolean selectedRiskIsNullOrEmpty(AgreementDTO agreement) {
        return agreement.getSelectedRisks() == null || agreement.getSelectedRisks().isEmpty();
    }
}
