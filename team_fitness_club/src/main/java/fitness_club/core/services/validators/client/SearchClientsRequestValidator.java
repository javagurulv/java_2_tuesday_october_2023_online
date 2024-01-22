package fitness_club.core.services.validators.client;

import fitness_club.core.requests.Ordering;
import fitness_club.core.requests.Paging;
import fitness_club.core.requests.SearchClientsRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.services.validators.OrderingValidator;
import fitness_club.core.services.validators.PagingValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchClientsRequestValidator {

    @Autowired private SearchClientsRequestFieldValidator fieldValidator;
    @Autowired private OrderingValidator orderingValidator;
    @Autowired private PagingValidator pagingValidator;



    public List<CoreError> validate(SearchClientsRequest request) {
        List<CoreError> errors = fieldValidator.validate(request);
        validateOrderingIfPresent(request, errors);
        validatePagingIfPresent(request, errors);
        return errors;
    }

    private void validatePagingIfPresent(SearchClientsRequest request, List<CoreError> errors) {
        if (request.getPaging() != null) {
            Paging paging = request.getPaging();
            errors.addAll(pagingValidator.validate(paging));
        }
    }

    private void validateOrderingIfPresent(SearchClientsRequest request, List<CoreError> errors) {
        if (request.getOrdering() != null) {
            Ordering ordering = request.getOrdering();
            errors.addAll(orderingValidator.validate(ordering));
        }
    }

}
