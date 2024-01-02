package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.database.Database;
import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.responce.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderIdValidator {

    @Autowired
    private Database database;

    public List<CoreError> validate(Long id) {
        List<CoreError> errors = new ArrayList<>();
        if (isEmpty(id)) {
            errors.add(new CoreError("idOrder", "Must not be empty!"));
        }
        if (validateOrder(id)) {
            errors.add(new CoreError("OrderIsAbsent", "This order is absent!"));
        }

        return errors;
    }


    private boolean isEmpty(Long id) {
        return id == null || id <= 0;
    }

    private boolean validateOrder(Long id) {
        Client client = database.getClientByOrderId(id);
        if (!isEmpty(id)
        && client == null) {
            return true;
        }
        return false;
    }
}
