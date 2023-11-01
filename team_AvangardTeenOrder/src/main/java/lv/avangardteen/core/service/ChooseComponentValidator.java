package lv.avangardteen.core.service;

import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.request.ChangePersonalDateRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.DataComponents;
import lv.avangardteen.data.DataOrders;


import java.util.*;

public class ChooseComponentValidator {


    DataComponents dataComponents = new DataComponents();

    public List<CoreError> validate(ChangeComponentRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateId(request).ifPresent(errors::add);
        validateMarkingBackWheel(request).ifPresent(errors::add);
        validateMarkingFrontWheel(request).ifPresent(errors::add);
        validateMarkingBrake(request).ifPresent(errors::add);
        validateMarkingArmrest(request).ifPresent(errors::add);
        indexFrontWheelIsAbsent(request).ifPresent(errors::add);
        indexBackWheelIsAbsent(request).ifPresent(errors::add);
        indexBrakeIsAbsent(request).ifPresent(errors::add);
        indexArmrestIsAbsent(request).ifPresent(errors::add);

        return errors;
    }

    private Optional<CoreError> validateId(ChangeComponentRequest request) {
        return (request.getId() <= 0)
                ? Optional.of(new CoreError("idClient", "Must not be zero!"))
                : Optional.empty();
    }



    private Optional<CoreError> validateMarkingBackWheel(ChangeComponentRequest request) {
        return (request.getWheelBackChoose() <= 0)
                ? Optional.of(new CoreError("indexBackWheel", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateMarkingFrontWheel(ChangeComponentRequest request) {
        return (request.getWheelFrontChoose() <= 0)
                ? Optional.of(new CoreError("indexFrontWheel", "Must not be empty!"))
                : Optional.empty();
    }


    private Optional<CoreError> validateMarkingBrake(ChangeComponentRequest request) {
        return (request.getBrakeChoose() == 0)
                ? Optional.of(new CoreError("indexBrake", "Must not be empty!"))
                : Optional.empty();
    }


    private Optional<CoreError> validateMarkingArmrest(ChangeComponentRequest request) {
        return (request.getArmrestChoose() <= 0)
                ? Optional.of(new CoreError("indexArmrest", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> indexFrontWheelIsAbsent(ChangeComponentRequest request) {
        List<Integer> allIndex = dataComponents.getAllIndex();
        int indexFrontWheel = 0;
        for (Integer index : allIndex) {
            if (index == request.getWheelFrontChoose()) {
                indexFrontWheel = index;
            }
        }
        return (request.getWheelFrontChoose() != indexFrontWheel)
                ? Optional.of((new CoreError("indexFrontWheel", "This index is absent!")))
                : Optional.empty();


    }

    private Optional<CoreError> indexBackWheelIsAbsent(ChangeComponentRequest request) {
        List<Integer> allIndex = dataComponents.getAllIndex();
        int indexFrontWheel = 0;
        for (Integer index : allIndex) {
            if (index == request.getWheelBackChoose()) {
                indexFrontWheel = index;
            }
        }
        return (request.getWheelBackChoose() != indexFrontWheel)
                ? Optional.of((new CoreError("indexBackWheel", "This index is absent!")))
                : Optional.empty();


    }

    private Optional<CoreError> indexBrakeIsAbsent(ChangeComponentRequest request) {
        List<Integer> allIndex = dataComponents.getAllIndex();
        int indexFrontWheel = 0;
        for (Integer index : allIndex) {
            if (index == request.getBrakeChoose()) {
                indexFrontWheel = index;
            }
        }
        return (request.getBrakeChoose() != indexFrontWheel)
                ? Optional.of((new CoreError("indexBrake", "This index is absent!")))
                : Optional.empty();


    }

    private Optional<CoreError> indexArmrestIsAbsent(ChangeComponentRequest request) {
        List<Integer> allIndex = dataComponents.getAllIndex();
        int indexFrontWheel = 0;
        for (Integer index : allIndex) {
            if (index == request.getArmrestChoose()) {
                indexFrontWheel = index;
            }
        }
        return (request.getArmrestChoose() != indexFrontWheel)
                ? Optional.of((new CoreError("indexArmrest", "This index is absent!")))
                : Optional.empty();


    }
}
