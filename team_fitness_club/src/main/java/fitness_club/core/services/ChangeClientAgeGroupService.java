package fitness_club.core.services;

import fitness_club.core.database.ClientRepository;
import fitness_club.core.database.MemberCardRepository;
import fitness_club.core.requests.ChangeClientAgeGroupRequest;
import fitness_club.core.requests.ChangeClientWorkoutRequest;
import fitness_club.core.responses.ChangeClientAgeGroupResponse;
import fitness_club.core.responses.CoreError;
import fitness_club.core.services.data_vlidation.ChangeClientAgeGroupValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChangeClientAgeGroupService {

    @Autowired
    private MemberCardRepository memberCardRepository;
    @Autowired
    private ClientRepository clientRepository;
   @Autowired
   private ChangeClientAgeGroupValidator validator;

   public ChangeClientAgeGroupResponse execute(ChangeClientAgeGroupRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new ChangeClientAgeGroupResponse(errors);
        }
        boolean isClientAgeGroupChanged = memberCardRepository.isClientAgeGroupChangedByPersonalCode(getClientId(request), request.getClientAgeGroup());
        return new ChangeClientAgeGroupResponse(isClientAgeGroupChanged);
    }

    private Long getClientId(ChangeClientAgeGroupRequest request) {
        return clientRepository.getClientIdByPersonalCode(request.getPersonalCode());
    }

}


