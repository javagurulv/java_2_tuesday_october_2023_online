package lv.javaguru.java2.lessoncode.book.app.core.services.validators;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lv.javaguru.java2.lessoncode.book.app.core.requests.Ordering;
import lv.javaguru.java2.lessoncode.book.app.core.requests.Paging;
import lv.javaguru.java2.lessoncode.book.app.core.requests.SearchBooksRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class SearchBooksRequestValidator {

    @Autowired private SearchBooksRequestFieldValidator fieldValidator;
    @Autowired private OrderingValidator orderingValidator;
    @Autowired private PagingValidator pagingValidator;


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