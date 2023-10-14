package lv.javaguru.travel.insurance.core;

import lv.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.springframework.stereotype.Component;

@Component
class TravelCalculatePremiumServiceImpl implements TravelCalculatePremiumService {

    @Override
    public TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request) {
        TravelCalculatePremiumResponse calculatePremiumResponse = new TravelCalculatePremiumResponse();
        calculatePremiumResponse.setPersonFirstName(request.getPersonFirstName());
        calculatePremiumResponse.setPersonLastName(request.getPersonLastName());
        calculatePremiumResponse.setAgreementDateFrom(request.getAgreementDateFrom());
        calculatePremiumResponse.setAgreementDateTo(request.getAgreementDateTo());
        return calculatePremiumResponse;
    }

}
