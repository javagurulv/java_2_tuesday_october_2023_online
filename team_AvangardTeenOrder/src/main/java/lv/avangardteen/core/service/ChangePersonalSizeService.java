package lv.avangardteen.core.service;

import lv.avangardteen.dependency_injection.DIComponent;
import lv.avangardteen.dependency_injection.DIDependency;
import lv.avangardteen.dto.Client;
import lv.avangardteen.dto.UserSizes;
import lv.avangardteen.dto.Wheelchair;
import lv.avangardteen.core.request.ChangePersonalSizeRequest;
import lv.avangardteen.core.responce.ChangePersonalSizeResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ChangePersonalSizeValidator;
import lv.avangardteen.data.Database;

import java.util.List;

@DIComponent
public class ChangePersonalSizeService {
    @DIDependency
    private Database database;
    @DIDependency
    private CalculateDimensionsWheelchair dimensionsWheelchair;
    @DIDependency
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