package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.responce.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ChooseComponentValidator {

    @Autowired
    private ClientIdValidator idValidator;

    @Autowired
    private ComponentValidator componentValidator;

    public List<CoreError> validate(ChangeComponentRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateIdClient(request, errors);
        validateComponent(request, errors);

        return errors;
    }

    private void validateIdClient(ChangeComponentRequest request, List<CoreError> errors) {
        errors.addAll(idValidator.validate(request.getId()));
    }

    private void validateComponent(ChangeComponentRequest request, List<CoreError> errors) {
        errors.addAll(componentValidator
                .validate(request.getWheelchairComponent()));

    }
}
