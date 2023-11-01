package lv.avangardteen.core.service;

import lv.avangardteen.core.request.ChangePersonalDateRequest;
import lv.avangardteen.core.request.ChangePersonalSizeRequest;
import lv.avangardteen.core.request.DeleteOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.DataOrders;
import lv.avangardteen.data.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChangePersonalSizeValidator {

    private Database database;


    public ChangePersonalSizeValidator(Database database) {
        this.database = database;
    }

    public List<CoreError> validate(ChangePersonalSizeRequest request) {
        List<CoreError> errors = new ArrayList<>();
        clientNotFound(request).ifPresent(errors::add);
        validatePelvisWidth(request).ifPresent(errors::add);
        validateThighLength(request).ifPresent(errors::add);
        validateBackHeight(request).ifPresent(errors::add);
        validateShinLength(request).ifPresent(errors::add);
        return errors;

    }

    public Optional<CoreError> clientNotFound(ChangePersonalSizeRequest request) {
        return (database.getClient(request.getId()) == null)
                ? Optional.of(new CoreError("idClient", "Order with this id not found!"))
                : Optional.empty();

    }


    private Optional<CoreError> validatePelvisWidth(ChangePersonalSizeRequest request) {
        return (request.getPelvisWidth() <= 0)
                ? Optional.of((new CoreError("pelvisWidth", "Must not be empty!")))
                : Optional.empty();
    }

    private Optional<CoreError> validateThighLength(ChangePersonalSizeRequest request) {
        return (request.getThighLength() <= 0)
                ? Optional.of((new CoreError("thighLength", "Must not be empty!")))
                : Optional.empty();
    }

    private Optional<CoreError> validateBackHeight(ChangePersonalSizeRequest request) {
        return (request.getBackHeight() <= 0)
                ? Optional.of((new CoreError("backHeight", "Must not be empty!")))
                : Optional.empty();
    }

    private Optional<CoreError> validateShinLength(ChangePersonalSizeRequest request) {
        return (request.getShinLength() <= 0)
                ? Optional.of((new CoreError("shinLength", "Must not be empty!")))
                : Optional.empty();
    }
}

