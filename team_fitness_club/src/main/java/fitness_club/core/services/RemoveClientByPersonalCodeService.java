package fitness_club.core.services;

import fitness_club.core.database.jpa.JpaClientRepository;
import fitness_club.core.requests.RemoveClientByPersonalCodeRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.responses.RemoveClientByIdResponse;
import fitness_club.core.services.validators.client.RemoveClientByIdRequestValidator;
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
    private RemoveClientByIdRequestValidator validator;

    public RemoveClientByIdResponse execute(RemoveClientByPersonalCodeRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new RemoveClientByIdResponse(errors);
        }
        clientRepository.deleteByPersonalCode(request.getPersonalCode());
        return new RemoveClientByIdResponse(true);
    }
}


