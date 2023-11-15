package lv.avangardteen.core.service;

import lv.avangardteen.dependency_injection.DIComponent;
import lv.avangardteen.dependency_injection.DIDependency;
import lv.avangardteen.dto.Client;
import lv.avangardteen.core.request.ChangePersonalDateRequest;
import lv.avangardteen.core.responce.ChangePersonalDateResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ChangePersonalDateValidator;
import lv.avangardteen.data.Database;

import java.util.List;

@DIComponent
public class ChangePersonalDateService {
    @DIDependency
    private Database database;

    @DIDependency
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
