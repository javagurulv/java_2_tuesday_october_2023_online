package lv.avangardteen.core.service;

import lv.avangardteen.core.database.*;
import lv.avangardteen.core.domain.Components;
import lv.avangardteen.core.domain.Wheelchair;
import lv.avangardteen.core.domain.WheelchairComponents;
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

        Wheelchair wheelchair = wheelchairDB.getWheelchair(request.getId());
        wComponentsDB.deleteWheelchairComponents(request.getId());

        Components componentFrontWheel = dataComponents.getComponent(request.getWheelFrontChoose());
        Components componentBackWheel = dataComponents.getComponent(request.getWheelBackChoose());
        Components componentBrake = dataComponents.getComponent(request.getBrakeChoose());
        Components componentFootrest = dataComponents.getComponent(request.getFootrestChoose());
        WheelchairComponents wheelchairComponents1 = new WheelchairComponents();
        wheelchairComponents1.setWheelchair(wheelchair);
        wheelchairComponents1.setComponents(componentFrontWheel);
        WheelchairComponents wheelchairComponents2 = new WheelchairComponents();
        wheelchairComponents1.setWheelchair(wheelchair);
        wheelchairComponents1.setComponents(componentBackWheel);
        WheelchairComponents wheelchairComponents3 = new WheelchairComponents();
        wheelchairComponents1.setWheelchair(wheelchair);
        wheelchairComponents1.setComponents(componentBrake);
        WheelchairComponents wheelchairComponents4 = new WheelchairComponents();
        wheelchairComponents1.setWheelchair(wheelchair);
        wheelchairComponents1.setComponents(componentFootrest);
        wComponentsDB.addWheelchairComponents(wheelchairComponents1);
        wComponentsDB.addWheelchairComponents(wheelchairComponents2);
        wComponentsDB.addWheelchairComponents(wheelchairComponents3);
        wComponentsDB.addWheelchairComponents(wheelchairComponents4);

        return response;
    }

}
