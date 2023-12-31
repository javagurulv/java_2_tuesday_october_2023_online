package lv.avangardteen.core.service;

import lv.avangardteen.core.database.UserSizeDb;
import lv.avangardteen.core.database.UserSizeRepositoryImpl;
import lv.avangardteen.core.database.WheelchairDB;
import lv.avangardteen.core.database.WheelchairRepository;
import lv.avangardteen.core.domain.Wheelchair;
import lv.avangardteen.core.request.ChangePersonalSizeRequest;
import lv.avangardteen.core.responce.ChangePersonalSizeResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ChangePersonalSizeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ChangePersonalSizeService {
    @Autowired
    private UserSizeDb userSizeDb;
    @Autowired
    private WheelchairDB wheelchairDB;
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

        ChangePersonalSizeResponse response = new ChangePersonalSizeResponse();
        response.setUserSizes(request.getUserSizes());
        Wheelchair wheelchairUpdate = dimensionsWheelchair.setDimensions(request.getUserSizes());
        response.setWheelchair(wheelchairUpdate);
        userSizeDb.updateUserSize(request.getId(), request.getUserSizes());
        wheelchairDB.updateWheelchair(request.getId(), wheelchairUpdate);

        return response;
    }

}