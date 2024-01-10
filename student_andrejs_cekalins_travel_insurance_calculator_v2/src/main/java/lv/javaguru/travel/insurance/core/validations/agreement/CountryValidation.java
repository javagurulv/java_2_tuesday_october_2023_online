package lv.javaguru.travel.insurance.core.validations.agreement;

import lv.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.core.api.dto.ValidationErrorDTO;
import lv.javaguru.travel.insurance.core.repositories.ClassifierValueRepository;
import lv.javaguru.travel.insurance.core.validations.ValidationErrorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CountryValidation extends TravelAgreementFieldValidationImpl {
    @Autowired
    private ClassifierValueRepository classifierValueRepository;

    @Autowired
    private ValidationErrorFactory errorFactory;

    @Override
    public Optional<ValidationErrorDTO> validate(AgreementDTO agreement) {
        return (containsTravelMedical(agreement)
                && countryIsNotBlank(agreement))
                && !existInDatabase(agreement.getCountry())
                ? Optional.of(errorFactory.buildError("ERROR_CODE_15"))
                : Optional.empty();
    }

    private boolean containsTravelMedical(AgreementDTO request) {
        return request.getSelectedRisk() != null
                && request.getSelectedRisk().contains("TRAVEL_MEDICAL");
    }

    private boolean countryIsNotBlank(AgreementDTO request) {
        return request.getCountry() != null && !request.getCountry().isBlank();
    }

    private boolean existInDatabase(String countryIc) {
        return classifierValueRepository
                .findByClassifierTitleAndIc("COUNTRY", countryIc).isPresent();
    }
}
