package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.requests.ChangeClientWorkoutsRequest;
import fitness_club.core.responses.ChangeClientWorkoutsResponse;
import fitness_club.data_vlidation.ChangeClientWorkoutsValidator;
import fitness_club.data_vlidation.CoreError;

import java.util.List;

public class ChangeClientWorkoutService {

    private Database database;

    private ChangeClientWorkoutsValidator validator;

    public ChangeClientWorkoutService(Database database, ChangeClientWorkoutsValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public ChangeClientWorkoutsResponse execute(ChangeClientWorkoutsRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new ChangeClientWorkoutsResponse(errors);
        }
        boolean isClientWorkoutChanged= database.clientWorkoutsChangedByPersonalCode(request.getPersonalCode(), request.getWorkout());
        return new ChangeClientWorkoutsResponse(isClientWorkoutChanged);
    }
}
