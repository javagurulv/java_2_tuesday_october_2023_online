package lv.javaguru.java2.lessoncode.book.app.core.services.validators;

import lv.javaguru.java2.lessoncode.book.app.core.requests.Ordering;
import lv.javaguru.java2.lessoncode.book.app.core.requests.Paging;
import lv.javaguru.java2.lessoncode.book.app.core.requests.SearchBooksRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import lv.javaguru.java2.lessoncode.book.app.dependency_injection.DIComponent;
import lv.javaguru.java2.lessoncode.book.app.dependency_injection.DIDependency;

import java.util.List;

@DIComponent
public class SearchBooksRequestValidator {

    @DIDependency
    private SearchBooksRequestFieldValidator fieldValidator;
    @DIDependency private OrderingValidator orderingValidator;
    @DIDependency private PagingValidator pagingValidator;


    public List<CoreError> validate(SearchBooksRequest request) {
        List<CoreError> errors = fieldValidator.validate(request);
        validateOrderingIfPresent(request, errors);
        validatePagingIfPresent(request, errors);
        return errors;
    }

    private void validatePagingIfPresent(SearchBooksRequest request, List<CoreError> errors) {
        if (request.getPaging() != null) {
            Paging paging = request.getPaging();
            errors.addAll(pagingValidator.validate(paging));
        }
    }

    private void validateOrderingIfPresent(SearchBooksRequest request, List<CoreError> errors) {
        if (request.getOrdering() != null) {
            Ordering ordering = request.getOrdering();
            errors.addAll(orderingValidator.validate(ordering));
        }
    }
}