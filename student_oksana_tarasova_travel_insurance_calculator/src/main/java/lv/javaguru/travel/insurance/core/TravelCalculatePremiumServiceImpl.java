package lv.javaguru.travel.insurance.core;

import lv.javaguru.travel.insurance.dto.CoreResponse;
import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumResponse;
import lv.javaguru.travel.insurance.dto.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
class TravelCalculatePremiumServiceImpl implements TravelCalculatePremiumService {

    @Autowired
    private DateTimeService dateTimeService = new DateTimeService();
    @Autowired
    private TravelCalculatePremiumRequestValidator validator = new TravelCalculatePremiumRequestValidator();


    @Override
    public TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request) {
        List<ValidationError> errors = validator.validate(request);
        return (errors.isEmpty())
                ? getResponse(request)
                : new TravelCalculatePremiumResponse(errors);

    }

    private TravelCalculatePremiumResponse getResponse(TravelCalculatePremiumRequest request) {
        TravelCalculatePremiumResponse response = new TravelCalculatePremiumResponse();

        response.setPersonFirstName(request.getPersonFirstName());
        response.setPersonLastName(request.getPersonLastName());
        response.setAgreementDateFrom(request.getAgreementDateFrom());
        response.setAgreementDateTo(request.getAgreementDateTo());
        response.setAgreementPrice(new BigDecimal(daysBetween(request)));
        return response;
    }


    private long daysBetween(TravelCalculatePremiumRequest request) {
        var daysBetween = dateTimeService.getDaysBetween(request.getAgreementDateFrom(), request.getAgreementDateTo());
        return daysBetween;
    }

}
