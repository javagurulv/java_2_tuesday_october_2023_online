package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.domain.Client;
import fitness_club.core.requests.ChangeClientAgeGroupRequest;
import fitness_club.core.responses.ClientResponse;
import fitness_club.data_vlidation.ChangeClientAgeGroupValidator;
import fitness_club.data_vlidation.CoreError;

import java.util.List;

public class ChangeClientAgeGroupService {

    private Database database;

    private ChangeClientAgeGroupValidator validator;

    public ChangeClientAgeGroupService(Database database, ChangeClientAgeGroupValidator validator) {
        this.validator = validator;
        this.database = database;
    }

    public ClientResponse execute(ChangeClientAgeGroupRequest request) {
        List<CoreError> errors = validator.validate(request);
        return errors.isEmpty()
                ? changeClientAgeGroupLogic(request)
                : buildErrorResponse(errors);
    }

    private ClientResponse buildErrorResponse (List<CoreError> errors){
        return new ClientResponse(errors);
    }

    private ClientResponse changeClientAgeGroupLogic(ChangeClientAgeGroupRequest request){
        Client clientToChangeAgeGroup = new Client(request.getPersonalCode());
        List<Client> clients = database.getAllClients();
        clients.stream()
                .filter(client -> client.getPersonalCode().equals(request.getPersonalCode()))
                .findFirst()
                .ifPresent(client -> client.setClientAgeGroup(request.getClientAgeGroup()));
        database.saveClient(clients);
        return new ClientResponse(clientToChangeAgeGroup);
    }
}
