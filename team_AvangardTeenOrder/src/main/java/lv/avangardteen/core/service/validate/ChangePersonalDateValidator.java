package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.database.Database;
import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.request.ChangePersonalDateRequest;
import lv.avangardteen.core.responce.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChangePersonalDateValidator {
    @Autowired
    private Database database;
    @Autowired
    private OrderIdValidator clientIdValidator;
    @Autowired
    private PersonalDateValidation personalDateValidation;

    public List<CoreError> validate(ChangePersonalDateRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateIdClient(request, errors);
        validatePersonalDate(request, errors);
        return errors;

    }

    private void validateIdClient(ChangePersonalDateRequest request, List<CoreError> errors) {
        errors.addAll(clientIdValidator.validate(request.getId()));
    }

    private void validatePersonalDate(ChangePersonalDateRequest request, List<CoreError> errors) {
        errors.addAll(personalDateValidation
                .validate(request.getUserRegistration()));

    }

    private boolean clientIsPresentInDb(Client userRegistration) {
        Client client = database.findBySurnameAndPersonalCode(userRegistration.getNameSurname(), userRegistration.getPersonalCode());
        if (client != null) {
            return true;
        }
        return false;
    }

}


