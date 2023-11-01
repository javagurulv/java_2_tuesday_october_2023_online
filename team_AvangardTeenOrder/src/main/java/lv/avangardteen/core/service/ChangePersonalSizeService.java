package lv.avangardteen.core.service;

import lv.avangardteen.Client;
import lv.avangardteen.UserSizes;
import lv.avangardteen.Wheelchair;
import lv.avangardteen.core.request.ChangePersonalSizeRequest;
import lv.avangardteen.core.responce.ChangePersonalDateResponse;
import lv.avangardteen.core.responce.ChangePersonalSizeResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.DataOrders;
import lv.avangardteen.data.Database;

import java.util.List;

public class ChangePersonalSizeService {
    Database database;

    private ChangePersonalSizeValidator validator;

    public ChangePersonalSizeService(Database database, ChangePersonalSizeValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public ChangePersonalSizeResponse execute(ChangePersonalSizeRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new ChangePersonalSizeResponse(errors);
        }
        Client client = database.getClient(request.getId());
        ChangePersonalSizeResponse response = new ChangePersonalSizeResponse(client);

        response.getClient().getUserSizes().setPelvisWidth(request.getPelvisWidth());
        response.getClient().getUserSizes().setThighLength(request.getThighLength());
        response.getClient().getUserSizes().setBackHeight(request.getBackHeight());
        response.getClient().getUserSizes().setShinLength(request.getShinLength());

        response.getClient().setWheelchair(new Wheelchair(new UserSizes(request.getBackHeight(),
                request.getPelvisWidth(),
                request.getShinLength(),
                request.getThighLength())));

        return new ChangePersonalSizeResponse(client);

    }
}