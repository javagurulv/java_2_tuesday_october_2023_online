package lv.avangardteen.core.service;

import lv.avangardteen.Client;
import lv.avangardteen.core.request.DeleteOrderRequest;
import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.DataOrders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShowOrderValidator {


    public List<CoreError> validate(ShowOrderRequest request) {
        List<CoreError> errors = new ArrayList<>();
        getUser(request).ifPresent(errors::add);
        return errors;
    }

    public Optional<CoreError> getUser(ShowOrderRequest request) {

        return (request.getId() == 0)
                ? Optional.of(new CoreError("idOrder", "There is no order with this number"))
                : Optional.empty();
    }

}
