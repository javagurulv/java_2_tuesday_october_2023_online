package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.requests.ChangeClientFitnessCentreRequest;
import fitness_club.core.responses.ChangeClientFitnessCentreResponse;
import fitness_club.core.services.data_vlidation.ChangeClientFitnessCentreValidator;
import fitness_club.core.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChangeClientFitnessCentreService {


    @Autowired
    private Database database;
    @Autowired
    private ChangeClientFitnessCentreValidator validator;

    public ChangeClientFitnessCentreResponse execute(ChangeClientFitnessCentreRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new ChangeClientFitnessCentreResponse(errors);
        }
        boolean isClientFitnessCentreChanged = database.isClientFitnessCentreChangedByPersonalCode(request.getPersonalCode(), request.getFitnessCentre());
        return new ChangeClientFitnessCentreResponse(isClientFitnessCentreChanged);
    }
}
