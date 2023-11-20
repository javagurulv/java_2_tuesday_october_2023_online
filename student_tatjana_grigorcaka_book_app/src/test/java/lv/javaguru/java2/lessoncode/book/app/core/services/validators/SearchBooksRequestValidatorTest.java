package lv.javaguru.java2.lessoncode.book.app.core.services.validators;

import lv.javaguru.java2.lessoncode.book.app.core.requests.Ordering;
import lv.javaguru.java2.lessoncode.book.app.core.requests.Paging;
import lv.javaguru.java2.lessoncode.book.app.core.requests.SearchBooksRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SearchBooksRequestValidatorTest {

    @Mock
    private SearchBooksRequestFieldValidator fieldValidator;
    @Mock private OrderingValidator orderingValidator;
    @Mock private PagingValidator pagingValidator;
    @InjectMocks
    private SearchBooksRequestValidator validator;

    @Test
    public void shouldNotReturnErrorsWhenFieldValidatorReturnNoErrors() {
        SearchBooksRequest request = new SearchBooksRequest("The Little Prince", null);
        when(fieldValidator.validate(request)).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorsWhenFieldValidatorReturnErrors() {
        SearchBooksRequest request = new SearchBooksRequest(null, "Antoine de Saint-Exupery");
        CoreError error = new CoreError("title", "Must not be empty!");
        when(fieldValidator.validate(request)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "title");
        assertEquals(errors.get(0).getErrorMessage(), "Must not be empty!");
    }

    @Test
    public void shouldNotReturnErrorsWhenOrderingValidatorReturnNoErrors() {
        Ordering ordering = new Ordering("title", "ASCENDING");
        SearchBooksRequest request = new SearchBooksRequest("The Little Prince", "Antoine de Saint-Exupery", ordering);
        when(orderingValidator.validate(ordering)).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorsWhenOrderingValidatorReturnErrorsOrderByIsEmptyV1() {
        Ordering ordering = new Ordering(null, "ASCENDING");
        SearchBooksRequest request = new SearchBooksRequest("The Little Prince", "Antoine de Saint-Exupery", ordering);
        CoreError error = new CoreError("orderBy", "Must not be empty!");
        when(orderingValidator.validate(ordering)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "orderBy");
        assertEquals(errors.get(0).getErrorMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorsWhenOrderingValidatorReturnErrorsOrderDirectionIsEmptyV2() {
        Ordering ordering = new Ordering("title", null);
        SearchBooksRequest request = new SearchBooksRequest("The Little Prince", "Antoine de Saint-Exupery", ordering);
        CoreError error = new CoreError("orderDirection", "Must not be empty!");
        when(orderingValidator.validate(ordering)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "orderDirection");
        assertEquals(errors.get(0).getErrorMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorsWhenOrderingValidatorReturnErrorsOrderByContainsNotValidValueV3() {
        Ordering ordering = new Ordering("notValidValue", "ASCENDING");
        SearchBooksRequest request = new SearchBooksRequest("The Little Prince", "Antoine de Saint-Exupery", ordering);
        CoreError error = new CoreError("orderBy", "Must contain 'author' or 'title' only!");
        when(orderingValidator.validate(ordering)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "orderBy");
        assertEquals(errors.get(0).getErrorMessage(), "Must contain 'author' or 'title' only!");
    }

    @Test
    public void shouldReturnErrorsWhenOrderingValidatorReturnErrorsOrderDirectionContainsNotValidValueV4() {
        Ordering ordering = new Ordering("title", "notValidValue");
        SearchBooksRequest request = new SearchBooksRequest("The Little Prince", "Antoine de Saint-Exupery", ordering);
        CoreError error = new CoreError("orderDirection", "Must contain 'ASCENDING' or 'DESCENDING' only!");
        when(orderingValidator.validate(ordering)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "orderDirection");
        assertEquals(errors.get(0).getErrorMessage(), "Must contain 'ASCENDING' or 'DESCENDING' only!");
    }

    @Test
    public void shouldNotInvokeOrderingValidatorWhenNoOrderingObjectPresentInRequest() {
        SearchBooksRequest request = new SearchBooksRequest("The Little Prince", "Antoine de Saint-Exupery");
        validator.validate(request);
        verifyNoMoreInteractions(orderingValidator);
    }

    @Test
    public void shouldNotReturnErrorsWhenPagingValidatorReturnNoErrors() {
        Paging paging = new Paging(7, 7);
        SearchBooksRequest request = new SearchBooksRequest("The Little Prince", "Antoine de Saint-Exupery", paging);
        when(pagingValidator.validate(paging)).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorsWhenPagingValidatorReturnErrorsPageNumberIsEmptyV1() {
        Paging paging = new Paging(null, 7);
        SearchBooksRequest request = new SearchBooksRequest("The Little Prince", "Antoine de Saint-Exupery", paging);
        CoreError error = new CoreError("pageNumber", "Must not be empty!");
        when(pagingValidator.validate(paging)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "pageNumber");
        assertEquals(errors.get(0).getErrorMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorsWhenPagingValidatorReturnErrorsPageSizeIsEmptyV2() {
        Paging paging = new Paging(7, null);
        SearchBooksRequest request = new SearchBooksRequest("The Little Prince", "Antoine de Saint-Exupery", paging);
        CoreError error = new CoreError("pageSize", "Must not be empty!");
        when(pagingValidator.validate(paging)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "pageSize");
        assertEquals(errors.get(0).getErrorMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorsWhenPagingValidatorReturnErrorsPageNumberIsZeroV3() {
        Paging paging = new Paging(0, 7);
        SearchBooksRequest request = new SearchBooksRequest("The Little Prince", "Antoine de Saint-Exupery", paging);
        CoreError error = new CoreError("pageNumber", "Must be greater then 0!");
        when(pagingValidator.validate(paging)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "pageNumber");
        assertEquals(errors.get(0).getErrorMessage(), "Must be greater then 0!");
    }

    @Test
    public void shouldReturnErrorsWhenPagingValidatorReturnErrorsPageSizeIsZeroV4() {
        Paging paging = new Paging(7, 0);
        SearchBooksRequest request = new SearchBooksRequest("The Little Prince", "Antoine de Saint-Exupery", paging);
        CoreError error = new CoreError("pageSize", "Must be greater then 0!");
        when(pagingValidator.validate(paging)).thenReturn(List.of(error));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "pageSize");
        assertEquals(errors.get(0).getErrorMessage(), "Must be greater then 0!");
    }

    @Test
    public void shouldNotInvokePagingValidatorWhenNoPagingObjectPresentInRequest() {
        SearchBooksRequest request = new SearchBooksRequest("The Little Prince", "Antoine de Saint-Exupery");
        validator.validate(request);
        verifyNoMoreInteractions(pagingValidator);
    }

}

