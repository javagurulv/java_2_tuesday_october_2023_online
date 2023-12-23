package lv.javaguru.travel.insurance.core.validations.agreement;

import lv.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.core.api.dto.ValidationErrorDTO;
import lv.javaguru.travel.insurance.core.repositories.ClassifierValueRepository;
import lv.javaguru.travel.insurance.core.validations.ValidationErrorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class MedicalRiskLimitLevelValidation extends TravelAgreementFieldValidationImpl {

    @Autowired
    private ClassifierValueRepository classifierValueRepository;

    @Autowired
    private ValidationErrorFactory errorFactory;

    @Override
    public Optional<ValidationErrorDTO> validate(AgreementDTO request) {
        return ( isMedicalRiskLimitLevelNotBlank(request))
                && !existInDatabase(request.getMedicalRiskLimitLevel())
                ? Optional.of(errorFactory.buildError("ERROR_CODE_14"))
                : Optional.empty();
    }

        private boolean isMedicalRiskLimitLevelNotBlank(AgreementDTO request) {
        return request.getMedicalRiskLimitLevel() != null && !request.getMedicalRiskLimitLevel().isBlank();
    }

    private boolean existInDatabase(String medicalRiscLimitLevelIc) {
        return classifierValueRepository
                .findByClassifierTitleAndIc("MEDICAL_RISK_LIMIT_LEVEL", medicalRiscLimitLevelIc).isPresent();
    }

}
