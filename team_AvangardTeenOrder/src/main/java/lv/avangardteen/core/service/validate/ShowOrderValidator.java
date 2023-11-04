package lv.avangardteen.core.service.validate;

import lv.avangardteen.Client;
import lv.avangardteen.core.request.DeleteOrderRequest;
import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.DataOrders;
import lv.avangardteen.data.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShowOrderValidator {

    private ClientIdValidator idValidator;

    public ShowOrderValidator(ClientIdValidator idValidator) {
        this.idValidator = idValidator;
    }

    public List<CoreError> validate(ShowOrderRequest request) {
        List<CoreError> errors = idValidator.validate(request.getId());
        return errors;
    }

}
