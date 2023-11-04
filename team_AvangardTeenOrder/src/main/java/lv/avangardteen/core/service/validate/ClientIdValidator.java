package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.Database;

import java.util.ArrayList;
import java.util.List;


public class ClientIdValidator {
    private Database database;

    public ClientIdValidator(Database database) {
        this.database = database;
    }

    public List<CoreError> validate(Long id) {
        List<CoreError> errors = new ArrayList<>();
        if (isEmpty(id)) {
            errors.add(new CoreError("idClient", "Must not be empty!"));

        } else if (clientNotFound(id)) {
            errors.add(new CoreError("idClient", "Order with this id not found!"));
        }

        return errors;
    }

    private boolean clientNotFound(Long id) {
        return (database.getClient(id) == null);
    }

    private boolean isEmpty(Long id) {
        return id == null || id <= 0;
    }
}
