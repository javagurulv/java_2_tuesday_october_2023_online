package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.database.WheelchairDB;
import lv.avangardteen.core.domain.Wheelchair;
import lv.avangardteen.core.responce.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderIdValidator {

    @Autowired
    private WheelchairDB wheelchairDB;

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
        return (id == null);
    }

    private boolean validateOrder(Long id) {
        Wheelchair wheelchair = wheelchairDB.getWheelchair(id);
        if (!isEmpty(id) && wheelchair == null) {
            return true;
        }
        return false;
    }
}
