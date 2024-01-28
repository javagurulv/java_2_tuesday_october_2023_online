package lv.avangardteen.core.service;

import lv.avangardteen.core.database.Database;
import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.request.UserRegistrationRequest;

import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.responce.UserRegistrationResponse;

import lv.avangardteen.core.service.validate.PersonalDateValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class UserRegistrationService {
    @Autowired
    private Database database;

    @Autowired
    private PersonalDateValidation validator;


    public UserRegistrationResponse execute(UserRegistrationRequest request) {
        List<CoreError> errors = validator.validate(request);
        return (!errors.isEmpty())
                ? new UserRegistrationResponse(errors)
                : getResponse(request);

    }

    private UserRegistrationResponse getResponse(UserRegistrationRequest request) {
        Client client = new Client();
        client.setNameSurname(request.getNameSurname());
        client.setPersonalCode(request.getPersonalCode());
        client.setPhone(request.getPhoneNumber());
        client.setAddress(request.getUserAddress());
        UserRegistrationResponse response = new UserRegistrationResponse(client);
        database.addUser(client);
        return response;
    }
}
