package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.database.Database;
import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowOrderValidator {

    @Autowired
    private OrderIdValidator idValidator;
    @Autowired
    private Database database;

    public List<CoreError> validate(ShowOrderRequest request) {
        List<CoreError> errors = idValidator.validate(request.getId());
        return errors;
    }

}
