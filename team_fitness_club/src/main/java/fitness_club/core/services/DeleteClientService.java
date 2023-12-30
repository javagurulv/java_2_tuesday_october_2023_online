package fitness_club.core.services;

import fitness_club.core.database.ClientRepository;
import fitness_club.core.requests.RemoveClientRequest;
import fitness_club.core.responses.RemoveClientResponse;
import fitness_club.core.responses.CoreError;
import fitness_club.core.services.vlidators.RemoveClientRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private RemoveClientRequestValidator validator;


    public RemoveClientResponse execute(RemoveClientRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new RemoveClientResponse(errors);
        }
        boolean isClientRemoved = clientRepository.deleteByPersonalCode(request.getPersonalCode());
        return new RemoveClientResponse(isClientRemoved);
    }
}

