package lv.avangardteen.core.service;

import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.responce.ChangeComponentResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ChooseComponentValidator;
import lv.avangardteen.core.database.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ChangeComponentService {
    @Autowired
    private Database database;
    @Autowired
    private ChooseComponentValidator validator;

    public ChangeComponentResponse execute(ChangeComponentRequest request) {
        List<CoreError> errors = validator.validate(request);
        return (!errors.isEmpty())
                ? new ChangeComponentResponse(errors)
                : getResponse(request);

    }

    private ChangeComponentResponse getResponse(ChangeComponentRequest request) {
        WheelchairComponent wheelchairComponent = database.getWheelchairComponents(request.getId());
        ChangeComponentResponse response = new ChangeComponentResponse(wheelchairComponent);
        response.setWheelchairComponent(request.setWheelchairComponent());
        database.updateWheelchairComponents(request.getId(), request.getWheelchairComponent());


        return response;
    }
}
