package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.requests.ChangeClientWorkoutsRequest;
import fitness_club.core.responses.ChangeClientWorkoutsResponse;
import fitness_club.core.services.data_vlidation.ChangeClientWorkoutsValidator;
import fitness_club.core.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class ChangeClientWorkoutService {

   /* @Autowired
    private Database database;
    @Autowired
    private ChangeClientWorkoutsValidator validator;

    public ChangeClientWorkoutsResponse execute(ChangeClientWorkoutsRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new ChangeClientWorkoutsResponse(errors);
        }
        boolean isClientWorkoutChanged = database.clientWorkoutsChangedByPersonalCode(request.getPersonalCode(), request.getWorkout());
        return new ChangeClientWorkoutsResponse(isClientWorkoutChanged);
    }

    */
}
