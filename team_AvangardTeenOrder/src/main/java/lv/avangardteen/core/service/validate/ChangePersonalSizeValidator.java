package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.request.ChangePersonalSizeRequest;
import lv.avangardteen.core.responce.CoreError;

import java.util.ArrayList;
import java.util.List;

public class ChangePersonalSizeValidator {


    private ClientIdValidator idValidator;
    private PersonalSizeValidator sizeValidation;

    public ChangePersonalSizeValidator(ClientIdValidator idValidator,
                                       PersonalSizeValidator sizeValidation) {
        this.idValidator = idValidator;
        this.sizeValidation = sizeValidation;
    }

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

