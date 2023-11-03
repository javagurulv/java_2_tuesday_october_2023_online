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

    private Database database;

    public ShowOrderValidator(Database database) {
        this.database = database;
    }

    public List<CoreError> validate(ShowOrderRequest request) {
        List<CoreError> errors = new ArrayList<>();
        clientNotFound(request).ifPresent(errors::add);
        return errors;
    }

    public Optional<CoreError> clientNotFound(ShowOrderRequest request) {
        return (database.getClient(request.getId()) == null)
                ? Optional.of(new CoreError("idClient", "Order with this id not found!"))
                : Optional.empty();

    }

}
