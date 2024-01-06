package lv.avangardteen.core.service;

import lv.avangardteen.core.database.*;
import lv.avangardteen.core.domain.Components;
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
    private DataComponents dataComponents;
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
        wComponentsDB.deleteWheelchairComponents(idWheelchair);

        Components componentFrontWheel = dataComponents.getComponent(request.getWheelFrontChoose());
        Components componentBackWheel = dataComponents.getComponent(request.getWheelBackChoose());
        Components componentBrake = dataComponents.getComponent(request.getBrakeChoose());
        Components componentFootrest = dataComponents.getComponent(request.getFootrestChoose());

        wComponentsDB.addWheelchairComponents(wheelchairDB.getWheelchair(idWheelchair), componentFrontWheel);
        wComponentsDB.addWheelchairComponents(wheelchairDB.getWheelchair(idWheelchair), componentBackWheel);
        wComponentsDB.addWheelchairComponents(wheelchairDB.getWheelchair(idWheelchair), componentBrake);
        wComponentsDB.addWheelchairComponents(wheelchairDB.getWheelchair(idWheelchair), componentFootrest);

        return response;
    }

}
