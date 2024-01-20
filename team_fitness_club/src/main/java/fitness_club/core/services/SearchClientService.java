package fitness_club.core.services;

import fitness_club.core.database.jpa.JpaClientRepository;
import fitness_club.core.domain.Client;
import fitness_club.core.requests.Ordering;
import fitness_club.core.requests.Paging;
import fitness_club.core.requests.SearchClientRequest;
import fitness_club.core.responses.SearchClientResponse;
import fitness_club.core.responses.CoreError;
import fitness_club.core.services.validators.client.SearchClientRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class SearchClientService {
    @Value("${search.ordering.enabled}")
    private boolean orderingEnabled;

    @Value("${search.paging.enabled}")
    private boolean pagingEnabled;

    @Autowired
    private JpaClientRepository clientRepository;
    @Autowired
    private SearchClientRequestValidator validator;

    public SearchClientResponse execute(SearchClientRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new SearchClientResponse(null, errors);
        }

        List<Client> foundClients = search(request);
        foundClients = order(foundClients, request.getOrdering());
        foundClients = paging(foundClients, request.getPaging());

        return new SearchClientResponse(foundClients, null);
    }

    private List<Client> search(SearchClientRequest request) {
        List<Client> foundClients = new ArrayList<>();
        if (request.isFirstNameProvided() && !request.isLastNameProvided()) {
            foundClients = clientRepository.findByFirstName(request.getFirstName());
        }
        if (!request.isFirstNameProvided() && request.isLastNameProvided()) {
            foundClients = clientRepository.findByFirstName(request.getLastName());
        }
        if (request.isFirstNameProvided() && request.isLastNameProvided()) {
            foundClients = clientRepository.findByFirstNameAndLastNameLike(request.getFirstName(), request.getLastName());
        }
        if (request.isPersonalCodeProvided()) {
            foundClients = clientRepository.findByPersonalCodeLike(request.getPersonaCode());
        }
        return foundClients;
    }

    private List<Client> order(List<Client> foundClients, Ordering ordering) {
        if (orderingEnabled && (ordering != null)) {
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


   private List<Client> paging(List<Client> clients, Paging paging) {
        if (pagingEnabled && (paging != null)) {
            int skip = (paging.getPageNumber() - 1) * paging.getPageSize();
            return clients.stream()
                    .skip(skip)
                    .limit(paging.getPageSize())
                    .collect(Collectors.toList());
        } else {
            return clients;
        }
    }
}

