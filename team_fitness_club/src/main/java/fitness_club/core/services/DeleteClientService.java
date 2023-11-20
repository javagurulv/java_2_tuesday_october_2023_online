package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.requests.RemoveClientRequest;
import fitness_club.core.responses.RemoveClientResponse;
import fitness_club.data_vlidation.CoreError;
import fitness_club.data_vlidation.RemoveClientRequestValidator;
import fitness_club.dependency_injection.DIComponent;
import fitness_club.dependency_injection.DIDependency;

import java.util.List;

@DIComponent
public class DeleteClientService {

    @DIDependency private Database database;
    @DIDependency private RemoveClientRequestValidator validator;


    public RemoveClientResponse execute(RemoveClientRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new RemoveClientResponse(errors);
        }
        boolean isClientRemoved = database.deleteClientByPersonalCode(request.getPersonalCode());
        return new RemoveClientResponse(isClientRemoved);
    }
}

