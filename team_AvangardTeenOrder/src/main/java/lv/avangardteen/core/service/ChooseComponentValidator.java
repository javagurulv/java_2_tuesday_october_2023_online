package lv.avangardteen.core.service;

import lv.avangardteen.Category;
import lv.avangardteen.Component;
import lv.avangardteen.core.request.ChangeComponentRequest;

import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.DataComponents;

import lv.avangardteen.data.Database;


import java.util.*;

public class ChooseComponentValidator {

    private Database database;
    private DataComponents dataComponents = new DataComponents();

    public ChooseComponentValidator(Database database) {
        this.database = database;
    }

    public List<CoreError> validate(ChangeComponentRequest request) {
        List<CoreError> errors = new ArrayList<>();
        clientNotFound(request).ifPresent(errors::add);
        indexFrontWheelIsAbsent(request).ifPresent(errors::add);
        indexBackWheelIsAbsent(request).ifPresent(errors::add);
        indexBrakeIsAbsent(request).ifPresent(errors::add);
        indexArmrestIsAbsent(request).ifPresent(errors::add);
        validateMapComponent(request).ifPresent(errors::add);
        return errors;
    }

    public Optional<CoreError> clientNotFound(ChangeComponentRequest request) {
        return (database.getClient(request.getId()) == null)
                ? Optional.of(new CoreError("idClient", "Order with this id not found!"))
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

    private Optional<CoreError> validateMapComponent(ChangeComponentRequest request) {
        Component component = dataComponents.getComponent(request.getWheelFrontChoose());
        Component component1 = dataComponents.getComponent(request.getWheelBackChoose());
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
