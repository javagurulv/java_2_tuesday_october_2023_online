package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.request.ChangePersonalDateRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.dependency_injection.DIComponent;
import lv.avangardteen.dependency_injection.DIDependency;

import java.util.ArrayList;
import java.util.List;

@DIComponent
public class ChangePersonalDateValidator {

    @DIDependency
    private ClientIdValidator clientIdValidator;
    @DIDependency
    private PersonalDateValidation personalDateValidation;

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


