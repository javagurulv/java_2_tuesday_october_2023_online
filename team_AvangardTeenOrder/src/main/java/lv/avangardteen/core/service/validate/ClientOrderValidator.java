package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.request.ClientRequest;
import lv.avangardteen.core.responce.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ClientOrderValidator {
    @Autowired
    private PersonalDateValidation personalDateValidation;
    @Autowired
    private PersonalSizeValidator personalSizeValidator;
    @Autowired
    private ComponentValidator componentValidator;

    public List<CoreError> validate(ClientRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validatePersonalDate(request, errors);
        validatePersonSize(request, errors);
        validateComponent(request, errors);
        return errors;
    }


    private void validatePersonalDate(ClientRequest request, List<CoreError> errors) {
        errors.addAll(personalDateValidation
                .validate(request.getNameSurname(),
                        request.getPhoneNumber(),
                        request.getUserAddress()));

    }

    private void validatePersonSize(ClientRequest request, List<CoreError> errors) {
        errors.addAll(personalSizeValidator.validate(request.getUserSizes()));
    }

    private void validateComponent(ClientRequest request, List<CoreError> errors) {
        errors.addAll(componentValidator
                .validate(request.getWheelchairComponent()));

    }

}
