package lv.javaguru.java2.cakeConstructor.newApp.core.services.validators;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.Ordering;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.Paging;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.SearchIngredientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import lv.javaguru.java2.cakeConstructor.newApp.dependency_injection.DIComponent;
import lv.javaguru.java2.cakeConstructor.newApp.dependency_injection.DIDependency;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DIComponent
public class SearchIngredientsRequestValidator {

    @DIDependency private SearchIngredientsRequestFieldValidator fieldValidator;
    @DIDependency private OrderingValidator orderingValidator;
    @DIDependency private PagingValidator pagingValidator;


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
