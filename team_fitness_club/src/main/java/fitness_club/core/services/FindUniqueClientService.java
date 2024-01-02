package fitness_club.core.services;

import fitness_club.core.database.ClientRepository;
import fitness_club.core.requests.FindUniqueClientRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.responses.FindUniqueClientResponse;
import fitness_club.core.services.vlidators.client.FindUniqueClientRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class FindUniqueClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private FindUniqueClientRequestValidator validator;


    public FindUniqueClientResponse execute(FindUniqueClientRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new FindUniqueClientResponse(errors);
        }
        boolean isClientFound = clientRepository.findUniqueClient(request.getPersonalCode());
        return new FindUniqueClientResponse(isClientFound);
    }
}
