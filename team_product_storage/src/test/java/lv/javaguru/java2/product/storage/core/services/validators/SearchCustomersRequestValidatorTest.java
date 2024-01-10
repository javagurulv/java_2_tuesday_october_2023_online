package lv.javaguru.java2.product.storage.core.services.validators;

import lv.javaguru.java2.product.storage.core.requests.Ordering;
import lv.javaguru.java2.product.storage.core.requests.Paging;
import lv.javaguru.java2.product.storage.core.requests.SearchCustomersRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SearchCustomersRequestValidatorTest {

    @Mock private SearchCustomersRequestFieldValidator fieldValidator;
    @Mock private OrderingValidator orderingValidator;
    @Mock private PagingValidator pagingValidator;
    @InjectMocks private SearchCustomersRequestValidator validator;


    @Test
    public void shouldNotReturnErrorsWhenFieldValidatorReturnNoErrors() {
        SearchCustomersRequest request = new SearchCustomersRequest("Store Akropole Alfa", null);
        when(fieldValidator.validate(request)).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorsWhenFieldValidatorReturnErrors() {
        SearchCustomersRequest request = new SearchCustomersRequest(null, "123456A");
        CoreError error = new CoreError("customerName", "Must not be empty!");
        when(fieldValidator.validate(request)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "customerName");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldNotReturnErrorsWhenOrderingValidatorReturnNoErrors() {
        Ordering ordering = new Ordering("customerName", "ASCENDING");
        SearchCustomersRequest request = new SearchCustomersRequest("Store Akropole Alfa", "123456A", ordering);
        when(orderingValidator.validate(ordering)).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorsWhenOrderingValidatorReturnErrorsOrderByIsEmptyV1() {
        Ordering ordering = new Ordering(null, "ASCENDING");
        SearchCustomersRequest request = new SearchCustomersRequest("Store Akropole Alfa", "123456A", ordering);
        CoreError error = new CoreError("orderBy", "Must not be empty!");
        when(orderingValidator.validate(ordering)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "orderBy");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorsWhenOrderingValidatorReturnErrorsOrderDirectionIsEmptyV2() {
        Ordering ordering = new Ordering("productName", null);
        SearchCustomersRequest request = new SearchCustomersRequest("Store Akropole Alfa", "123456A", ordering);
        CoreError error = new CoreError("orderDirection", "Must not be empty!");
        when(orderingValidator.validate(ordering)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "orderDirection");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorsWhenOrderingValidatorReturnErrorsOrderByContainsNotValidValueV3() {
        Ordering ordering = new Ordering("notValidValue", "ASCENDING");
        SearchCustomersRequest request = new SearchCustomersRequest("Store Akropole Alfa", "123456A", ordering);
        CoreError error = new CoreError("orderBy", "Must contain 'customerName' or 'registrationNumber' only!");
        when(orderingValidator.validate(ordering)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "orderBy");
        assertEquals(errors.get(0).getMessage(), "Must contain 'customerName' or 'registrationNumber' only!");
    }

    @Test
    public void shouldReturnErrorsWhenOrderingValidatorReturnErrorsOrderDirectionContainsNotValidValueV4() {
        Ordering ordering = new Ordering("customerName", "notValidValue");
        SearchCustomersRequest request = new SearchCustomersRequest("Store Akropole Alfa", "123456A", ordering);
        CoreError error = new CoreError("orderDirection", "Must contain 'ASCENDING' or 'DESCENDING' only!");
        when(orderingValidator.validate(ordering)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "orderDirection");
        assertEquals(errors.get(0).getMessage(), "Must contain 'ASCENDING' or 'DESCENDING' only!");
    }

    @Test
    public void shouldNotInvokeOrderingValidatorWhenNoOrderingObjectPresentInRequest() {
        SearchCustomersRequest request = new SearchCustomersRequest("Store Akropole Alfa", "123456A");
        validator.validate(request);
        verifyNoMoreInteractions(orderingValidator);
    }

    @Test
    public void shouldNotReturnErrorsWhenPagingValidatorReturnNoErrors() {
        Paging paging = new Paging(5, 5);
        SearchCustomersRequest request = new SearchCustomersRequest("Store Akropole Alfa", "123456A", paging);
        when(pagingValidator.validate(paging)).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorsWhenPagingValidatorReturnErrorsPageNumberIsEmptyV1() {
        Paging paging = new Paging(null, 5);
        SearchCustomersRequest request = new SearchCustomersRequest("Store Akropole Alfa", "123456A", paging);
        CoreError error = new CoreError("pageNumber", "Must not be empty!");
        when(pagingValidator.validate(paging)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "pageNumber");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorsWhenPagingValidatorReturnErrorsPageSizeIsEmptyV2() {
        Paging paging = new Paging(5, null);
        SearchCustomersRequest request = new SearchCustomersRequest("Store Akropole Alfa", "123456A", paging);
        CoreError error = new CoreError("pageSize", "Must not be empty!");
        when(pagingValidator.validate(paging)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "pageSize");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorsWhenPagingValidatorReturnErrorsPageNumberIsZeroV3() {
        Paging paging = new Paging(0, 5);
        SearchCustomersRequest request = new SearchCustomersRequest("Store Akropole Alfa", "123456A", paging);
        CoreError error = new CoreError("pageNumber", "Must be greater then 0!");
        when(pagingValidator.validate(paging)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "pageNumber");
        assertEquals(errors.get(0).getMessage(), "Must be greater then 0!");
    }

    @Test
    public void shouldReturnErrorsWhenPagingValidatorReturnErrorsPageSizeIsZeroV4() {
        Paging paging = new Paging(5, 0);
        SearchCustomersRequest request = new SearchCustomersRequest("Store Akropole Alfa", "123456A", paging);
        CoreError error = new CoreError("pageSize", "Must be greater then 0!");
        when(pagingValidator.validate(paging)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "pageSize");
        assertEquals(errors.get(0).getMessage(), "Must be greater then 0!");
    }

    @Test
    public void shouldNotInvokePagingValidatorWhenNoPagingObjectPresentInRequest() {
        SearchCustomersRequest request = new SearchCustomersRequest("Store Akropole Alfa", "123456A");
        validator.validate(request);
        verifyNoMoreInteractions(pagingValidator);
    }
}