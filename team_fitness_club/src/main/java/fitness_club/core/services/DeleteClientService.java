package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.requests.RemoveClientRequest;
import fitness_club.core.responses.RemoveClientResponse;
import fitness_club.core.responses.CoreError;
import fitness_club.core.services.data_vlidation.RemoveClientRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteClientService {

    @Autowired
    private Database database;
    @Autowired
    private RemoveClientRequestValidator validator;


    public RemoveClientResponse execute(RemoveClientRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new RemoveClientResponse(errors);
        }
        boolean isClientRemoved = database.deleteClientByPersonalCode(request.getPersonalCode());
        return new RemoveClientResponse(isClientRemoved);
    }
}

