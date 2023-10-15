package lv.javaguru.travel.insurance.core;

import lv.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.springframework.stereotype.Component;

@Component
class TravelCalculatePremiumServiceImpl implements TravelCalculatePremiumService {
TravelCalculatePremiumResponse response = new TravelCalculatePremiumResponse();

    @Override
    public TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request) {
        response.setPersonFirstName(request.getPersonFirstName());
        response.setPersonLastName(request.getPersonLastName());
        response.setAgreementDateTo(request.getAgreementDateTo());
        response.setAgreementDateFrom(request.getAgreementDateFrom());

        var betweenDate = new DateTimeService().returnBetweenDate(response.getAgreementDateFrom(), response.getAgreementDateTo());
        return response;

    }

}
