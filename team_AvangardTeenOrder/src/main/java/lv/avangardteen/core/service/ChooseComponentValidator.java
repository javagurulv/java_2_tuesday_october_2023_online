package lv.avangardteen.core.service;

import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.responce.CoreError;


import java.util.*;

public class ChooseComponentValidator {
    public List<CoreError> validate(ChangeComponentRequest request) {
    List<CoreError> errors = new ArrayList<>();

    validateMarkingBackWheel(request).ifPresent(errors::add);
    validateMarkingFrontWheel(request).ifPresent(errors::add);
    validateMarkingBrake(request).ifPresent(errors::add);
    validateMarkingArmrest(request).ifPresent(errors::add);

        return errors;
}

    private Optional<CoreError> validateMarkingBackWheel(ChangeComponentRequest request) {
        return (request.getWheelBackChoose() == 0)
                ? Optional.of(new CoreError("indexBackWheel", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateMarkingFrontWheel(ChangeComponentRequest request) {
        return (request.getWheelFrontChoose() == 0)
                ? Optional.of(new CoreError("indexFrontWheel", "Must not be empty!"))
                : Optional.empty();
    }


    private Optional<CoreError> validateMarkingBrake(ChangeComponentRequest request) {
        return (request.getBrakeChoose() == 0)
                ? Optional.of(new CoreError("indexBrake", "Must not be empty!"))
                : Optional.empty();
    }


    private Optional<CoreError> validateMarkingArmrest(ChangeComponentRequest request) {
        return (request.getArmrestChoose() == 0)
                ? Optional.of(new CoreError("indexArmrest", "Must not be empty!"))
                : Optional.empty();
    }

}
