package lv.javaguru.travel.insurance.core.validations;

import liquibase.pro.packaged.A;
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
public class TravelPersonFieldValidator {

    @Autowired
    List<TravelPersonFieldValidation> personFieldValidations;

    public List<ValidationErrorDTO> validate(List<PersonDTO> persons) {
        return persons.stream()
                .map(this::collectPersonErrors)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private List<ValidationErrorDTO> collectPersonErrors(PersonDTO request) {
        List<ValidationErrorDTO> singleErrors = collectSinglePersonErrors(request);
        List<ValidationErrorDTO> listErrors = collectListPersonErrors(request);
        return concatenateLists(singleErrors, listErrors);
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
