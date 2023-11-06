package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.CoreError;

import java.util.List;

public class ShowOrderValidator {

    private ClientIdValidator idValidator;

    public ShowOrderValidator(ClientIdValidator idValidator) {
        this.idValidator = idValidator;
    }

    public List<CoreError> validate(ShowOrderRequest request) {
        List<CoreError> errors = idValidator.validate(request.getId());
        return errors;
    }

}
