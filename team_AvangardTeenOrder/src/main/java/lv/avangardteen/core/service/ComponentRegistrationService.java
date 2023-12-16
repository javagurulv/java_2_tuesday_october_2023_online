package lv.avangardteen.core.service;

import lv.avangardteen.core.data.Database;
import lv.avangardteen.core.dto.Order;
import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.request.ComponentRegistrationRequest;
import lv.avangardteen.core.responce.ChangeComponentResponse;
import lv.avangardteen.core.responce.ComponentRegistrationResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ComponentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ComponentRegistrationService {
    @Autowired
    private Database database;

    @Autowired
    private ComponentValidator validator;

    public ComponentRegistrationResponse execute(ComponentRegistrationRequest request) {
        List<CoreError> errors = validator.validate(request.getWheelchairComponent());
        return (!errors.isEmpty())
                ? new ComponentRegistrationResponse(errors)
                : getResponse(request);

    }

    private ComponentRegistrationResponse getResponse(ComponentRegistrationRequest request) {
        ComponentRegistrationResponse response = new ComponentRegistrationResponse();
        response.setWheelchairComponent(request.getWheelchairComponent());
        database.addWheelchairComponents(request.getWheelchairComponent());

        return response;
    }

}
