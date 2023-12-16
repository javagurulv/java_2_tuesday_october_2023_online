package lv.avangardteen.core.service;

import lv.avangardteen.core.data.Database;
import lv.avangardteen.core.dto.Client;
import lv.avangardteen.core.dto.Order;
import lv.avangardteen.core.dto.UserSizes;
import lv.avangardteen.core.dto.Wheelchair;
import lv.avangardteen.core.request.ChangePersonalSizeRequest;
import lv.avangardteen.core.request.UserSizeRegistrationRequest;
import lv.avangardteen.core.responce.ChangePersonalSizeResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.responce.UserSizeRegistrationResponse;
import lv.avangardteen.core.service.validate.PersonalSizeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserSizeRegistrationService {
    @Autowired
    private Database database;
    @Autowired
    private PersonalSizeValidator validator;
    @Autowired
    private CalculateDimensionsWheelchair dimensionsWheelchair;

    public UserSizeRegistrationResponse execute(UserSizeRegistrationRequest request) {
        List<CoreError> errors = validator.validate(request.getUserSizes());
        return (!errors.isEmpty())
                ? new UserSizeRegistrationResponse(errors)
                : getUserSizeResponse(request);

    }

    private UserSizeRegistrationResponse getUserSizeResponse(UserSizeRegistrationRequest request) {
        UserSizeRegistrationResponse response = new UserSizeRegistrationResponse();
        Wheelchair wheelchair = dimensionsWheelchair.setDimensions(request.getUserSizes());
        response.setUserSizes(response.getUserSizes());
        response.setWheelchair(wheelchair);
        database.addUserSize(request.getUserSizes());
        database.addWheelchair(wheelchair);

        return response;
    }
}
