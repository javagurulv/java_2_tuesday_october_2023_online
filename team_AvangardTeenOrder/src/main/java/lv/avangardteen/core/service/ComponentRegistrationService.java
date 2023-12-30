package lv.avangardteen.core.service;

import lv.avangardteen.core.database.OrmClientRepository;
import lv.avangardteen.core.database.UserSizeRepository;
import lv.avangardteen.core.database.WheelchairComponentsRepository;
import lv.avangardteen.core.database.WheelchairRepository;
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
    private OrmClientRepository clientRepository;
    @Autowired
    private UserSizeRepository userSizeRepository;
    @Autowired
    private WheelchairRepository wheelchairRepository;
    @Autowired
    private WheelchairComponentsRepository wheelchairComponentsRepository;

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
        Long idWheelchair = wheelchairRepository.getIdWheelchair();
        wheelchairComponentsRepository.addWheelchairComponents(idWheelchair, request.getWheelFrontChoose());
        wheelchairComponentsRepository.addWheelchairComponents(idWheelchair, request.getWheelBackChoose());
        wheelchairComponentsRepository.addWheelchairComponents(idWheelchair, request.getBrakeChoose());
        wheelchairComponentsRepository.addWheelchairComponents(idWheelchair, request.getFootrestChoose());
        clientRepository.setOrderId(idWheelchair);
        userSizeRepository.setOrderId(idWheelchair);
        return response;
    }

}
