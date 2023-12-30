package lv.avangardteen.core.service;

import lv.avangardteen.core.request.DeleteOrderRequest;

import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.responce.DeleteOrderResponse;

import lv.avangardteen.core.service.validate.DeleteOrderValidator;
import lv.avangardteen.core.database.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class DeleteOrderService {
    @Autowired
    private Database database;
    @Autowired
    private DeleteOrderValidator validator;

    public DeleteOrderResponse execute(DeleteOrderRequest request) {
        List<CoreError> errors = validator.validate(request);
        return (!errors.isEmpty())
                ? new DeleteOrderResponse(errors)
                : getDeleteOrderResponse(request);

    }

    private DeleteOrderResponse getDeleteOrderResponse(DeleteOrderRequest request) {
        boolean isOrderRemove = database.deleteClientByOrderId(request.getId());
        return new DeleteOrderResponse(isOrderRemove);
    }
}
