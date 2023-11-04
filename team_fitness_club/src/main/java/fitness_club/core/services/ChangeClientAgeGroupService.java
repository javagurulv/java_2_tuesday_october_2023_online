package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.requests.ChangeClientAgeGroupRequest;
import fitness_club.core.responses.ChangeClientAgeGroupResponse;
import fitness_club.data_vlidation.ChangeClientAgeGroupValidator;
import fitness_club.data_vlidation.CoreError;

import java.util.List;

public class ChangeClientAgeGroupService {

    private Database database;

    private ChangeClientAgeGroupValidator validator;

    public ChangeClientAgeGroupService(Database database, ChangeClientAgeGroupValidator validator) {
        this.validator = validator;
        this.database = database;
    }

    public ChangeClientAgeGroupResponse execute(ChangeClientAgeGroupRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new ChangeClientAgeGroupResponse(errors);
        }
        boolean isClientAgeGroupChanged = database.clientAgeGroupChangedByPersonalCode(request.getPersonalCode());
        return new ChangeClientAgeGroupResponse(isClientAgeGroupChanged);
    }
}


