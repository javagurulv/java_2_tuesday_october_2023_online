package fitness_club.core.services;

import fitness_club.core.database.ClientRepository;
import fitness_club.core.database.MemberCardRepository;
import fitness_club.core.requests.ChangeClientWorkoutRequest;
import fitness_club.core.responses.ChangeClientWorkoutResponse;
import fitness_club.core.responses.CoreError;
import fitness_club.core.services.vlidators.workout.ChangeClientWorkoutsValidator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//@Component
//@Transactional
public class ChangeClientWorkoutService {

    @Autowired
    private MemberCardRepository memberCardRepository;
    @Autowired
    private ChangeClientWorkoutsValidator validator;

    public ChangeClientWorkoutResponse execute(ChangeClientWorkoutRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new ChangeClientWorkoutResponse(errors);
        }
        boolean isClientWorkoutChanged = memberCardRepository.isClientWorkoutsChangedById(request.getClientId(), request.getWorkoutId());
        return new ChangeClientWorkoutResponse(isClientWorkoutChanged);
    }
}
