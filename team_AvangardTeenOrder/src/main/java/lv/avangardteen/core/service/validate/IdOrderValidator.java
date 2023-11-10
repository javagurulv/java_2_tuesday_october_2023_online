package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.request.DeleteOrderRequest;
import lv.avangardteen.core.responce.CoreError;

import java.util.List;

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


