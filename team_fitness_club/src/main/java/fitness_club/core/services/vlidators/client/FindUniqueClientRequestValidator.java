package fitness_club.core.services.vlidators.client;

import fitness_club.core.database.ClientRepository;
import fitness_club.core.domain.Client;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.requests.FindUniqueClientRequest;
import fitness_club.core.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class FindUniqueClientRequestValidator {
    @Autowired
    private ClientRepository clientRepository;
    public List<CoreError> validate(FindUniqueClientRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validatePersonalCode(request).ifPresent(errors::add);
        validatePersonalCodeIsInDb(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validatePersonalCode(FindUniqueClientRequest request) {
        return request.getPersonalCode() == null || request.getPersonalCode().isEmpty()
                ? Optional.of(new CoreError("personalCode", "Field personal code must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validatePersonalCodeIsInDb(FindUniqueClientRequest request) {
        List<Client> clients = clientRepository.findByPersonalCode(request.getPersonalCode());
        return (!clients.isEmpty())
                ? Optional.of(new CoreError("uniqueClient", "Client with such personal code is not in database!"))
                : Optional.empty();
    }
}
