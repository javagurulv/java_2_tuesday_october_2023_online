package lv.avangardteen.core.service;

import lv.avangardteen.core.request.DeleteOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class IdOrderValidator {

    private Database database;

    public IdOrderValidator(Database database) {
        this.database = database;
    }

    public List<CoreError> validate(DeleteOrderRequest request) {
        List<CoreError> errors = new ArrayList<>();
        clientNotFound(request).ifPresent(errors::add);

        return errors;
    }


    public Optional<CoreError> clientNotFound(DeleteOrderRequest request) {
        return (database.getClient(request.getId()) == null)
                ? Optional.of(new CoreError("idClient", "Order with this id not found!"))
                : Optional.empty();

    }

}
