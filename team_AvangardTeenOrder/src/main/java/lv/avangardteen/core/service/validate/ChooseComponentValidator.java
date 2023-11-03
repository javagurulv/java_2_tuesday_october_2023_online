package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.responce.CoreError;

import java.util.*;

public class ChooseComponentValidator {

    private ClientIdValidator idValidator;

    private ComponentValidator componentValidator;

    public ChooseComponentValidator(ClientIdValidator idValidator, ComponentValidator componentValidator) {
        this.idValidator = idValidator;
        this.componentValidator = componentValidator;
    }

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
                .validate(request.getWheelFrontChoose(),
                        request.getWheelBackChoose(), request.getBrakeChoose(), request.getArmrestChoose()));

    }
}
