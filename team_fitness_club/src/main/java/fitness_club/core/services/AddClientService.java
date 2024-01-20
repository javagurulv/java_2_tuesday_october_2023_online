package fitness_club.core.services;

import fitness_club.core.database.jpa.JpaClientRepository;
import fitness_club.core.domain.Client;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.responses.AddClientResponse;
import fitness_club.core.services.validators.client.AddClientRequestValidator;
import fitness_club.core.responses.CoreError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Component
@Transactional
public class AddClientService  {

    @Autowired
    private JpaClientRepository clientRepository;
    @Autowired
    private AddClientRequestValidator validator;


    public AddClientResponse execute(AddClientRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddClientResponse(errors);
        }
        Client client = new Client(
                request.getFirstName(),
                request.getLastName(),
                request.getPersonalCode());
        clientRepository.save(client);

        return new AddClientResponse(client);
    }
}
