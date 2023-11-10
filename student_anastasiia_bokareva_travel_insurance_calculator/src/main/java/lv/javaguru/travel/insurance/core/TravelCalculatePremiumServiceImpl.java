package lv.javaguru.travel.insurance.core;

import lv.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;


@Component
class TravelCalculatePremiumServiceImpl implements TravelCalculatePremiumService {
    private TimeService service;

    @Override
    public TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request) {
        TravelCalculatePremiumResponse response = new TravelCalculatePremiumResponse();
        response.setPersonFirstName(request.getPersonFirstName());
        response.setPersonLastName(request.getPersonLastName());
        response.setAgreementDateFrom(request.getAgreementDateFrom());
        response.setAgreementDateTo(request.getAgreementDateTo());

        var daysBetween = service.daysBetween(request.getAgreementDateFrom(),request.getAgreementDateTo());
        response.setAgreementPrice(new BigDecimal(daysBetween));
        return response;
    }

}
