package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.database.Database;
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

        } else if (clientNotFound(id)) {
            errors.add(new CoreError("idOrder", "Order with this id not found!"));
        }

        return errors;
    }

    private boolean clientNotFound(Long id) {
        return (database.getClientByOrderId(id) == null);
    }

    private boolean isEmpty(Long id) {
        return id == null || id <= 0;
    }
}
