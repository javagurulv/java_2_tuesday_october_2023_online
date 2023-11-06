package lv.avangardteen.core.service;

import lv.avangardteen.dto.Client;
import lv.avangardteen.dto.UserSizes;
import lv.avangardteen.dto.Wheelchair;
import lv.avangardteen.core.request.ChangePersonalSizeRequest;
import lv.avangardteen.core.responce.ChangePersonalSizeResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ChangePersonalSizeValidator;
import lv.avangardteen.data.Database;

import java.util.List;

public class ChangePersonalSizeService {
    private Database database;
    private UserSizes userSizes;

    private ChangePersonalSizeValidator validator;

    public ChangePersonalSizeService(Database database, ChangePersonalSizeValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public ChangePersonalSizeResponse execute(ChangePersonalSizeRequest request) {
        List<CoreError> errors = validator.validate(request);
        return (!errors.isEmpty())
                ? new ChangePersonalSizeResponse(errors)
                : getChangePersonalSizeResponse(request);

    }

    private ChangePersonalSizeResponse getChangePersonalSizeResponse(ChangePersonalSizeRequest request) {
        Client client = database.getClient(request.getId());


        client.setUserSizes(new UserSizes(request.getPelvisWidth(),
                request.getThighLength(),
                request.getBackHeight(),
                request.getShinLength()));
        client.setWheelchair(new Wheelchair(new UserSizes(request.getPelvisWidth(),
                request.getThighLength(),
                request.getBackHeight(),
                request.getShinLength())));

        return new ChangePersonalSizeResponse(client);
    }
}