package lv.avangardteen.core.service;

import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.DataComponents;
import lv.avangardteen.data.Database;


import java.util.*;

public class ChooseComponentValidator {

    private Database database;
    private DataComponents dataComponents;

    public ChooseComponentValidator(Database database, DataComponents dataComponents) {
        this.database = database;
        this.dataComponents = dataComponents;
    }

    public List<CoreError> validate(ChangeComponentRequest request) {
        List<CoreError> errors = new ArrayList<>();
        clientNotFound(request).ifPresent(errors::add);
        indexFrontWheelIsAbsent(request).ifPresent(errors::add);
        indexBackWheelIsAbsent(request).ifPresent(errors::add);
        indexBrakeIsAbsent(request).ifPresent(errors::add);
        indexArmrestIsAbsent(request).ifPresent(errors::add);

        return errors;
    }

    public Optional<CoreError> clientNotFound(ChangeComponentRequest request) {
        return (database.getClient(request.getId()) == null)
                ? Optional.of(new CoreError("idClient", "Order with this id not found!"))
                : Optional.empty();

    }

    private Optional<CoreError> indexFrontWheelIsAbsent(ChangeComponentRequest request) {
        List<Integer> allIndex = dataComponents.getAllIndex();
        int indexFrontWheel = 1000;
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
