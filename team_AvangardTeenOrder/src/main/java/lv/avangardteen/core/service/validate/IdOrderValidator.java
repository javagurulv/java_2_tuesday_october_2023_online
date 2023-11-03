package lv.avangardteen.core.service.validate;

import lv.avangardteen.Client;
import lv.avangardteen.core.request.DeleteOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class IdOrderValidator {


    private ClientIdValidator validatorId;

    public IdOrderValidator(ClientIdValidator validatorId) {
        this.validatorId = validatorId;
    }

    public List<CoreError> validate(DeleteOrderRequest request) {
        List<CoreError> errorsList = validatorId.validate(request.getId());
        return errorsList;
    }


}


