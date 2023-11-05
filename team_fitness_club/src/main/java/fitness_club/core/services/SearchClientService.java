package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.domain.Client;
import fitness_club.core.requests.Ordering;
import fitness_club.core.requests.SearchClientRequest;
import fitness_club.core.responses.SearchClientResponse;
import fitness_club.data_vlidation.CoreError;
import fitness_club.data_vlidation.SearchClientRequestValidator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

        List<Client> foundClients = search(request);
        foundClients = order(foundClients,request.getOrdering());
        foundClients = paging(foundClients, request);

        return new SearchClientResponse(foundClients, null);
    }
    private List<Client> order(List<Client> foundClients, Ordering ordering) {
        if (ordering != null) {
            Comparator<Client> comparator = ordering.getOrderBy().equals("lastName")
                    ? Comparator.comparing(Client::getLastName)
                    : Comparator.comparing(Client::getFirstName);
            if (ordering.getOrderDirection().equals("DESCENDING")) {
                comparator = comparator.reversed();
            }
            return foundClients.stream().sorted(comparator).collect(Collectors.toList());
        } else {
            return foundClients;
        }
    }

    List<Client> search(SearchClientRequest request) {
        List<Client> foundClients = new ArrayList<>();
        if (request.isFirstNameProvided() && !request.isLastNameProvided()) {
            foundClients = database.findByFirstName(request.getFirstName());
        }
        if (!request.isFirstNameProvided() && request.isLastNameProvided()) {
            foundClients = database.findByLastName(request.getLastName());
        }
        if (request.isFirstNameProvided() && request.isLastNameProvided()) {
            foundClients = database.findByFirstNameAndLastName(request.getFirstName(), request.getLastName());
        }
        if (request.isPersonalCodeProvided()) {
            foundClients = database.findByPersonalCode(request.getPersonaCode());
        }
        return foundClients;
    }

    List<Client> paging(List<Client> clients, SearchClientRequest request) {
        if (request.getPaging() != null) {
            int skip = (request.getPaging().getPageNumber() - 1) * request.getPaging().getPageSize();
            return clients.stream()
                    .skip(skip)
                    .limit(request.getPaging().getPageSize())
                    .collect(Collectors.toList());
        } else {
            return clients;
        }
    }
}

