package fitness_club.core.services;

import fitness_club.core.database.ClientRepository;
import fitness_club.core.database.MemberCardRepository;
import fitness_club.core.requests.ChangeClientWorkoutRequest;
import fitness_club.core.responses.ChangeClientWorkoutResponse;
import fitness_club.core.responses.CoreError;
import fitness_club.core.services.vlidators.ChangeClientWorkoutsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ChangeClientWorkoutService {

    @Autowired
    private MemberCardRepository memberCardRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ChangeClientWorkoutsValidator validator;

    public ChangeClientWorkoutResponse execute(ChangeClientWorkoutRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new ChangeClientWorkoutResponse(errors);
        }
        boolean isClientWorkoutChanged = memberCardRepository.isClientWorkoutsChangedByPersonalCode(getClientId(request), request.getWorkout());
        return new ChangeClientWorkoutResponse(isClientWorkoutChanged);
    }

    private Long getClientId(ChangeClientWorkoutRequest request) {
        return clientRepository.getClientIdByPersonalCode(request.getPersonalCode());
    }

}
