package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.request.DeleteOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.dependency_injection.DIComponent;
import lv.avangardteen.dependency_injection.DIDependency;

import java.util.List;

@DIComponent
public class IdOrderValidator {
    @DIDependency
    private ClientIdValidator validatorId;

    public List<CoreError> validate(DeleteOrderRequest request) {
        List<CoreError> errorsList = validatorId.validate(request.getId());
        return errorsList;
    }


}


