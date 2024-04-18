package lv.javaguru.travel.insurance.core.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lv.javaguru.travel.insurance.core.api.comamnd.TravelGetAllAgreementUuidsCoreCommand;
import lv.javaguru.travel.insurance.core.api.comamnd.TravelGetAllAgreementUuidsCoreResult;
import lv.javaguru.travel.insurance.core.repositories.entities.AgreementEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class TravelGetAllAgreementUuidsServiceImpl
        implements TravelGetAllAgreementUuidsService {

    private final AgreementEntityRepository agreementRepository;


    @Override
    public TravelGetAllAgreementUuidsCoreResult getAllAgreementUuids(TravelGetAllAgreementUuidsCoreCommand command) {
        List<String> agreementUuids = agreementRepository.getAllAgreementUuids();
        return new TravelGetAllAgreementUuidsCoreResult(null, agreementUuids);
    }

}
