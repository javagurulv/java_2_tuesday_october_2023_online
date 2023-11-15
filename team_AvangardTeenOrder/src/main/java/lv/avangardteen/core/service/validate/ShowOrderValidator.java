package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.dependency_injection.DIComponent;
import lv.avangardteen.dependency_injection.DIDependency;

import java.util.List;

@DIComponent
public class ShowOrderValidator {

    @DIDependency
    private ClientIdValidator idValidator;

    public List<CoreError> validate(ShowOrderRequest request) {
        List<CoreError> errors = idValidator.validate(request.getId());
        return errors;
    }

}
