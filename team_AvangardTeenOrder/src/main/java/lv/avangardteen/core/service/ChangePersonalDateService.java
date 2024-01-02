package lv.avangardteen.core.service;

import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.request.ChangePersonalDateRequest;
import lv.avangardteen.core.responce.ChangePersonalDateResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ChangePersonalDateValidator;
import lv.avangardteen.core.database.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ChangePersonalDateService {
    @Autowired
    private Database database;

    @Autowired
    private ChangePersonalDateValidator validator;

    public ChangePersonalDateResponse execute(ChangePersonalDateRequest request) {
        List<CoreError> errors = validator.validate(request);
        return (!errors.isEmpty())
                ? new ChangePersonalDateResponse(errors)
                : getResponse(request);

    }

    private ChangePersonalDateResponse getResponse(ChangePersonalDateRequest request) {

        Client client = request.getUserRegistration();
        ChangePersonalDateResponse response = new ChangePersonalDateResponse(client);
        database.updateUser(request.getId(), request.getUserRegistration());
        return response;
    }
}
