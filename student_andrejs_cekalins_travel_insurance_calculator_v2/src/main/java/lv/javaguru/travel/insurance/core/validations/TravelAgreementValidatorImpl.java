package lv.javaguru.travel.insurance.core.validations;

import lv.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.core.api.dto.PersonDTO;
import lv.javaguru.travel.insurance.core.api.dto.ValidationErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Component
public class TravelAgreementValidatorImpl implements TravelAgreementValidator {
    @Autowired
    private List<TravelAgreementFieldValidation> agreementFieldValidations;
    @Autowired
    private List<TravelPersonFieldValidation> personFieldValidations;

    @Override
    public List<ValidationErrorDTO> validate(AgreementDTO agreement) {
        List<ValidationErrorDTO> agreementErrors = collectAgreementErrors(agreement);
        List<ValidationErrorDTO> personalErrors =
                agreement.getPersons().stream()
                        .map(this::collectPersonErrors)
                        .flatMap(List::stream)
                        .collect(Collectors.toList());;
        return concatenateLists(agreementErrors, personalErrors);
    }

    private List<ValidationErrorDTO> collectAgreementErrors(AgreementDTO request) {
        List<ValidationErrorDTO> singleErrors = collectSingleAgreementErrors(request);
        List<ValidationErrorDTO> listErrors = collectListAgreementErrors(request);
        return concatenateLists(singleErrors, listErrors);
    }

    private List<ValidationErrorDTO> collectPersonErrors(PersonDTO request) {
        List<ValidationErrorDTO> singleErrors = collectSinglePersonErrors(request);
        List<ValidationErrorDTO> listErrors = collectListPersonErrors(request);
        return concatenateLists(singleErrors, listErrors);
    }

    private List<ValidationErrorDTO> collectSingleAgreementErrors(AgreementDTO request) {
        return agreementFieldValidations.stream()
                .map(validation -> validation.validate(request))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private List<ValidationErrorDTO> collectListAgreementErrors(AgreementDTO request) {
        return agreementFieldValidations.stream()
                .map(validation -> validation.validateList(request))
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
    private List<ValidationErrorDTO> collectSinglePersonErrors(PersonDTO request) {
        return personFieldValidations.stream()
                .map(validation -> validation.validate(request))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private List<ValidationErrorDTO> collectListPersonErrors(PersonDTO request) {
        return personFieldValidations.stream()
                .map(validation -> validation.validateList(request))
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private List<ValidationErrorDTO> concatenateLists(List<ValidationErrorDTO> singleErrors,
                                                   List<ValidationErrorDTO> listErrors) {
        return Stream.concat(singleErrors.stream(), listErrors.stream())
                .collect(Collectors.toList());
    }
}
