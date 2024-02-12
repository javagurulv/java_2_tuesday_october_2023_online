package lv.javaguru.travel.insurance.core.services;

import lv.javaguru.travel.insurance.core.api.comamnd.TravelGetAgreementCoreCommand;
import lv.javaguru.travel.insurance.core.api.comamnd.TravelGetAgreementCoreResult;

public interface TravelGetAgreementService {
    TravelGetAgreementCoreResult getAgreement(TravelGetAgreementCoreCommand command);
}
