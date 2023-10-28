package lv.avangardteen.core.service;

import lv.avangardteen.Client;
import lv.avangardteen.core.request.ChangePersonalDateRequest;
import lv.avangardteen.core.responce.ChangePersonalDateResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.DataOrders;

import java.util.List;

public class ChangePersonalDateService {
    DataOrders dataOrders;

    private ChangePersonalDateValidator validator;

    public ChangePersonalDateService(DataOrders dataOrders, ChangePersonalDateValidator validator) {
        this.dataOrders = dataOrders;
        this.validator = validator;
    }

    public ChangePersonalDateResponse execute(ChangePersonalDateRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new ChangePersonalDateResponse(errors);
        }
        Client client = dataOrders.getClient(request.getId());
        ChangePersonalDateResponse response = new ChangePersonalDateResponse(client);

        response.getClient().setNameSurname(request.getNameSurname());
        response.getClient().setPhoneNumber(request.getPhoneNumber());
        response.getClient().setUserAddress(request.getUserAddress());

        return new ChangePersonalDateResponse(client);

    }
}
