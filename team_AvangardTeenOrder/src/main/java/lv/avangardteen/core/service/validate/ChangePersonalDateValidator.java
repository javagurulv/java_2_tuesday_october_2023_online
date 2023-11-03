package lv.avangardteen.core.service.validate;

import lv.avangardteen.Client;
import lv.avangardteen.core.request.ChangePersonalDateRequest;
import lv.avangardteen.core.request.DeleteOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.DataOrders;
import lv.avangardteen.data.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChangePersonalDateValidator {

private ClientIdValidator clientIdValidator;

    public ChangePersonalDateValidator(ClientIdValidator clientIdValidator) {
        this.clientIdValidator = clientIdValidator;
    }

    public List<CoreError> validate(ChangePersonalDateRequest request) {
        List<CoreError> errors = clientIdValidator.validate(request.getId());
        validateNameSurname(request).ifPresent(errors::add);
        validatePhoneNumber(request).ifPresent(errors::add);
        validateUserAddress(request).ifPresent(errors::add);
        return errors;

    }

    private Optional<CoreError> validateNameSurname(ChangePersonalDateRequest request) {
        return (request.getNameSurname() == null || request.getNameSurname().isEmpty())
                ? Optional.of((new CoreError("nameSurname", "Must not be empty!")))
                : Optional.empty();
    }

    private Optional<CoreError> validatePhoneNumber(ChangePersonalDateRequest request) {
        return (request.getPhoneNumber() == null || request.getPhoneNumber() <= 0)
                ? Optional.of(new CoreError("phoneNumber", "Must not be zero!"))
                : Optional.empty();
    }


    private Optional<CoreError> validateUserAddress(ChangePersonalDateRequest request) {
        return (request.getUserAddress() == null || request.getUserAddress().isEmpty())
                ? Optional.of((new CoreError("userAddress", "Must not be empty!")))
                : Optional.empty();
    }

}
