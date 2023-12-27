package lv.avangardteen.core.service;

import lv.avangardteen.core.data.Database;
import lv.avangardteen.core.dto.Client;
import lv.avangardteen.core.request.UserRegistrationRequest;

import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.responce.UserRegistrationResponse;

import lv.avangardteen.core.service.validate.PersonalDateValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRegistrationService {
    @Autowired
    private Database database;

    @Autowired
    private PersonalDateValidation validator;


    public UserRegistrationResponse execute(UserRegistrationRequest request) {
        List<CoreError> errors = validator.validate(request.getUserRegistration());
        return (!errors.isEmpty())
                ? new UserRegistrationResponse(errors)
                : getResponse(request);

    }

    private UserRegistrationResponse getResponse(UserRegistrationRequest request) {
        Client userRegistration = request.getUserRegistration();
        database.addUser(userRegistration);
        return new UserRegistrationResponse(userRegistration);
    }
}
