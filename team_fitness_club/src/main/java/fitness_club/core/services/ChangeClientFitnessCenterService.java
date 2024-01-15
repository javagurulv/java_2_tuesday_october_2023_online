package fitness_club.core.services;

import fitness_club.core.database.MemberCardRepository;
import fitness_club.core.requests.ChangeClientFitnessCenterRequest;
import fitness_club.core.responses.ChangeClientFitnessCenterResponse;
import fitness_club.core.responses.CoreError;
import fitness_club.core.services.vlidators.fitnessCenter.ChangeClientFitnessCenterValidator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//@Component
//@Transactional
public class ChangeClientFitnessCenterService {

    @Autowired
    private MemberCardRepository memberCardRepository;
    @Autowired
    private ChangeClientFitnessCenterValidator validator;


    public ChangeClientFitnessCenterResponse execute(ChangeClientFitnessCenterRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new ChangeClientFitnessCenterResponse(errors);
        }
        boolean isClientFitnessCentreChanged = memberCardRepository.isClientFitnessCentreChangedById(request.getClientId(), request.getFitnessCenterId());
        return new ChangeClientFitnessCenterResponse(isClientFitnessCentreChanged);
    }
}
