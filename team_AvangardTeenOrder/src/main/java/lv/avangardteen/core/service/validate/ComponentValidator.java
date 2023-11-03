package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.DataComponents;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComponentValidator {
   private DataComponents dataComponents;

    public ComponentValidator(DataComponents dataComponents) {
        this.dataComponents = dataComponents;
    }

    public List<CoreError> validate(Integer wheelFrontChoose, Integer wheelBackChoose,
                                    Integer brakeChoose, Integer armrestChoose) {
        List<CoreError> errors = new ArrayList<>();
        if (indexWheelFrontIsAbsent(wheelFrontChoose)) {
            errors.add(new CoreError("indexFrontWheel", "This index is absent!"));
        }
        if (indexBackWheelIsAbsent(wheelBackChoose)) {
            errors.add(new CoreError("indexBackWheel", "This index is absent!"));

        }
        if (indexBrakeIsAbsent(brakeChoose)) {
            errors.add(new CoreError("indexBrake", "This index is absent!"));
        }
        if (indexArmrestIsAbsent(armrestChoose)) {
            errors.add(new CoreError("indexArmrest", "This index is absent!"));
        }
        return errors;
    }

    private boolean indexWheelFrontIsAbsent(Integer  wheelFrontChoose) {
        List<Integer> allIndex = dataComponents.getAllIndex();
        Integer indexFrontWheel = 1000;
        for (Integer index : allIndex) {
            if (index ==  wheelFrontChoose) {
                indexFrontWheel = index;
            }
        }
        return ( wheelFrontChoose != indexFrontWheel);

    }

    private boolean indexBackWheelIsAbsent(Integer wheelBackChoose) {
        List<Integer> allIndex = dataComponents.getAllIndex();
        Integer indexFrontWheel = 1000;
        for (Integer index : allIndex) {
            if (index == wheelBackChoose) {
                indexFrontWheel = index;
            }
        }
        return (wheelBackChoose != indexFrontWheel);

    }

    private boolean indexBrakeIsAbsent(Integer backHeight) {
        List<Integer> allIndex = dataComponents.getAllIndex();
        Integer indexFrontWheel = 1000;
        for (Integer index : allIndex) {
            if (index == backHeight) {
                indexFrontWheel = index;
            }
        }
        return (backHeight != indexFrontWheel);


    }

    private boolean indexArmrestIsAbsent(Integer armrestChoose) {
        List<Integer> allIndex = dataComponents.getAllIndex();
        Integer indexFrontWheel = 1000;
        for (Integer index : allIndex) {
            if (index == armrestChoose) {
                indexFrontWheel = index;
            }
        }
        return (armrestChoose != indexFrontWheel);

    }

}
