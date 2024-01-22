package fitness_club.core.services;

import fitness_club.core.database.WorkoutRepository;
import fitness_club.core.database.jpa.JpaWorkoutsRepository;
import fitness_club.core.requests.GetWorkoutRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.responses.GetWorkoutResponse;
import fitness_club.core.services.validators.workout.GetWorkoutRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetWorkoutService {

    @Autowired
    private JpaWorkoutsRepository workoutsRepository;

    @Autowired
    private GetWorkoutRequestValidator validator;

    public GetWorkoutResponse execute(GetWorkoutRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new GetWorkoutResponse();
        }
        return workoutsRepository.findById(request.getId())
                .map(GetWorkoutResponse::new)
                .orElseGet(()->{
                    errors.add(new CoreError("id", "Not found!"));
                            return new GetWorkoutResponse(errors);
                        });
    }
}
