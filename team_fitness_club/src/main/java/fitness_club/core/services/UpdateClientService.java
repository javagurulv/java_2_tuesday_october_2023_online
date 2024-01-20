package fitness_club.core.services;

import fitness_club.core.database.ClientRepository;

import fitness_club.core.database.jpa.JpaClientRepository;
import fitness_club.core.requests.UpdateClientRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.responses.UpdateClientResponse;
import fitness_club.core.services.validators.client.UpdateClientRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class UpdateClientService {
    @Autowired
    private JpaClientRepository clientRepository;

    @Autowired
    private UpdateClientRequestValidator validator;

    public UpdateClientResponse execute(UpdateClientRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new UpdateClientResponse();
        }
        return clientRepository.findById(request.getId())
                .map(client -> {
                    client.setFirstName(request.getNewName());
                    client.setLastName(request.getNewLastName());
                    client.setPersonalCode(request.getNewPersonalCode());
                    return new UpdateClientResponse(client);
                })
                .orElseGet(() -> {
                    errors.add(new CoreError("id", "Not found!"));
                    return new UpdateClientResponse(errors);
                });
    }
}
