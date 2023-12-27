package lv.javaguru.travel.insurance.core.services;

import lv.javaguru.travel.insurance.core.api.comamnd.TravelCalculatePremiumCoreCommand;
import lv.javaguru.travel.insurance.core.api.comamnd.TravelCalculatePremiumCoreResult;

public interface TravelCalculatePremiumService {
    TravelCalculatePremiumCoreResult calculatePremium(TravelCalculatePremiumCoreCommand command);
}
