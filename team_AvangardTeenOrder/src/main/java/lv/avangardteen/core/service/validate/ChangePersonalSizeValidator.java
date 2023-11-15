package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.request.ChangePersonalSizeRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.dependency_injection.DIComponent;
import lv.avangardteen.dependency_injection.DIDependency;

import java.util.ArrayList;
import java.util.List;

@DIComponent
public class ChangePersonalSizeValidator {

    @DIDependency
    private ClientIdValidator idValidator;
    @DIDependency
    private PersonalSizeValidator sizeValidation;

    public List<CoreError> validate(ChangePersonalSizeRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateIdClient(request, errors);
        validatePersonSize(request, errors);

        return errors;

    }

    private void validateIdClient(ChangePersonalSizeRequest request, List<CoreError> errors) {
        errors.addAll(idValidator.validate(request.getId()));
    }

    private void validatePersonSize(ChangePersonalSizeRequest request, List<CoreError> errors) {
        errors.addAll(sizeValidation.validate(request.getUserSizes()));
    }

}

