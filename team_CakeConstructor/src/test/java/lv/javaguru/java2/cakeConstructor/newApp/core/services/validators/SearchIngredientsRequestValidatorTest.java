package lv.javaguru.java2.cakeConstructor.newApp.core.services.validators;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.Ordering;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.Paging;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.SearchIngredientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class SearchIngredientsRequestValidatorTest {

    private SearchIngredientsRequestFieldValidator fieldValidator;
    private OrderingValidator orderingValidator;
    private PagingValidator pagingValidator;
    private SearchIngredientsRequestValidator validator;

    @Before
    public void init() {
        fieldValidator = Mockito.mock(SearchIngredientsRequestFieldValidator.class);
        orderingValidator = Mockito.mock(OrderingValidator.class);
        pagingValidator = Mockito.mock(PagingValidator.class);
        validator = new SearchIngredientsRequestValidator(fieldValidator, orderingValidator, pagingValidator);
    }

    @Test
    public void shouldNotReturnErrorsWhenFieldValidatorReturnNoErrors() {
        SearchIngredientsRequest request = new SearchIngredientsRequest("Biscuit", null);
        when(fieldValidator.validate(request)).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorsWhenFieldValidatorReturnErrors() {
        SearchIngredientsRequest request = new SearchIngredientsRequest(null, "Vanilla");
        CoreError error = new CoreError("type", "Must not be empty!");
        when(fieldValidator.validate(request)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "type");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldNotReturnErrorsWhenOrderingValidatorReturnNoErrors() {
        Ordering ordering = new Ordering("type", "ASCENDING");
        SearchIngredientsRequest request = new SearchIngredientsRequest("Biscuit", "Vanilla", ordering);
        when(orderingValidator.validate(ordering)).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorsWhenOrderingValidatorReturnErrors() {
        Ordering ordering = new Ordering(null, "ASCENDING");
        SearchIngredientsRequest request = new SearchIngredientsRequest("Biscuit", "Vanilla", ordering);
        CoreError error = new CoreError("orderBy", "Must not be empty!");
        when(orderingValidator.validate(ordering)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "orderBy");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldNotInvokeOrderingValidatorWhenNoOrderingObjectPresentInRequest() {
        SearchIngredientsRequest request = new SearchIngredientsRequest("Biscuit", "Vanilla");
        validator.validate(request);
        verifyNoMoreInteractions(orderingValidator);
    }
    @Test
    public void shouldNotReturnErrorsWhenPagingValidatorReturnNoErrors() {
        Paging paging = new Paging(7, 7);
        SearchIngredientsRequest request = new SearchIngredientsRequest("Biscuit", "Vanilla", paging);
        when(pagingValidator.validate(paging)).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorsWhenPagingValidatorReturnErrors() {
        Paging paging = new Paging(null, 7);
        SearchIngredientsRequest request = new SearchIngredientsRequest("Biscuit", "Vanilla", paging);
        CoreError error = new CoreError("pageNumber", "Must not be empty!");
        when(pagingValidator.validate(paging)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "pageNumber");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldNotInvokePagingValidatorWhenNoPagingObjectPresentInRequest() {
        SearchIngredientsRequest request = new SearchIngredientsRequest("Biscuit", "Vanilla");
        validator.validate(request);
        verifyNoMoreInteractions(pagingValidator);
    }
}