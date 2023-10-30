package lv.avangardteen.core.service;

import lv.avangardteen.Client;
import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.request.DeleteOrderRequest;

import lv.avangardteen.core.responce.ChangeComponentResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.responce.DeleteOrderResponse;

import lv.avangardteen.data.DataOrders;

import java.util.List;

public class DeleteOrderService {
    DataOrders dataOrders;
    IdOrderValidator validator;

    public DeleteOrderService(DataOrders dataOrders, IdOrderValidator validator) {

        this.dataOrders = dataOrders;
        this.validator = validator;
    }

    public DeleteOrderResponse execute(DeleteOrderRequest request) {
        List<CoreError> errors = validator.validate(request);
            if (!errors.isEmpty()) {
                return new DeleteOrderResponse(errors);
            }

        Client client = dataOrders.getClient(request.getId());
            if(client.getNameSurname().equals(request.getSurname())) {
                dataOrders.deleteUser(request.getId());
            }

        System.out.println("Ваш заказ удален");
        return new DeleteOrderResponse();
    }
}
