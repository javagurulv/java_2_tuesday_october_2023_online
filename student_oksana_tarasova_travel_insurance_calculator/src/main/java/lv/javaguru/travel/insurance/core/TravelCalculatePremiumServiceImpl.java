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
    private DateTimeService dateTimeService;
    @Autowired
    private TravelCalculatePremiumRequestValidator validator;
    @Autowired
    private CoreResponse coreResponse;

    @Override
    public TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request) {
        TravelCalculatePremiumResponse response = new TravelCalculatePremiumResponse();

        response.setAgreementPrice(new BigDecimal(daysBetween(request)));
        response.setPersonFirstName(request.getPersonFirstName());
        response.setPersonLastName(request.getPersonLastName());
        response.setAgreementDateFrom(request.getAgreementDateFrom());
        response.setAgreementDateTo(request.getAgreementDateTo());
        response.setAgreementPrice(new BigDecimal(daysBetween(request)));
        response.setErrors(validateList(request));


        return response;
    }

    private  List<ValidationError> validateList(TravelCalculatePremiumRequest request) {
        List<ValidationError> errors = validator.validate(request);
        coreResponse.setErrors(errors);
        return (coreResponse.hasErrors())
                ? coreResponse.getErrors()
                : new ArrayList<>();
    }

    private long daysBetween (TravelCalculatePremiumRequest request) {
        var daysBetween = dateTimeService.getDaysBetween(request.getAgreementDateFrom(), request.getAgreementDateTo());
        return daysBetween;
    }

}
