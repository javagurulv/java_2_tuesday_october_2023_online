package lv.javaguru.travel.insurance.core.validations.agreement;

import lv.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.core.api.dto.ValidationErrorDTO;
import lv.javaguru.travel.insurance.core.validations.ValidationErrorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmptyMedicalRiskLimitLevelValidation extends TravelAgreementFieldValidationImpl {

    @Value("${medical.risk.limit.level.enabled:false}")
    private Boolean medicalRiskLimitLevelEnabled;

    @Autowired
    private ValidationErrorFactory errorFactory;

    @Override
    public Optional<ValidationErrorDTO> validate(AgreementDTO request) {
        return (isMedicalRiskLimitLevelEnabled()
                && containsTravelMedical(request)
                && isMedicalRiskLimitLevelIsNullOrBlank(request))
                ? Optional.of(errorFactory.buildError("ERROR_CODE_13"))
                : Optional.empty();
    }

    private boolean isMedicalRiskLimitLevelEnabled() {
        return medicalRiskLimitLevelEnabled;
    }

    private boolean containsTravelMedical(AgreementDTO request) {
        return request.getSelectedRisks() != null
                && request.getSelectedRisks().contains("TRAVEL_MEDICAL");
    }

    private boolean isMedicalRiskLimitLevelIsNullOrBlank(AgreementDTO request) {
        return request.getMedicalRiskLimitLevel() == null
                || request.getMedicalRiskLimitLevel().isBlank();
    }
}
