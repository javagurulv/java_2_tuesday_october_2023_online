package lv.avangardteen.core.service;

import lv.avangardteen.core.domain.UserSizes;
import lv.avangardteen.core.domain.Wheelchair;
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
        UserSizes userSizes = database.getUserSize(request.getId());
        Wheelchair wheelchair = database.getWheelchair(request.getId());
        ChangePersonalSizeResponse response = new ChangePersonalSizeResponse(userSizes, wheelchair);
        response.setUserSizes(request.getUserSizes());
        Wheelchair wheelchairUpdate = dimensionsWheelchair.setDimensions(request.getUserSizes());
        response.setWheelchair(wheelchairUpdate);
        database.updateUserSize(request.getId(), request.getUserSizes());
        database.updateWheelchair(request.getId(), wheelchairUpdate);

        return response;
    }

}