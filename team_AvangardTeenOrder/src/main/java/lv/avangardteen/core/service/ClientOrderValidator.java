package lv.avangardteen.core.service;

import lv.avangardteen.Category;
import lv.avangardteen.Component;
import lv.avangardteen.core.request.ClientRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.DataComponents;

import java.util.*;

public class ClientOrderValidator {

    DataComponents dataComponents = new DataComponents();

    public List<CoreError> validate(ClientRequest request) {
        List<CoreError> errors = new ArrayList<>();


        validateNameSurname(request).ifPresent(errors::add);
        validatePhoneNumber(request).ifPresent(errors::add);
        validateUserAddress(request).ifPresent(errors::add);

        validatePelvisWidth(request).ifPresent(errors::add);
        validateShinLength(request).ifPresent(errors::add);
        validateBackHeight(request).ifPresent(errors::add);
        validateThighLength(request).ifPresent(errors::add);

        validateMarkingBackWheel(request).ifPresent(errors::add);
        validateMarkingBackWheel(request).ifPresent(errors::add);
        validateMarkingArmrest(request).ifPresent(errors::add);
        validateMarkingBrake(request).ifPresent(errors::add);

        validateNotMarkingBackWheel(request).ifPresent(errors::add);
        validateNotMarkingFrontWheel(request).ifPresent(errors::add);
        validateNotMarkingArmrest(request).ifPresent(errors::add);
        validateNotMarkingBrake(request).ifPresent(errors::add);

        validateMapComponent(request).ifPresent(errors::add);

        return errors;

    }

    private Optional<CoreError> validateNameSurname(ClientRequest request) {
        return (request.getNameSurname() == null || request.getNameSurname().isEmpty())
                ? Optional.of((new CoreError("nameSurname", "Must not be empty")))
                : Optional.empty();
    }

    private Optional<CoreError> validatePhoneNumber(ClientRequest request) {
        return (request.getPhoneNumber() == null || request.getPhoneNumber().isEmpty())
                ? Optional.of((new CoreError("phoneNumber", "Must not be empty")))
                : Optional.empty();
    }

    private Optional<CoreError> validateUserAddress(ClientRequest request) {
        return (request.getUserAddress() == null || request.getUserAddress().isEmpty())
                ? Optional.of((new CoreError("userAddress", "Must not be empty")))
                : Optional.empty();
    }


    private Optional<CoreError> validatePelvisWidth(ClientRequest request) {
        return (request.getPelvisWidth() <= 0)
                ? Optional.of((new CoreError("pelvisWidth", "Must not be empty")))
                : Optional.empty();
    }

    private Optional<CoreError> validateThighLength(ClientRequest  request) {
        return (request.getThighLength() <= 0)
                ? Optional.of((new CoreError("thighLength", "Must not be empty")))
                : Optional.empty();
    }

    private Optional<CoreError> validateBackHeight(ClientRequest  request) {
        return (request.getBackLength() <= 0)
                ? Optional.of((new CoreError("backHeight", "Must not be empty")))
                : Optional.empty();
    }

    private Optional<CoreError> validateShinLength(ClientRequest request) {
        return (request.getShinLength() <= 0)
                ? Optional.of((new CoreError("shinLength", "Must not be empty")))
                : Optional.empty();
    }

    private Optional<CoreError> validateMarkingBackWheel(ClientRequest request) {
        return (request.getWheelBack() == null || request.getWheelBack().isEmpty())
                ? Optional.of(new CoreError("markingWheelBack", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateNotMarkingBackWheel(ClientRequest request) {
        Set<String> marking = dataComponents.getAllBackWheelMarking();
        String wheelMarking = "";
        for (String markWheel : marking) {
            if (markWheel.equals(request.getWheelBack())) {
                wheelMarking += markWheel;
            }
        }
        return (!request.getWheelBack().equals(wheelMarking))
                ? Optional.of(new CoreError("markingWheelBack", "There is no component with this marking!"))
                : Optional.empty();
    }
    private Optional<CoreError> validateMarkingFrontWheel(ClientRequest request) {
        return (request.getWheelFront() == null || request.getWheelFront().isEmpty())
                ? Optional.of(new CoreError("markingWheelFront", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateNotMarkingFrontWheel(ClientRequest request) {
        Set<String> marking = dataComponents.getAllFrontWheelMarking();
        String wheelMarking = "";
        for (String markWheel : marking) {
            if (markWheel.equals(request.getWheelFront())) {
                wheelMarking += markWheel;
            }
        }
        return (!request.getWheelFront().equals(wheelMarking))
                ? Optional.of(new CoreError("markingWheelFront", "There is no component with this marking!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateMarkingBrake(ClientRequest request) {
        return (request.getBrakeChoose() == null || request.getBrakeChoose().isEmpty())
                ? Optional.of(new CoreError("markingBrake", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateNotMarkingBrake(ClientRequest request) {
        Set<String> marking = dataComponents.getAllBrakeMarking();
        String wheelMarking = "";
        for (String markWheel : marking) {
            if (markWheel.equals(request.getBrakeChoose())) {
                wheelMarking += markWheel;
            }
        }
        return (!request.getBrakeChoose().equals(wheelMarking))
                ? Optional.of(new CoreError("markingBrake", "There is no component with this marking!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateMarkingArmrest(ClientRequest request) {
        return (request.getArmrestChoose() == null || request.getArmrestChoose().isEmpty())
                ? Optional.of(new CoreError("markingArmrest", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateNotMarkingArmrest(ClientRequest request) {
        Set<String> marking = dataComponents.getAllArmrestMarking();
        String wheelMarking = "";
        for (String markWheel : marking) {
            if (markWheel.equals(request.getArmrestChoose())) {
                wheelMarking += markWheel;
            }
        }
        return (!request.getArmrestChoose().equals(wheelMarking))
                ? Optional.of(new CoreError("markingArmrest", "There is no component with this marking!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateMapComponent(ClientRequest request) {
        Component component = dataComponents.getComponent(request.getWheelFront());
        Component component1 = dataComponents.getComponent(request.getWheelBack());
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
