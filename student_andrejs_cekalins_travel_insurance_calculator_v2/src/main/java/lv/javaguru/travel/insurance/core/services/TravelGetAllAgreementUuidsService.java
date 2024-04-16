package lv.javaguru.travel.insurance.core.services;


import lv.javaguru.travel.insurance.core.api.comamnd.TravelGetAllAgreementUuidsCoreCommand;
import lv.javaguru.travel.insurance.core.api.comamnd.TravelGetAllAgreementUuidsCoreResult;

public interface TravelGetAllAgreementUuidsService {

    TravelGetAllAgreementUuidsCoreResult getAllAgreementUuids(TravelGetAllAgreementUuidsCoreCommand command);

}
