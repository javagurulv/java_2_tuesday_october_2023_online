package lv.avangardteen.core.service;

import lv.avangardteen.core.request.ChangePersonalDateRequest;
import lv.avangardteen.core.responce.CoreError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChangePersonalDateValidator {

    public List<CoreError> validate(ChangePersonalDateRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateId(request).ifPresent(errors::add);
        validateNameSurname(request).ifPresent(errors::add);
        validatePhoneNumber(request).ifPresent(errors::add);
        validateUserAddress(request).ifPresent(errors::add);
        return errors;

    }

    private Optional<CoreError> validateId(ChangePersonalDateRequest request) {
        return (request.getId() <= 0)
                ? Optional.of(new CoreError("idClient", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateNameSurname(ChangePersonalDateRequest request) {
        return (request.getNameSurname() == null || request.getNameSurname().isEmpty())
                ? Optional.of((new CoreError("nameSurname", "Must not be empty!")))
                : Optional.empty();
    }

    private Optional<CoreError> validatePhoneNumber(ChangePersonalDateRequest request) {
        return (request.getPhoneNumber() == 0)
                ? Optional.of(new CoreError("phoneNumber", "Must contain only numbers!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateUserAddress(ChangePersonalDateRequest request) {
        return (request.getUserAddress() == null || request.getUserAddress().isEmpty())
                ? Optional.of((new CoreError("userAddress", "Must not be empty!")))
                : Optional.empty();
    }

}
