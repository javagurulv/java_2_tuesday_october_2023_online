package lv.avangardteen.core.service;

import lv.avangardteen.Client;
import lv.avangardteen.core.request.ChangePersonalDateRequest;
import lv.avangardteen.core.responce.ChangePersonalDateResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.DataOrders;
import lv.avangardteen.data.Database;

import java.util.List;

public class ChangePersonalDateService {
    private Database database;

    private ChangePersonalDateValidator validator;

    public ChangePersonalDateService(Database database, ChangePersonalDateValidator validator) {
        this.database = database;
        this.validator = validator;
    }

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
