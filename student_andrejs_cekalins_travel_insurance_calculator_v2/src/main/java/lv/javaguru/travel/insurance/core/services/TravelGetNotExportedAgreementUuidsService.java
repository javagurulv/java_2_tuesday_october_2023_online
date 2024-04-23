package lv.javaguru.travel.insurance.core.services;


import lv.javaguru.travel.insurance.core.api.comamnd.TravelGetNotExportedAgreementUuidsCoreCommand;
import lv.javaguru.travel.insurance.core.api.comamnd.TravelGetNotExportedAgreementUuidsCoreResult;

public interface TravelGetNotExportedAgreementUuidsService {

    TravelGetNotExportedAgreementUuidsCoreResult getAgreementUuids(TravelGetNotExportedAgreementUuidsCoreCommand command);

}
