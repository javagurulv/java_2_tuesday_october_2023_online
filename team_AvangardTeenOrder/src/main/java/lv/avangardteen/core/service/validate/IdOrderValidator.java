package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.request.DeleteOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IdOrderValidator {
    @Autowired
    private ClientIdValidator validatorId;

    public List<CoreError> validate(DeleteOrderRequest request) {
        List<CoreError> errorsList = validatorId.validate(request.getId());
        return errorsList;
    }


}


