package lv.avangardteen.core.service.validate;

/*

import lv.avangardteen.core.database.DataComponents;
import lv.avangardteen.core.domain.Components;
import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.responce.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ChooseComponentValidator {

    @Autowired
    private DataComponents dataComponents;

    @Autowired
    private OrderIdValidator idValidator;
    @Autowired
    private ComponentValidator validator;

    public List<CoreError> validate(ChangeComponentRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateIdClient(request, errors);
        if (indexWheelFrontIsAbsent(request)) {
            errors.add(new CoreError("indexFrontWheel", "This index is absent!"));
        }
        if (indexBackWheelIsAbsent(request)) {
            errors.add(new CoreError("indexBackWheel", "This index is absent!"));
        }
        if (indexBrakeIsAbsent(request)) {
            errors.add(new CoreError("indexBrake", "This index is absent!"));
        }
        if (indexFootrestIsAbsent(request)) {
            errors.add(new CoreError("indexFootrest", "This index is absent!"));
        }
        return errors;

    }

    private void validateIdClient(ChangeComponentRequest request, List<CoreError> errors) {
        errors.addAll(idValidator.validate(request.getId()));
    }

    private boolean indexWheelFrontIsAbsent(ChangeComponentRequest request) {
        List<Components> componentWheelFront = dataComponents.allFrontWheels();
        for (Components components : componentWheelFront) {
            if (components.getId() == request.getWheelFrontChoose()) {
                return false;
            }
        }
        return true;
    }

    private boolean indexBackWheelIsAbsent(ChangeComponentRequest request) {
        List<Components> componentBackWheel = dataComponents.allBackWheels();
        for (Components components : componentBackWheel) {
            if (components.getId() == request.getWheelBackChoose()) {
                return false;
            }
        }
        return true;
    }

    private boolean indexBrakeIsAbsent(ChangeComponentRequest request) {
        List<Components> componentBrake = dataComponents.allBrakes();
        for (Components components : componentBrake) {
            if (components.getId() == request.getBrakeChoose()) {
                return false;
            }
        }
        return true;
    }

    private boolean indexFootrestIsAbsent(ChangeComponentRequest request) {
        List<Components> componentFootrest = dataComponents.allFootrest();
        for (Components components : componentFootrest) {
            if (components.getId() == request.getFootrestChoose()) {
                return false;
            }
        }
        return true;
    }

}

*/
