package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.WheelchairComponent;
import lv.avangardteen.core.domain.Category;
import lv.avangardteen.core.domain.Components;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ComponentValidator {

    public List<CoreError> validate(WheelchairComponent wheelchairComponent) {
        List<CoreError> errors = new ArrayList<>();
        if (indexWheelFrontIsAbsent(wheelchairComponent)) {
            errors.add(new CoreError("indexFrontWheel", "This index is absent!"));
        }
        if (indexBackWheelIsAbsent(wheelchairComponent)) {
            errors.add(new CoreError("indexBackWheel", "This index is absent!"));
        }
        if (indexBrakeIsAbsent(wheelchairComponent)) {
            errors.add(new CoreError("indexBrake", "This index is absent!"));
        }
        if (indexArmrestIsAbsent(wheelchairComponent)) {
            errors.add(new CoreError("indexArmrest", "This index is absent!"));
        }
        return errors;
    }

    private boolean indexWheelFrontIsAbsent(WheelchairComponent wheelchairComponent) {

        Map<Category, Components> componentMap = wheelchairComponent.getComponents();
        Components componentWheelFront = componentMap.get(Category.FRONT_WHEEL);
        if (componentWheelFront != null) {
            return false;
        }
        return true;
    }

    private boolean indexBackWheelIsAbsent(WheelchairComponent wheelchairComponent) {
        Map<Category, Components> componentMap = wheelchairComponent.getComponents();
        Components componentWheelBack = componentMap.get(Category.BACK_WHEEL);
        if (componentWheelBack != null) {
            return false;
        }
        return true;
    }

    private boolean indexBrakeIsAbsent(WheelchairComponent wheelchairComponent) {
        Map<Category, Components> componentMap = wheelchairComponent.getComponents();
        Components componentBrake = componentMap.get(Category.BRAKE);
        if (componentBrake != null) {
            return false;
        }
        return true;
    }

    private boolean indexArmrestIsAbsent(WheelchairComponent wheelchairComponent) {
        Map<Category, Components> componentMap = wheelchairComponent.getComponents();
        Components componentArmrest = componentMap.get(Category.ARMREST);
        if (componentArmrest != null) {
            return false;
        }
        return true;
    }

}
