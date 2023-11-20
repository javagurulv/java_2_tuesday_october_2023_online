package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.requests.ChangeClientFitnessCentreRequest;
import fitness_club.core.responses.ChangeClientFitnessCentreResponse;
import fitness_club.data_vlidation.ChangeClientFitnessCentreValidator;
import fitness_club.data_vlidation.CoreError;
import fitness_club.dependency_injection.DIComponent;
import fitness_club.dependency_injection.DIDependency;

import java.util.List;

@DIComponent
public class ChangeClientFitnessCentreService {


    @DIDependency private Database database;
    @DIDependency private ChangeClientFitnessCentreValidator validator;

    public ChangeClientFitnessCentreResponse execute(ChangeClientFitnessCentreRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new ChangeClientFitnessCentreResponse(errors);
        }
        boolean isClientFitnessCentreChanged = database.isClientFitnessCentreChangedByPersonalCode(request.getPersonalCode(), request.getFitnessCentre());
        return new ChangeClientFitnessCentreResponse(isClientFitnessCentreChanged);
    }
}
