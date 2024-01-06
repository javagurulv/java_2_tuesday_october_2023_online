package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.database.Database;
import lv.avangardteen.core.request.OrderRequest;
import lv.avangardteen.core.responce.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderValidator {

    @Autowired
    private Database database;
    public List<CoreError> validate(OrderRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (pelvisWidthIsNull(request)) {
            errors.add(new CoreError("pelvisWidth", "Must not be empty!"));
        }
        if (thighLengthIsNull(request)) {
            errors.add(new CoreError("thighLength", "Must not be empty!"));
        }
        if (backHeightIsNull(request)) {
            errors.add(new CoreError("backHeight", "Must not be empty!"));
        }
        if (shinLengthIsNull(request)) {
            errors.add(new CoreError("shinLength", "Must not be empty!"));
        }
        if(clientIsEmpty(request)) {
            errors.add(new CoreError("clientAbsent", "Client must be registered!"));
        }
        return errors;
    }

    private boolean pelvisWidthIsNull(OrderRequest request) {
        return (request.getPelvisWidth() == null || request.getPelvisWidth() <= 0);
    }

    private boolean thighLengthIsNull(OrderRequest request) {
        return (request.getThighLength() == null || request.getThighLength() <= 0);
    }

    private boolean backHeightIsNull(OrderRequest request) {
        return (request.getBackHeight() == null || request.getBackHeight() <= 0);
    }

    private boolean shinLengthIsNull(OrderRequest request) {
        return (request.getShinLength() == null || request.getShinLength() <= 0);
    }

    private boolean clientIsEmpty(OrderRequest request) {
        return (database.findBySurnameAndPersonalCode(request.getUserName(), request.getUserPersonalCode()) == null);
    }

}
