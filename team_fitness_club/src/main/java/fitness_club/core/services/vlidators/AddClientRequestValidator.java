package fitness_club.core.services.vlidators;

import fitness_club.core.database.ClientRepository;
import fitness_club.core.domain.Client;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.responses.CoreError;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class AddClientRequestValidator {
   @Autowired
    private ClientRepository clientRepository;

    public List<CoreError> validate(AddClientRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateFirstName(request).ifPresent(errors::add);
        validateLastName(request).ifPresent(errors::add);
        validatePersonalCodeNotEmpty(request).ifPresent(errors::add);
        validatePersonalCodeNotDuplicate(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateFirstName(AddClientRequest request) {
        return request.getFirstName() == null || request.getFirstName().isEmpty() || !request.getFirstName().matches("[a-zA-Z]+")
                ? Optional.of(new CoreError("firstName", "Field first name must not be empty or contain symbols or numbers!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateLastName(AddClientRequest request) {
        return request.getLastName() == null || request.getLastName().isEmpty() || !request.getLastName().matches("[a-zA-Z]+")
                ? Optional.of(new CoreError("lastName", "Field last name must not be empty or contain symbols or numbers!"))
                : Optional.empty();
    }

    private Optional<CoreError> validatePersonalCodeNotEmpty(AddClientRequest request) {
        return request.getPersonalCode() == null || request.getPersonalCode().isEmpty()
                ? Optional.of(new CoreError("personalCode", "Field personal code must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validatePersonalCodeNotDuplicate(AddClientRequest request) {
        List<Client> clients = clientRepository.findByPersonalCode(request.getPersonalCode());
        return (!clients.isEmpty())
                ? Optional.of(new CoreError("uniqueClient", "Field must not be duplicated! Client with such personal code is already in database!"))
                : Optional.empty();
    }
}
