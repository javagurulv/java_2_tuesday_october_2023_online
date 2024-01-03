package fitness_club.core.services;

import fitness_club.core.database.ClientRepository;
import fitness_club.core.database.MemberCardRepository;
import fitness_club.core.requests.ChangeClientFitnessCentreRequest;
import fitness_club.core.responses.ChangeClientFitnessCentreResponse;
import fitness_club.core.responses.CoreError;
import fitness_club.core.services.vlidators.fitnessCenter.ChangeClientFitnessCentreValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Component
//@Transactional
public class ChangeClientFitnessCentreService {

    @Autowired
    private MemberCardRepository memberCardRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ChangeClientFitnessCentreValidator validator;


    public ChangeClientFitnessCentreResponse execute(ChangeClientFitnessCentreRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new ChangeClientFitnessCentreResponse(errors);
        }
        boolean isClientFitnessCentreChanged = memberCardRepository.isClientFitnessCentreChangedByPersonalCode(getClientId(request), request.getFitnessCentre());
        return new ChangeClientFitnessCentreResponse(isClientFitnessCentreChanged);
    }

    private Long getClientId(ChangeClientFitnessCentreRequest request) {
        return clientRepository.getClientIdByPersonalCode(request.getPersonalCode());
    }
}
