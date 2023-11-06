package fitness_club.data_vlidation;

import fitness_club.core.requests.Ordering;
import fitness_club.core.requests.Paging;
import fitness_club.core.requests.SearchClientRequest;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class SearchClientRequestValidationTest {

    private SearchClientRequestFieldValidator fieldValidator;
    private OrderingValidator orderingValidator;
    private PagingValidator pagingValidator;

    private SearchClientRequestValidator validator;

    @BeforeEach
    public void init() {
        fieldValidator = Mockito.mock(SearchClientRequestFieldValidator.class);
        orderingValidator = Mockito.mock(OrderingValidator.class);
        pagingValidator = Mockito.mock(PagingValidator.class);
        validator = new SearchClientRequestValidator(fieldValidator, orderingValidator, pagingValidator);
    }

    @Test
    public void shouldNotReturnErrorsWhenFieldValidatorReturnNoErrors() {
        SearchClientRequest request = new SearchClientRequest("FirstName", null);
        when(fieldValidator.validate(request)).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorsWhenFieldValidatorReturnErrors() {
        SearchClientRequest request = new SearchClientRequest(null, "LastName");
        CoreError error = new CoreError("firstName", "Must not be empty!");
        when(fieldValidator.validate(request)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "firstName");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldNotReturnErrorsWhenOrderingValidatorReturnNoErrors() {
        Ordering ordering = new Ordering("FirstName", "ASCENDING");
        SearchClientRequest request = new SearchClientRequest("FirstName", "LastName", ordering);
        when(orderingValidator.validate(ordering)).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorsWhenOrderingValidatorReturnErrors() {
        Ordering ordering = new Ordering(null, "ASCENDING");
        SearchClientRequest request = new SearchClientRequest("FirstName", "LastName", ordering);
        CoreError error = new CoreError("orderBy", "Must not be empty!");
        when(orderingValidator.validate(ordering)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "orderBy");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldNotInvokeOrderingValidatorWhenNoOrderingObjectPresentInRequest() {
        SearchClientRequest request = new SearchClientRequest("FirstName", "LastName");
        validator.validate(request);
        verifyNoMoreInteractions(orderingValidator);
    }

    @Test
    public void shouldNotReturnErrorsWhenPagingValidatorReturnNoErrors() {
        Paging paging = new Paging(5, 5);
        SearchClientRequest request = new SearchClientRequest("FirstName", "LastName", paging);
        when(pagingValidator.validate(paging)).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorsWhenPagingValidatorReturnErrors() {
        Paging paging = new Paging(null, 5);
        SearchClientRequest request = new SearchClientRequest("FirstName", "LastName", paging);
        CoreError error = new CoreError("pageNumber", "Must not be empty!");
        when(pagingValidator.validate(paging)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "pageNumber");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldNotInvokePagingValidatorWhenNoPagingObjectPresentInRequest() {
        SearchClientRequest request = new SearchClientRequest("FirstName", "LastName");
        validator.validate(request);
        verifyNoMoreInteractions(pagingValidator);
    }
}
