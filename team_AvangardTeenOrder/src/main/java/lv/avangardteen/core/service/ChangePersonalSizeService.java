package lv.avangardteen.core.service;

import lv.avangardteen.core.dto.Client;
import lv.avangardteen.core.dto.UserSizes;
import lv.avangardteen.core.request.ChangePersonalSizeRequest;
import lv.avangardteen.core.responce.ChangePersonalSizeResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ChangePersonalSizeValidator;
import lv.avangardteen.core.data.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChangePersonalSizeService {
    @Autowired
    private Database database;
    @Autowired
    private CalculateDimensionsWheelchair dimensionsWheelchair;
    @Autowired
    private ChangePersonalSizeValidator validator;

    public ChangePersonalSizeResponse execute(ChangePersonalSizeRequest request) {
        List<CoreError> errors = validator.validate(request);
        return (!errors.isEmpty())
                ? new ChangePersonalSizeResponse(errors)
                : getChangePersonalSizeResponse(request);

    }

    private ChangePersonalSizeResponse getChangePersonalSizeResponse(ChangePersonalSizeRequest request) {
        Client client = database.getClient(request.getId());
        UserSizes userSizes = request.getUserSizes();
        client.setUserSizes(userSizes);
        client.setWheelchair(dimensionsWheelchair.setDimensions(userSizes));

        return new ChangePersonalSizeResponse(client);
    }

}