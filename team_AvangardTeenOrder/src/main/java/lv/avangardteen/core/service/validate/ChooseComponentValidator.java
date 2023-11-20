package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.dependency_injection.DIComponent;
import lv.avangardteen.dependency_injection.DIDependency;

import java.util.*;

@DIComponent
public class ChooseComponentValidator {

    @DIDependency
    private ClientIdValidator idValidator;

    @DIDependency
    private ComponentValidator componentValidator;

    public List<CoreError> validate(ChangeComponentRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateIdClient(request, errors);
        validateComponent(request, errors);

        return errors;
    }

    private void validateIdClient(ChangeComponentRequest request, List<CoreError> errors) {
        errors.addAll(idValidator.validate(request.getId()));
    }

    private void validateComponent(ChangeComponentRequest request, List<CoreError> errors) {
        errors.addAll(componentValidator
                .validate(request.getWheelchairComponent()));

    }
}
