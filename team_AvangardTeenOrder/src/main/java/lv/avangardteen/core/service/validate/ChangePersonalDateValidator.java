package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.request.ChangePersonalDateRequest;
import lv.avangardteen.core.responce.CoreError;

import java.util.ArrayList;
import java.util.List;


public class ChangePersonalDateValidator {

    private ClientIdValidator clientIdValidator;
    private PersonalDateValidation personalDateValidation;

    public ChangePersonalDateValidator(ClientIdValidator clientIdValidator,
                                       PersonalDateValidation personalDateValidation) {
        this.clientIdValidator = clientIdValidator;
        this.personalDateValidation = personalDateValidation;
    }

    public List<CoreError> validate(ChangePersonalDateRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateIdClient(request, errors);
        validatePersonalDate(request, errors);
        return errors;

    }

    private void validateIdClient(ChangePersonalDateRequest request, List<CoreError> errors) {
        errors.addAll(clientIdValidator.validate(request.getId()));
    }

    private void validatePersonalDate(ChangePersonalDateRequest request, List<CoreError> errors) {
        String surname = request.getNameSurname();
        Integer phone = request.getPhoneNumber();
        String address = request.getUserAddress();
        errors.addAll(personalDateValidation
                .validate(surname, phone, address));

    }
}


