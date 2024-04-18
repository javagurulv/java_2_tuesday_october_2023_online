package lv.javaguru.travel.insurance.core.services;

import lv.javaguru.travel.insurance.core.api.comamnd.TravelGetAgreementCoreCommand;
import lv.javaguru.travel.insurance.core.api.comamnd.TravelGetAgreementCoreResult;
import lv.javaguru.travel.insurance.core.api.dto.ValidationErrorDTO;
import lv.javaguru.travel.insurance.core.validations.TravelAgreementUuidValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class TravelGetAgreementServiceImpl implements TravelGetAgreementService {

    private final TravelAgreementUuidValidator agreementUuidValidator;
    private final AgreementDTOLoader agreementDTOLoader;

    public TravelGetAgreementServiceImpl(TravelAgreementUuidValidator agreementUuidValidator, AgreementDTOLoader agreementDTOLoader) {
        this.agreementUuidValidator = agreementUuidValidator;
        this.agreementDTOLoader = agreementDTOLoader;
    }

    @Override
    public TravelGetAgreementCoreResult getAgreement(TravelGetAgreementCoreCommand command) {
        List<ValidationErrorDTO> errors = agreementUuidValidator.validate(command.getUuid());
        return errors.isEmpty()
                ? buildResponse(command.getUuid())
                : buildResponse(errors);
    }

    private TravelGetAgreementCoreResult buildResponse(List<ValidationErrorDTO> errors) {
        return new TravelGetAgreementCoreResult(errors);
    }

    private TravelGetAgreementCoreResult buildResponse(String agreementUuid) {
        TravelGetAgreementCoreResult coreResult = new TravelGetAgreementCoreResult();
        coreResult.setAgreement(agreementDTOLoader.load(agreementUuid));
        return coreResult;
    }

}
