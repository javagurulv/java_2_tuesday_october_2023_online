package lv.avangardteen.core.service;

import lv.avangardteen.core.database.Database;
import lv.avangardteen.core.database.UserSizeRepository;
import lv.avangardteen.core.database.WheelchairRepository;
import lv.avangardteen.core.domain.Wheelchair;
import lv.avangardteen.core.request.UserSizeRegistrationRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.responce.UserSizeRegistrationResponse;
import lv.avangardteen.core.service.validate.PersonalSizeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class UserSizeRegistrationService {
    @Autowired
    private UserSizeRepository userSizeRepository;
    @Autowired
    private WheelchairRepository wheelchairRepository;
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
        userSizeRepository.addUserSize(request.getUserSizes());
        wheelchairRepository.addWheelchair(wheelchair);

        return response;
    }
}
