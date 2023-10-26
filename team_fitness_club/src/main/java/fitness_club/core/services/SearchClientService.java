package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.domain.Client;
import fitness_club.core.requests.SearchClientRequest;
import fitness_club.core.responses.SearchClientResponse;
import fitness_club.data_vlidation.CoreError;
import fitness_club.data_vlidation.SearchClientRequestValidator;

import java.util.List;

public class SearchClientService {
    private Database database;
    private SearchClientRequestValidator validator;

    public SearchClientService(Database database,
                               SearchClientRequestValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public SearchClientResponse execute(SearchClientRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new SearchClientResponse(null, errors);
        }
        List<Client> foundClients = null;
        if (request.isFirstNameProvided() && !request.isLastNameProvided()) {
            foundClients = database.findByFirstName(request.getFirstName());
        }
        if (!request.isFirstNameProvided() && request.isLastNameProvided()) {
            foundClients = database.findByLastName(request.getLastName());
        }
        if (request.isFirstNameProvided() && request.isLastNameProvided()) {
            foundClients = database.findByFirstNameAndLastName(request.getFirstName(), request.getLastName());
        }
        return new SearchClientResponse(foundClients, null);
    }
}

