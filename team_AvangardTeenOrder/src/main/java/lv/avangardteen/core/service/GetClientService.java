package lv.avangardteen.core.service;

import lv.avangardteen.core.database.Database;
import lv.avangardteen.core.request.GetClientRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.responce.GetClientResponse;
import lv.avangardteen.core.service.validate.GetClientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetClientService {
    @Autowired private Database database;
    @Autowired
    private GetClientValidator validator;

    public GetClientResponse execute(GetClientRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new GetClientResponse(errors);
        }
        return database.findClientById(request.getId())
                .map(GetClientResponse::new)
                .orElseGet(() -> {
                    errors.add(new CoreError("id", "Not found!"));
                    return new GetClientResponse(errors);
                });
    }
}
