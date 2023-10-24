package lv.avangardteen.core.service;

import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.DataComponents;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ChooseComponentValidator {
    DataComponents dataComponents = new DataComponents();

    public List<CoreError> validate(ChangeComponentRequest request) {
        List<CoreError> errors = new ArrayList<>();

        //validateMarkingBackWheel(request).ifPresent(errors::add);
        validateNotMarkingBackWheel(request).ifPresent(errors::add);

        //validateMarkingFrontWheel(request).ifPresent(errors::add);
        validateNotMarkingFrontWheel(request).ifPresent(errors::add);

        //validateMarkingBrake(request).ifPresent(errors::add);
       validateNotMarkingBrake(request).ifPresent(errors::add);

       // validateMarkingArmrest(request).ifPresent(errors::add);
        validateNotMarkingArmrest(request).ifPresent(errors::add);
        return errors;
    }

   /* private Optional<CoreError> validateMarkingBackWheel(ChangeComponentRequest request) {
        return (request.getWheelBackChoose() == null || request.getWheelBackChoose().isEmpty())
                ? Optional.of(new CoreError("markingBackWheel", "Must not be empty!"))
                : Optional.empty();
    }*/
    private Optional<CoreError> validateNotMarkingBackWheel(ChangeComponentRequest request) {
        Set<String> marking = dataComponents.getAllBackWheelMarking();
        String wheelMarking = null;
        for (String markWheel : marking) {
            if (markWheel.equals(request.getWheelBackChoose())) {
                wheelMarking = markWheel;
            }
        }
        return (wheelMarking == null)
                ? Optional.of(new CoreError("markingBackWheel", "There is no component with this marking!"))
                : Optional.empty();
    }
   /* private Optional<CoreError> validateMarkingFrontWheel(ChangeComponentRequest request) {
        return (request.getWheelFrontChoose() == null || request.getWheelFrontChoose().isEmpty())
                ? Optional.of(new CoreError("markingFrontWheel", "Must not be empty!"))
                : Optional.empty();
    }*/
    private Optional<CoreError> validateNotMarkingFrontWheel(ChangeComponentRequest request) {
        Set<String> marking = dataComponents.getAllFrontWheelMarking();
        String wheelMarking = null;
        for (String markWheel : marking) {
            if (markWheel.equals(request.getWheelFrontChoose())) {
                wheelMarking += markWheel;
            }
        }
        return (wheelMarking == null)
                ? Optional.of(new CoreError("markingFrontWheel", "There is no component with this marking!"))
                : Optional.empty();
    }

   /* private Optional<CoreError> validateMarkingBrake(ChangeComponentRequest request) {
        return (request.getBrakeChoose() == null || request.getBrakeChoose().isEmpty())
                ? Optional.of(new CoreError("markingBrake", "Must not be empty!"))
                : Optional.empty();
    }*/
    private Optional<CoreError> validateNotMarkingBrake(ChangeComponentRequest request) {
        Set<String> marking = dataComponents.getAllBrakeMarking();
        String wheelMarking = null;
        for (String markWheel : marking) {
            if (markWheel.equals(request.getBrakeChoose())) {
                wheelMarking += markWheel;
            }
        }
        return (wheelMarking == null)
                ? Optional.of(new CoreError("markingBrake", "There is no component with this marking!"))
                : Optional.empty();
    }

   /* private Optional<CoreError> validateMarkingArmrest(ChangeComponentRequest request) {
        return (request.getArmrestChoose() == null || request.getArmrestChoose().isEmpty())
                ? Optional.of(new CoreError("markingArmrest", "Must not be empty!"))
                : Optional.empty();
    }*/
    private Optional<CoreError> validateNotMarkingArmrest(ChangeComponentRequest request) {
        Set<String> marking = dataComponents.getAllArmrestMarking();
        String wheelMarking = null;
        for (String markWheel : marking) {
            if (markWheel.equals(request.getArmrestChoose())) {
                wheelMarking += markWheel;
            }
        }
        return (wheelMarking == null)
                ? Optional.of(new CoreError("markingArmrest", "There is no component with this marking!"))
                : Optional.empty();
    }

}
