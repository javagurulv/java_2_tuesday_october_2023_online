package fitness_club.core.services;

import fitness_club.core.database.ClientRepository;
import fitness_club.core.domain.Client;
import fitness_club.core.requests.RegisterClientRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.responses.RegisterClientResponse;
import fitness_club.core.services.vlidators.RegisterClientRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class RegisterClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RegisterClientRequestValidator validator;

    public RegisterClientResponse execute(RegisterClientRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new RegisterClientResponse(errors);
        }
        Client client = new Client(request.getFirstName(), request.getLastName(), request.getPersonalCode());
        clientRepository.save(client);
        return new RegisterClientResponse(client);
    }
}
