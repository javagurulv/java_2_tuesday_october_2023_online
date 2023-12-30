package lv.avangardteen.core.service;

import lv.avangardteen.core.database.WheelchairComponentsRepository;
import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.responce.ChangeComponentResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ChooseComponentValidator;
import lv.avangardteen.core.database.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
@Transactional
public class ChangeComponentService {
    @Autowired
    private WheelchairComponentsRepository componentsRepository;
    @Autowired
    private ChooseComponentValidator validator;

    public ChangeComponentResponse execute(ChangeComponentRequest request) {
        List<CoreError> errors = validator.validate(request);
        return (!errors.isEmpty())
                ? new ChangeComponentResponse(errors)
                : getResponse(request);

    }

    private ChangeComponentResponse getResponse(ChangeComponentRequest request) {

        ChangeComponentResponse response = new ChangeComponentResponse();

        response.setWheelFrontChoose(request.getWheelFrontChoose());
        response.setWheelBackChoose(request.getWheelBackChoose());
        response.setBrakeChoose(request.getBrakeChoose());
        response.setFootrestChoose(request.getFootrestChoose());

        componentsRepository.deleteWheelchairComponents(request.getId());
        componentsRepository.addWheelchairComponents(request.getId(), request.getWheelFrontChoose());
        componentsRepository.addWheelchairComponents(request.getId(), request.getWheelBackChoose());
        componentsRepository.addWheelchairComponents(request.getId(), request.getBrakeChoose());
        componentsRepository.addWheelchairComponents(request.getId(), request.getFootrestChoose());


        return response;
    }
}
