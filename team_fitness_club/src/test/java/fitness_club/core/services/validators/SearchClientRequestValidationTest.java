package fitness_club.core.services.validators;

import fitness_club.core.requests.Ordering;
import fitness_club.core.requests.Paging;
import fitness_club.core.requests.SearchClientsRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.services.validators.client.SearchClientsRequestFieldValidator;
import fitness_club.core.services.validators.client.SearchClientsRequestValidator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class SearchClientRequestValidationTest {

    @InjectMocks
    private SearchClientsRequestValidator validator;
    @Mock
    private SearchClientsRequestFieldValidator fieldValidator;
    @Mock
    private OrderingValidator orderingValidator;
    @Mock
    private PagingValidator pagingValidator;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldNotReturnErrorsWhenFieldValidatorReturnNoErrors() {
        SearchClientsRequest request = new SearchClientsRequest("FirstName", null);
        when(fieldValidator.validate(request)).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorsWhenFieldValidatorReturnErrors() {
        SearchClientsRequest request = new SearchClientsRequest(null, "LastName");
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
        SearchClientsRequest request = new SearchClientsRequest("FirstName", "LastName", ordering);
        when(orderingValidator.validate(ordering)).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorsWhenOrderingValidatorReturnErrors() {
        Ordering ordering = new Ordering(null, "ASCENDING");
        SearchClientsRequest request = new SearchClientsRequest("FirstName", "LastName", ordering);
        CoreError error = new CoreError("orderBy", "Must not be empty!");
        when(orderingValidator.validate(ordering)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "orderBy");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldNotInvokeOrderingValidatorWhenNoOrderingObjectPresentInRequest() {
        SearchClientsRequest request = new SearchClientsRequest("FirstName", "LastName");
        validator.validate(request);
        verifyNoMoreInteractions(orderingValidator);
    }

    @Test
    public void shouldNotReturnErrorsWhenPagingValidatorReturnNoErrors() {
        Paging paging = new Paging(5, 5);
        SearchClientsRequest request = new SearchClientsRequest("FirstName", "LastName", paging);
        when(pagingValidator.validate(paging)).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorsWhenPagingValidatorReturnErrors() {
        Paging paging = new Paging(null, 5);
        SearchClientsRequest request = new SearchClientsRequest("FirstName", "LastName", paging);
        CoreError error = new CoreError("pageNumber", "Must not be empty!");
        when(pagingValidator.validate(paging)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "pageNumber");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldNotInvokePagingValidatorWhenNoPagingObjectPresentInRequest() {
        SearchClientsRequest request = new SearchClientsRequest("FirstName", "LastName");
        validator.validate(request);
        verifyNoMoreInteractions(pagingValidator);
    }
}
