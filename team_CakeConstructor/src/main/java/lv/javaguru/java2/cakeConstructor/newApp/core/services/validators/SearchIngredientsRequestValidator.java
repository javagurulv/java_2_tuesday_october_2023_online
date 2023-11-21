package lv.javaguru.java2.cakeConstructor.newApp.core.services.validators;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.Ordering;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.Paging;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.SearchIngredientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SearchIngredientsRequestValidator {

    private SearchIngredientsRequestFieldValidator fieldValidator;
    private OrderingValidator orderingValidator;
    private PagingValidator pagingValidator;

    public SearchIngredientsRequestValidator(SearchIngredientsRequestFieldValidator fieldValidator,
                                             OrderingValidator orderingValidator,
                                             PagingValidator pagingValidator) {
        this.fieldValidator = fieldValidator;
        this.orderingValidator = orderingValidator;
        this.pagingValidator = pagingValidator;
    }


    public List<CoreError> validate(SearchIngredientsRequest request) {
        List<CoreError> errors = fieldValidator.validate(request);
        validateOrderingIfPresent(request, errors);
        validatePagingIfPresent(request, errors);
        return errors;
    }

        private void validatePagingIfPresent (SearchIngredientsRequest request, List < CoreError > errors){
            if (request.getPaging() != null) {
                Paging paging = request.getPaging();
                errors.addAll(pagingValidator.validate(paging));
            }
        }

        private void validateOrderingIfPresent (SearchIngredientsRequest request, List < CoreError > errors){
            if (request.getOrdering() != null) {
                Ordering ordering = request.getOrdering();
                errors.addAll(orderingValidator.validate(ordering));
            }
        }

    }
