package lv.javaguru.travel.insurance.core.validations;

import lv.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.core.api.dto.ValidationErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Component
public class TravelAgreementValidatorImpl implements TravelAgreementValidator {
    private final TravelAgreementFieldValidator agreementFieldValidator;
    private final TravelPersonFieldValidator personFieldValidator;

    TravelAgreementValidatorImpl(TravelAgreementFieldValidator agreementFieldValidator,
                                        TravelPersonFieldValidator personFieldValidator) {
        this.agreementFieldValidator = agreementFieldValidator;
        this.personFieldValidator = personFieldValidator;
    }

    @Override
    public List<ValidationErrorDTO> validate(AgreementDTO agreement) {
        List<ValidationErrorDTO> agreementErrors = agreementFieldValidator.validate(agreement);
        List<ValidationErrorDTO> personalErrors =personFieldValidator.validate(agreement);
        return concatenateLists(agreementErrors, personalErrors);
    }

    private List<ValidationErrorDTO> concatenateLists(List<ValidationErrorDTO> singleErrors,
                                                   List<ValidationErrorDTO> listErrors) {
        return Stream.concat(singleErrors.stream(), listErrors.stream())
                .collect(Collectors.toList());
    }
}
