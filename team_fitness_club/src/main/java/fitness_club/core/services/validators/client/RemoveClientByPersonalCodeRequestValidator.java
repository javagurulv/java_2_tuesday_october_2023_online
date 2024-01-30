package fitness_club.core.services.validators.client;

import fitness_club.core.database.jpa.JpaClientRepository;
import fitness_club.core.domain.Client;
import fitness_club.core.requests.RemoveClientByPersonalCodeRequest;
import fitness_club.core.responses.CoreError;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@NoArgsConstructor
@Component
public class RemoveClientByPersonalCodeRequestValidator {

    @Autowired
    private JpaClientRepository clientRepository;

    public List<CoreError> validate(RemoveClientByPersonalCodeRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateClientPersonalCode(request).ifPresent(errors::add);
        validatePersonalCodeExist(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateClientPersonalCode(RemoveClientByPersonalCodeRequest request) {
        return request.getPersonalCode() == null || request.getPersonalCode().isBlank()
                ? Optional.of(new CoreError("personalCode", "Must not be empty!"))
                : Optional.empty();
    }
    private Optional<CoreError> validatePersonalCodeExist(RemoveClientByPersonalCodeRequest request) {
        List<Client> clients = clientRepository.findByPersonalCodeLike(request.getPersonalCode());
        return clients.isEmpty()
                ? Optional.of(new CoreError("personalCode", "Personal code not exist!"))
                : Optional.empty();
    }
}
