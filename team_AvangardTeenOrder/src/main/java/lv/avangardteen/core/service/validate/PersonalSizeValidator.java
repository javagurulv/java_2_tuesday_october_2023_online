package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.domain.UserSizes;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonalSizeValidator {

    public List<CoreError> validate(UserSizes userSizes) {
        List<CoreError> errors = new ArrayList<>();
        if (pelvisWidthIsNull(userSizes)) {
            errors.add(new CoreError("pelvisWidth", "Must not be empty!"));
        }
        if (thighLengthIsNull(userSizes)) {
            errors.add(new CoreError("thighLength", "Must not be empty!"));
        }
        if (backHeightIsNull(userSizes)) {
            errors.add(new CoreError("backHeight", "Must not be empty!"));
        }
        if (shinLengthIsNull(userSizes)) {
            errors.add(new CoreError("shinLength", "Must not be empty!"));
        }
        return errors;
    }

    private boolean pelvisWidthIsNull(UserSizes userSizes) {
        return (userSizes.getPelvisWidth() == null || userSizes.getPelvisWidth() <= 0);
    }

    private boolean thighLengthIsNull(UserSizes userSizes) {
        return (userSizes.getThighLength() == null || userSizes.getThighLength() <= 0);
    }

    private boolean backHeightIsNull(UserSizes userSizes) {
        return (userSizes.getBackHeight() == null || userSizes.getBackHeight() <= 0);
    }

    private boolean shinLengthIsNull(UserSizes userSizes) {
        return (userSizes.getShinLength() == null || userSizes.getShinLength() <= 0);
    }

}
