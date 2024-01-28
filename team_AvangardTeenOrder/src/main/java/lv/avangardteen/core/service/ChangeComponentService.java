package lv.avangardteen.core.service;
/*

import lv.avangardteen.core.database.DataComponents;
import lv.avangardteen.core.database.WComponentsDB;
import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.responce.ChangeComponentResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ChooseComponentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
@Transactional
public class ChangeComponentService {
    */
/*@Autowired
    private DataComponents dataComponents;*//*

    @Autowired
    private WComponentsDB wComponentsDB;
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

        wComponentsDB.deleteWheelchairComponents(request.getId());
        wComponentsDB.addWheelchairComponents(request.getId(), request.getWheelFrontChoose());
        wComponentsDB.addWheelchairComponents(request.getId(), request.getWheelBackChoose());
        wComponentsDB.addWheelchairComponents(request.getId(), request.getBrakeChoose());
        wComponentsDB.addWheelchairComponents(request.getId(), request.getFootrestChoose());

        return response;
    }
}
*/
