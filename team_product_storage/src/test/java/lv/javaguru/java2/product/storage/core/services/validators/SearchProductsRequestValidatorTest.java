package lv.javaguru.java2.product.storage.core.services.validators;

import lv.javaguru.java2.product.storage.core.requests.Ordering;
import lv.javaguru.java2.product.storage.core.requests.Paging;
import lv.javaguru.java2.product.storage.core.requests.SearchProductsRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;


public class SearchProductsRequestValidatorTest {

    private SearchProductsRequestFieldValidator fieldValidator;
    private OrderingValidator orderingValidator;
    private PagingValidator pagingValidator;
    private SearchProductsRequestValidator validator;


    @Before
    public void init() {
        fieldValidator = Mockito.mock(SearchProductsRequestFieldValidator.class);
        orderingValidator = Mockito.mock(OrderingValidator.class);
        pagingValidator = Mockito.mock(PagingValidator.class);
        validator = new SearchProductsRequestValidator(fieldValidator, orderingValidator, pagingValidator);
    }

    @Test
    public void shouldNotReturnErrorsWhenFieldValidatorReturnNoErrors() {
        SearchProductsRequest request = new SearchProductsRequest("Apple", null);
        when(fieldValidator.validate(request)).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorsWhenFieldValidatorReturnErrors() {
        SearchProductsRequest request = new SearchProductsRequest(null, "iPhone 15");
        CoreError error = new CoreError("productBrand", "Must not be empty!");
        when(fieldValidator.validate(request)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "productBrand");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldNotReturnErrorsWhenOrderingValidatorReturnNoErrors() {
        Ordering ordering = new Ordering("productBrand", "ASCENDING");
        SearchProductsRequest request = new SearchProductsRequest("Apple", "iPhone 15", ordering);
        when(orderingValidator.validate(ordering)).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorsWhenOrderingValidatorReturnErrorsOrderByIsEmptyV1() {
        Ordering ordering = new Ordering(null, "ASCENDING");
        SearchProductsRequest request = new SearchProductsRequest("Apple", "iPhone 15", ordering);
        CoreError error = new CoreError("orderBy", "Must not be empty!");
        when(orderingValidator.validate(ordering)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "orderBy");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorsWhenOrderingValidatorReturnErrorsOrderDirectionIsEmptyV2() {
        Ordering ordering = new Ordering("productBand", null);
        SearchProductsRequest request = new SearchProductsRequest("Apple", "iPhone 15", ordering);
        CoreError error = new CoreError("orderDirection", "Must not be empty!");
        when(orderingValidator.validate(ordering)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "orderDirection");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorsWhenOrderingValidatorReturnErrorsOrderByContainsNotValidValueV3() {
        Ordering ordering = new Ordering("notValidValue", "ASCENDING");
        SearchProductsRequest request = new SearchProductsRequest("Apple", "iPhone 15", ordering);
        CoreError error = new CoreError("orderBy", "Must contain 'productModel' or 'productBrand' only!");
        when(orderingValidator.validate(ordering)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "orderBy");
        assertEquals(errors.get(0).getMessage(), "Must contain 'productModel' or 'productBrand' only!");
    }

    @Test
    public void shouldReturnErrorsWhenOrderingValidatorReturnErrorsOrderDirectionContainsNotValidValueV4() {
        Ordering ordering = new Ordering("productBand", "notValidValue");
        SearchProductsRequest request = new SearchProductsRequest("Apple", "iPhone 15", ordering);
        CoreError error = new CoreError("orderDirection", "Must contain 'ASCENDING' or 'DESCENDING' only!");
        when(orderingValidator.validate(ordering)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "orderDirection");
        assertEquals(errors.get(0).getMessage(), "Must contain 'ASCENDING' or 'DESCENDING' only!");
    }

    @Test
    public void shouldNotInvokeOrderingValidatorWhenNoOrderingObjectPresentInRequest() {
        SearchProductsRequest request = new SearchProductsRequest("Apple", "iPhone 15");
        validator.validate(request);
        verifyNoMoreInteractions(orderingValidator);
    }

    @Test
    public void shouldNotReturnErrorsWhenPagingValidatorReturnNoErrors() {
        Paging paging = new Paging(5, 5);
        SearchProductsRequest request = new SearchProductsRequest("Apple", "iPhone 15", paging);
        when(pagingValidator.validate(paging)).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorsWhenPagingValidatorReturnErrorsPageNumberIsEmptyV1() {
        Paging paging = new Paging(null, 5);
        SearchProductsRequest request = new SearchProductsRequest("Apple", "iPhone 15", paging);
        CoreError error = new CoreError("pageNumber", "Must not be empty!");
        when(pagingValidator.validate(paging)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "pageNumber");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorsWhenPagingValidatorReturnErrorsPageSizeIsEmptyV2() {
        Paging paging = new Paging(5, null);
        SearchProductsRequest request = new SearchProductsRequest("Apple", "iPhone 15", paging);
        CoreError error = new CoreError("pageSize", "Must not be empty!");
        when(pagingValidator.validate(paging)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "pageSize");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorsWhenPagingValidatorReturnErrorsPageNumberIsNullV3() {
        Paging paging = new Paging(0, 5);
        SearchProductsRequest request = new SearchProductsRequest("Apple", "iPhone 15", paging);
        CoreError error = new CoreError("pageNumber", "Must be greater then 0!");
        when(pagingValidator.validate(paging)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "pageNumber");
        assertEquals(errors.get(0).getMessage(), "Must be greater then 0!");
    }

    @Test
    public void shouldReturnErrorsWhenPagingValidatorReturnErrorsPageSizeIsNullV4() {
        Paging paging = new Paging(5, 0);
        SearchProductsRequest request = new SearchProductsRequest("Apple", "iPhone 15", paging);
        CoreError error = new CoreError("pageSize", "Must be greater then 0!");
        when(pagingValidator.validate(paging)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "pageSize");
        assertEquals(errors.get(0).getMessage(), "Must be greater then 0!");
    }

    @Test
    public void shouldNotInvokePagingValidatorWhenNoPagingObjectPresentInRequest() {
        SearchProductsRequest request = new SearchProductsRequest("Apple", "iPhone 15");
        validator.validate(request);
        verifyNoMoreInteractions(pagingValidator);
    }

}