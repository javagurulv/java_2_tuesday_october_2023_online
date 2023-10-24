package fitness_club.data_vlidation;

import fitness_club.core.domain.Client;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.database.InFileDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddClientRequestValidator {
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
        InFileDatabase database = new InFileDatabase();
        List<Client> clients = database.getAllClients();
        Optional<Client> clientToCheckPersonalCode = clients.stream()
                .filter(client -> client.getPersonalCode().equals(request.getPersonalCode()))
                .findFirst();
        return clientToCheckPersonalCode.isPresent()
                ? Optional.of(new CoreError("personalCode", "Field must not be duplicated! Client with such personal code is already in database!"))
                : Optional.empty();
    }
}
