package lv.javaguru.travel.insurance.core;

import com.fasterxml.jackson.annotation.JsonFormat;
import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumResponse;
import lv.javaguru.travel.insurance.dto.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
class TravelCalculatePremiumServiceImpl implements TravelCalculatePremiumService {

    @Autowired private TravelCalculatePremiumRequestValidator requestValidator;
    @Autowired private DateTimeService dateTimeService;
    @Autowired private TravelPremiumUnderwriting travelPremiumUnderwriting;

    @Override
    public TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request) {
        List<ValidationError> errors = requestValidator.validate(request);
        return errors.isEmpty()
                ? buildResponse(request, travelPremiumUnderwriting.calculatePremium(request))
                : buildResponse(errors);
    }
    private TravelCalculatePremiumResponse buildResponse (List<ValidationError> errors) {
        return new TravelCalculatePremiumResponse(errors);
    }

    private TravelCalculatePremiumResponse buildResponse (TravelCalculatePremiumRequest request, BigDecimal premiumPrice) {
        TravelCalculatePremiumResponse response = new TravelCalculatePremiumResponse();
        response.setPersonFirstName(request.getPersonFirstName());
        response.setPersonLastName(request.getPersonLastName());
        response.setAgreementDateFrom(request.getAgreementDateFrom());
        response.setAgreementDateTo(request.getAgreementDateTo());
        response.setAgreementPrice(premiumPrice);
        return response;
    }

}
