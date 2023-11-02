package lv.avangardteen.core.service;

import lv.avangardteen.Category;
import lv.avangardteen.Component;
import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.request.ChangePersonalSizeRequest;
import lv.avangardteen.core.request.ClientRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.DataComponents;
import lv.avangardteen.data.Database;

import java.util.*;

public class ClientOrderValidator {

private Database database;
private DataComponents dataComponents = new DataComponents();

    public ClientOrderValidator(Database database, DataComponents dataComponents) {
        this.database = database;
        this.dataComponents = dataComponents;
    }

    public List<CoreError> validate(ClientRequest request) {
        List<CoreError> errors = new ArrayList<>();

        validateNameSurname(request).ifPresent(errors::add);
        validatePhoneNumber(request).ifPresent(errors::add);
        validateUserAddress(request).ifPresent(errors::add);
        validatePelvisWidth(request).ifPresent(errors::add);
        validateBackHeight(request).ifPresent(errors::add);
        validateShinLength(request).ifPresent(errors::add);
        validateThighLength(request).ifPresent(errors::add);
        indexFrontWheelIsAbsent(request).ifPresent(errors::add);
        indexBackWheelIsAbsent(request).ifPresent(errors::add);
        indexBrakeIsAbsent(request).ifPresent(errors::add);
        indexArmrestIsAbsent(request).ifPresent(errors::add);


        return errors;

    }

    private Optional<CoreError> validateNameSurname(ClientRequest request) {
        return (request.getNameSurname() == null || request.getNameSurname().isEmpty())
                ? Optional.of((new CoreError("nameSurname", "Must not be empty!")))
                : Optional.empty();
    }

    private Optional<CoreError> validatePhoneNumber(ClientRequest request) {
        return (request.getPhoneNumber() == null || request.getPhoneNumber() <= 0)
                ? Optional.of((new CoreError("phoneNumber", "Must not be empty")))
                : Optional.empty();
    }

    private Optional<CoreError> validateUserAddress(ClientRequest request) {
        return (request.getUserAddress() == null || request.getUserAddress().isEmpty())
                ? Optional.of((new CoreError("userAddress", "Must not be empty")))
                : Optional.empty();
    }

    private Optional<CoreError> validatePelvisWidth(ClientRequest  request) {
        return (request.getPelvisWidth() == null || request.getPelvisWidth() <= 0)
                ? Optional.of((new CoreError("pelvisWidth", "Must not be empty!")))
                : Optional.empty();
    }

    private Optional<CoreError> validateThighLength(ClientRequest  request) {
        return (request.getThighLength() == null || request.getThighLength() <= 0)
                ? Optional.of((new CoreError("thighLength", "Must not be empty!")))
                : Optional.empty();
    }

    private Optional<CoreError> validateBackHeight(ClientRequest  request) {
        return (request.getBackLength() == null || request.getBackLength() <= 0)
                ? Optional.of((new CoreError("backHeight", "Must not be empty!")))
                : Optional.empty();
    }

    private Optional<CoreError> validateShinLength(ClientRequest  request) {
        return (request.getShinLength() == null || request.getShinLength() <= 0)
                ? Optional.of((new CoreError("shinLength", "Must not be empty!")))
                : Optional.empty();
    }

    private Optional<CoreError> indexFrontWheelIsAbsent(ClientRequest request) {
        List<Integer> allIndex = dataComponents.getAllIndex();
        int indexFrontWheel = 0;
        for (Integer index : allIndex) {
            if (index == request.getIndexWheelFront()) {
                indexFrontWheel = index;
            }
        }
        return (request.getIndexWheelFront() != indexFrontWheel)
                ? Optional.of((new CoreError("indexFrontWheel", "This index is absent!")))
                : Optional.empty();


    }

    private Optional<CoreError> indexBackWheelIsAbsent(ClientRequest request) {
        List<Integer> allIndex = dataComponents.getAllIndex();
        int indexFrontWheel = 0;
        for (Integer index : allIndex) {
            if (index == request.getIndexWheelBack()) {
                indexFrontWheel = index;
            }
        }
        return (request.getIndexWheelBack() != indexFrontWheel)
                ? Optional.of((new CoreError("indexBackWheel", "This index is absent!")))
                : Optional.empty();


    }

    private Optional<CoreError> indexBrakeIsAbsent(ClientRequest request) {
        List<Integer> allIndex = dataComponents.getAllIndex();
        int indexFrontWheel = 0;
        for (Integer index : allIndex) {
            if (index == request.getIndexBrakeChoose()) {
                indexFrontWheel = index;
            }
        }
        return (request.getIndexBrakeChoose() != indexFrontWheel)
                ? Optional.of((new CoreError("indexBrake", "This index is absent!")))
                : Optional.empty();


    }

    private Optional<CoreError> indexArmrestIsAbsent(ClientRequest request) {
        List<Integer> allIndex = dataComponents.getAllIndex();
        int indexFrontWheel = 0;
        for (Integer index : allIndex) {
            if (index == request.getIndexArmrestChoose()) {
                indexFrontWheel = index;
            }
        }
        return (request.getIndexArmrestChoose() != indexFrontWheel)
                ? Optional.of((new CoreError("indexArmrest", "This index is absent!")))
                : Optional.empty();

    }

}
