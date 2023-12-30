package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.database.DataComponents;
import lv.avangardteen.core.request.ComponentRegistrationRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.domain.Components;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ComponentValidator {

    @Autowired
    private DataComponents dataComponents;

    public List<CoreError> validate(ComponentRegistrationRequest request) {
        List<CoreError> errors = new ArrayList<>();
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

    private boolean indexWheelFrontIsAbsent(ComponentRegistrationRequest request) {
        List<Components> componentWheelFront = dataComponents.allFrontWheels();
        for (Components components : componentWheelFront) {
            if (components.getId() == request.getWheelFrontChoose()) {
                return false;
            }
        }
        return true;
    }

    private boolean indexBackWheelIsAbsent(ComponentRegistrationRequest request) {
        List<Components> componentBackWheel = dataComponents.allBackWheels();
        for (Components components : componentBackWheel) {
            if (components.getId() == request.getWheelBackChoose()) {
                return false;
            }
        }
        return true;
    }

    private boolean indexBrakeIsAbsent(ComponentRegistrationRequest request) {
        List<Components> componentBrake = dataComponents.allBrakes();
        for (Components components : componentBrake) {
            if (components.getId() == request.getBrakeChoose()) {
                return false;
            }
        }
        return true;
    }

    private boolean indexFootrestIsAbsent(ComponentRegistrationRequest request) {
        List<Components> componentFootrest = dataComponents.allFootrest();
        for (Components components : componentFootrest) {
            if (components.getId() == request.getFootrestChoose()) {
                return false;
            }
        }
        return true;
    }

}
