package fitness_club.core.services;

import fitness_club.core.database.jpa.JpaClientRepository;
import fitness_club.core.requests.RemoveClientByPersonalCodeRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.responses.RemoveClientByPersonalCodeResponse;
import fitness_club.core.services.validators.client.RemoveClientByPersonalCodeRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class RemoveClientByPersonalCodeService {

    @Autowired
    private JpaClientRepository clientRepository;
    @Autowired
    private RemoveClientByPersonalCodeRequestValidator validator;

    public RemoveClientByPersonalCodeResponse execute(RemoveClientByPersonalCodeRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new RemoveClientByPersonalCodeResponse(errors);
        }
        clientRepository.deleteByPersonalCode(request.getPersonalCode());
        return new RemoveClientByPersonalCodeResponse(true);
    }
}


