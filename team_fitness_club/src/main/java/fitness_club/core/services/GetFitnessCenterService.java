package fitness_club.core.services;

import fitness_club.core.database.FitnessCenterRepository;
import fitness_club.core.requests.GetFitnessCenterRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.responses.GetFitnessCenterResponse;
import fitness_club.core.services.validators.fitnessCenter.GetFitnessCenterRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetFitnessCenterService {

    @Autowired
    private FitnessCenterRepository fitnessCentersRepository;

    @Autowired
    private GetFitnessCenterRequestValidator validator;

    public GetFitnessCenterResponse execute(GetFitnessCenterRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new GetFitnessCenterResponse();
        }
        return fitnessCentersRepository.getById(request.getId())
                .map(GetFitnessCenterResponse::new)
                .orElseGet(() -> {
                    errors.add(new CoreError("id", "Not found!"));
                    return new GetFitnessCenterResponse(errors);
                });
    }
}
