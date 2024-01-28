package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaClientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Client;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.SearchClientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.SearchClientsResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.Ordering;
import  lv.javaguru.java2.cakeConstructor.newApp.core.requests.Paging;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import  lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.SearchClientsRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class SearchClientsService {

    @Value("${search.ordering.enabled}")
    private boolean orderingEnabled;

    @Value("${search.paging.enabled}")
    private boolean pagingEnabled;

    @Autowired private JpaClientRepository clientRepository;
    @Autowired private SearchClientsRequestValidator validator;

    public SearchClientsResponse execute(SearchClientsRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new SearchClientsResponse(null, errors);
        }

        List<Client> clients = search(request);
        clients = order(clients, request.getOrdering());
        clients = paging(clients, request.getPaging());

        return new SearchClientsResponse(clients, null);
    }

    private List<Client> order (List < Client > readers, Ordering ordering){
        if (orderingEnabled && (ordering != null)) {
            Comparator<Client> comparator = ordering.getOrderBy().equals("firstName")
                    ? Comparator.comparing(Client::getFirstName)
                    : Comparator.comparing(Client::getLastName);
            if (ordering.getOrderDirection().equals("DESCENDING")) {
                comparator = comparator.reversed();
            }
            return readers.stream().sorted(comparator).collect(Collectors.toList());
        } else {
            return readers;
        }
    }

    private List<Client> search(SearchClientsRequest request) {
        List<Client> clients = new ArrayList<>();
        if (request.isFirstNameProvided() && !request.isLastNameProvided()) {
            clients = clientRepository.findByFirstNameLike(request.getFirstName());
        }
        if (!request.isFirstNameProvided() && request.isLastNameProvided()) {
            clients = clientRepository.findByLastNameLike(request.getLastName());
        }
        if (request.isFirstNameProvided() && request.isLastNameProvided()) {
            clients = clientRepository.findByFirstNameAndLastNameLike(request.getFirstName(), request.getLastName());
        }
        return clients;
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
