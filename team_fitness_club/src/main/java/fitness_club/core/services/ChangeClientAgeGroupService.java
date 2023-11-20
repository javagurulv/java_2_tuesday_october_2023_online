package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.requests.ChangeClientAgeGroupRequest;
import fitness_club.core.responses.ChangeClientAgeGroupResponse;
import fitness_club.core.services.data_vlidation.ChangeClientAgeGroupValidator;
import fitness_club.core.services.data_vlidation.CoreError;
import fitness_club.dependency_injection.DIComponent;
import fitness_club.dependency_injection.DIDependency;

import java.util.List;

@DIComponent
public class ChangeClientAgeGroupService {

    @DIDependency private Database database;
    @DIDependency private ChangeClientAgeGroupValidator validator;


    public ChangeClientAgeGroupResponse execute(ChangeClientAgeGroupRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new ChangeClientAgeGroupResponse(errors);
        }
        boolean isClientAgeGroupChanged = database.clientAgeGroupChangedByPersonalCode(request.getPersonalCode(), request.getClientAgeGroup());
        return new ChangeClientAgeGroupResponse(isClientAgeGroupChanged);
    }
}


