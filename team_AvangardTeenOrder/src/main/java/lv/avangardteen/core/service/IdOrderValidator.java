package lv.avangardteen.core.service;

import lv.avangardteen.Client;
import lv.avangardteen.core.request.ChangePersonalDateRequest;
import lv.avangardteen.core.request.DeleteOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.DataOrders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class IdOrderValidator {


    public List<CoreError> validate(DeleteOrderRequest request) {
        List<CoreError> errors = new ArrayList<>();
        getUser(request).ifPresent(errors::add);
        return errors;
    }

    public Optional<CoreError> getUser(DeleteOrderRequest request) {
        return (request.getId() <= 0)
        ? Optional.of(new CoreError("idOrder", "Must not be empty!"))
        : Optional.empty();
    }

}
