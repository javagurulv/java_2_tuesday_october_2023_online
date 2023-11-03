package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.responce.CoreError;

import java.util.ArrayList;
import java.util.List;

public class PersonalSizeValidator {

    public List<CoreError> validate(Integer pelvisWidth, Integer thighLength, Integer backHeight, Integer shinLength) {
        List<CoreError> errors = new ArrayList<>();
        if (pelvisWidthIsNull(pelvisWidth)) {
            errors.add(new CoreError("pelvisWidth", "Must not be empty!"));
        }
        if (thighLengthIsNull(thighLength)) {
            errors.add(new CoreError("thighLength", "Must not be empty!"));

        }
        if (backHeightIsNull(backHeight)) {
            errors.add(new CoreError("backHeight", "Must not be empty!"));
        }
        if (shinLengthIsNull(shinLength)) {
            errors.add(new CoreError("shinLength", "Must not be empty!"));
        }
        return errors;
    }

    private boolean pelvisWidthIsNull(Integer pelvisWidth) {
        return (pelvisWidth == null || pelvisWidth <= 0);
    }

    private boolean thighLengthIsNull(Integer thighLength) {
        return (thighLength == null || thighLength <= 0);
    }

    private boolean backHeightIsNull(Integer backHeight) {
        return (backHeight == null || backHeight <= 0);
    }

    private boolean shinLengthIsNull(Integer shinLength) {
        return (shinLength == null || shinLength <= 0);
    }

}
