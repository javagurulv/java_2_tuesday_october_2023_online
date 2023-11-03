package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.DataComponents;
import lv.avangardteen.data.Database;


import java.util.*;

public class ChooseComponentValidator {

    private ClientIdValidator idValidator;
    private DataComponents dataComponents;

    public ChooseComponentValidator(ClientIdValidator idValidator, DataComponents dataComponents) {
        this.idValidator = idValidator;
        this.dataComponents = dataComponents;
    }

    public List<CoreError> validate(ChangeComponentRequest request) {
        List<CoreError> errors = idValidator.validate(request.getId());

        indexFrontWheelIsAbsent(request).ifPresent(errors::add);
        indexBackWheelIsAbsent(request).ifPresent(errors::add);
        indexBrakeIsAbsent(request).ifPresent(errors::add);
        indexArmrestIsAbsent(request).ifPresent(errors::add);

        return errors;
    }

    private Optional<CoreError> indexFrontWheelIsAbsent(ChangeComponentRequest request) {
        List<Integer> allIndex = dataComponents.getAllIndex();
        Integer indexFrontWheel = 1000;
        for (Integer index : allIndex) {
            if (index == request.getWheelFrontChoose()) {
                indexFrontWheel = index;
            }
        }
        return (request.getWheelFrontChoose() != indexFrontWheel)
                ? Optional.of((new CoreError("indexFrontWheel", "This index is absent!")))
                : Optional.empty();


    }

    private Optional<CoreError> indexFrontWheelIsNull(ChangeComponentRequest request) {
        return (request.getWheelFrontChoose() == null || request.getWheelFrontChoose() <=0)
                ? Optional.of(new CoreError("indexFrontWheel", "This index is absent!"))
                : Optional.empty();
    }

    private Optional<CoreError> indexBackWheelIsAbsent(ChangeComponentRequest request) {
        List<Integer> allIndex = dataComponents.getAllIndex();
        int indexFrontWheel = 1000;
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
        int indexFrontWheel = 1000;
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
        int indexFrontWheel = 1000;
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
