package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.requests.ChangeClientAgeGroupRequest;
import fitness_club.core.responses.ChangeClientAgeGroupResponse;
import fitness_club.core.services.data_vlidation.ChangeClientAgeGroupValidator;
import fitness_club.core.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class ChangeClientAgeGroupService {

 /*  @Autowired
   private Database database;
   @Autowired
   private ChangeClientAgeGroupValidator validator;


   public ChangeClientAgeGroupResponse execute(ChangeClientAgeGroupRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new ChangeClientAgeGroupResponse(errors);
        }
        boolean isClientAgeGroupChanged = database.clientAgeGroupChangedByPersonalCode(request.getPersonalCode(), request.getClientAgeGroup());
        return new ChangeClientAgeGroupResponse(isClientAgeGroupChanged);
    }

  */
}


