package lv.avangardteen.core.service;

import lv.avangardteen.core.dto.Client;
import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.responce.ChangeComponentResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ChooseComponentValidator;
import lv.avangardteen.core.data.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ChangeComponentService {
    @Autowired
    private Database database;
    @Autowired
    private ChooseComponentValidator validator;

    public ChangeComponentResponse execute(ChangeComponentRequest request) {
        List<CoreError> errors = validator.validate(request);
        return (!errors.isEmpty())
                ? new ChangeComponentResponse(errors)
                : getResponse(request);

    }

    private ChangeComponentResponse getResponse(ChangeComponentRequest request) {
        Client client = database.getClient(request.getId());

        client.setWheelchairComponents(request.getWheelchairComponent());

        client.setPriseOrder(client.getWheelchairComponents().countPriceOrder());

        return new ChangeComponentResponse(client);
    }
}
