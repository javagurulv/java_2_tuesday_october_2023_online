package lv.avangardteen.core.service;

import lv.avangardteen.core.database.*;
import lv.avangardteen.core.request.ComponentRegistrationRequest;
import lv.avangardteen.core.responce.ComponentRegistrationResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ComponentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ComponentRegistrationService {
    @Autowired
    private Database database;
    @Autowired
    private UserSizeDb userSizeDb;
    @Autowired
    private WheelchairDB wheelchairDB;
    @Autowired
    private WComponentsDB wComponentsDB;

    @Autowired
    private ComponentValidator validator;

    public ComponentRegistrationResponse execute(ComponentRegistrationRequest request) {
        List<CoreError> errors = validator.validate(request);
        return (!errors.isEmpty())
                ? new ComponentRegistrationResponse(errors)
                : getResponse(request);

    }

    private ComponentRegistrationResponse getResponse(ComponentRegistrationRequest request) {
        ComponentRegistrationResponse response = new ComponentRegistrationResponse();
        response.setWheelFrontChoose(request.getWheelFrontChoose());
        response.setWheelBackChoose(request.getWheelBackChoose());
        response.setBrakeChoose(request.getBrakeChoose());
        response.setFootrestChoose(request.getFootrestChoose());
        Long idWheelchair = wheelchairDB.getIdWheelchair();
        wComponentsDB.addWheelchairComponents(idWheelchair, request.getWheelFrontChoose());
        wComponentsDB.addWheelchairComponents(idWheelchair, request.getWheelBackChoose());
        wComponentsDB.addWheelchairComponents(idWheelchair, request.getBrakeChoose());
        wComponentsDB.addWheelchairComponents(idWheelchair, request.getFootrestChoose());
        database.setOrderId(idWheelchair);
        userSizeDb.setOrderId(idWheelchair);
        return response;
    }

}
