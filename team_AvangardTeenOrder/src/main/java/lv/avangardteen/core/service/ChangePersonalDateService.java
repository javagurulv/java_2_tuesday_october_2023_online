package lv.avangardteen.core.service;

import lv.avangardteen.core.dto.Client;
import lv.avangardteen.core.request.ChangePersonalDateRequest;
import lv.avangardteen.core.responce.ChangePersonalDateResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ChangePersonalDateValidator;
import lv.avangardteen.core.data.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChangePersonalDateService {
    @Autowired
    private Database database;

    @Autowired
    private ChangePersonalDateValidator validator;

    public ChangePersonalDateResponse execute(ChangePersonalDateRequest request) {
        List<CoreError> errors = validator.validate(request);
        return (!errors.isEmpty())
                ? new ChangePersonalDateResponse(errors)
                : getResponse(request);

    }

    private ChangePersonalDateResponse getResponse(ChangePersonalDateRequest request) {
        Client client = database.getClient(request.getId());
        ChangePersonalDateResponse response = new ChangePersonalDateResponse(client);

        response.getClient().setNameSurname(request.getNameSurname());
        response.getClient().setPhoneNumber(request.getPhoneNumber());
        response.getClient().setUserAddress(request.getUserAddress());

        return new ChangePersonalDateResponse(client);
    }
}
