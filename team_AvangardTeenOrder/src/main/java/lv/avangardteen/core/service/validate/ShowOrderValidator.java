package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.data.Database;
import lv.avangardteen.core.request.ChangePersonalDateRequest;
import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowOrderValidator {

    @Autowired
    private ClientIdValidator idValidator;
    @Autowired
    Database database;

    public List<CoreError> validate(ShowOrderRequest request) {
        List<CoreError> errors = idValidator.validate(request.getId());
        if (validateOrder(request)) {
            errors.add(new CoreError("OrderIsAbsent", "This order is absent!"));
        }
        return errors;
    }

    private boolean validateOrder(ShowOrderRequest request) {
        if (database.getUserSize(request.getId()) != null
                && database.getWheelchair(request.getId()) != null
                && database.getWheelchairComponents(request.getId()) != null) {
            return false;
        }
        return true;
    }

}
