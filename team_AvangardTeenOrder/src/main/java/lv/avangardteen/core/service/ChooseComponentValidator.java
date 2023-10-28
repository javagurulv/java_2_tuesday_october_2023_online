package lv.avangardteen.core.service;

import lv.avangardteen.Category;
import lv.avangardteen.Component;
import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.DataComponents;

import java.util.*;

public class ChooseComponentValidator {
    DataComponents dataComponents = new DataComponents();

    public List<CoreError> validate(ChangeComponentRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateMarkingBackWheel(request).ifPresent(errors::add);
        validateNotMarkingBackWheel(request).ifPresent(errors::add);
        validateMarkingFrontWheel(request).ifPresent(errors::add);
        validateNotMarkingFrontWheel(request).ifPresent(errors::add);
        validateMarkingBrake(request).ifPresent(errors::add);
        validateNotMarkingBrake(request).ifPresent(errors::add);
        validateMarkingArmrest(request).ifPresent(errors::add);
        validateNotMarkingArmrest(request).ifPresent(errors::add);
        validateMapComponent(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateMarkingBackWheel(ChangeComponentRequest request) {
        return (request.getWheelBackChoose() == 0)
                ? Optional.of(new CoreError("markingWheel", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateNotMarkingBackWheel(ChangeComponentRequest request) {
        List<Integer> index = dataComponents.getAllIndex();
        int wheelIndex = 0;
        for (Integer indexBackWheel : index) {
            if (indexBackWheel == request.getWheelBackChoose()) {
                wheelIndex += indexBackWheel;
            }
        }
        return (request.getWheelBackChoose() != wheelIndex)
                ? Optional.of(new CoreError("markingWheel", "There is no component with this marking!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateMarkingFrontWheel(ChangeComponentRequest request) {
        return (request.getWheelFrontChoose() == 0)
                ? Optional.of(new CoreError("markingWheel", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateNotMarkingFrontWheel(ChangeComponentRequest request) {
        List<Integer> index = dataComponents.getAllIndex();
        int  wheelIndex = 0;
        for (int indexFrontWheel : index) {
            if (indexFrontWheel == (request.getWheelFrontChoose())) {
                wheelIndex += indexFrontWheel;
            }
        }
        return (request.getWheelBackChoose() != wheelIndex)
                ? Optional.of(new CoreError("markingWheel", "There is no component with this marking!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateMarkingBrake(ChangeComponentRequest request) {
        return (request.getBrakeChoose() == 0)
                ? Optional.of(new CoreError("markingBrake", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateNotMarkingBrake(ChangeComponentRequest request) {
        List<Integer> index = dataComponents.getAllIndex();
        int brakeIndex = 0;
        for (int indexBrake : index) {
            if (indexBrake == request.getBrakeChoose()) {
                brakeIndex += indexBrake;
            }
        }
        return (request.getBrakeChoose() != brakeIndex)
                ? Optional.of(new CoreError("markingBrake", "There is no component with this marking!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateMarkingArmrest(ChangeComponentRequest request) {
        return (request.getArmrestChoose() == 0)
                ? Optional.of(new CoreError("markingArmrest", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateNotMarkingArmrest(ChangeComponentRequest request) {
        List<Integer> index = dataComponents.getAllIndex();
        int indexArmrest = 0;
        for (int armrestIndex : index) {
            if (armrestIndex == request.getArmrestChoose()) {
                indexArmrest += armrestIndex;
            }
        }
        return (request.getArmrestChoose() != indexArmrest)
                ? Optional.of(new CoreError("markingArmrest", "There is no component with this marking!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateMapComponent(ChangeComponentRequest request) {
        Component component = dataComponents.getComponent(request.getWheelBackChoose());
        Component component1 = dataComponents.getComponent(request.getWheelFrontChoose());
        Component component2 = dataComponents.getComponent(request.getBrakeChoose());
        Component component3 = dataComponents.getComponent(request.getArmrestChoose());
        Map<Category, Component> componentMap = new HashMap<>();
        componentMap.put(component.getCategory(), component);
        componentMap.put(component1.getCategory(), component1);
        componentMap.put(component2.getCategory(), component2);
        componentMap.put(component3.getCategory(), component3);
        return (componentMap.size() < 4)
                ? Optional.of(new CoreError("KeyMap", "All components must be selected!"))
                : Optional.empty();

    }
}
