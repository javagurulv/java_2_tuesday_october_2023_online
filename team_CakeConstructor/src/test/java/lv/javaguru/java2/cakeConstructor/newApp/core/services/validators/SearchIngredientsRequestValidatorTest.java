package lv.javaguru.java2.cakeConstructor.newApp.core.services.validators;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.Ordering;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.Paging;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.SearchIngredientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SearchIngredientsRequestValidatorTest {

    private SearchIngredientsRequestValidator validator = new SearchIngredientsRequestValidator();

    @Test
    public void shouldNotReturnErrorsWhenTypeIsProvided() {
        SearchIngredientsRequest request = new SearchIngredientsRequest("Biscuit", null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldNotReturnErrorsWhenTasteIsProvided() {
        SearchIngredientsRequest request = new SearchIngredientsRequest(null, "Vanilla");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldNotReturnErrorsWhenTypeAndTasteIsProvided() {
        SearchIngredientsRequest request = new SearchIngredientsRequest("Biscuit", "Vanilla");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorWhenSearchFieldsAreEmpty() {
        SearchIngredientsRequest request = new SearchIngredientsRequest(null, null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 2);
        assertEquals(errors.get(0).getField(), "type");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
        assertEquals(errors.get(1).getField(), "taste");
        assertEquals(errors.get(1).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenOrderDirectionAreEmpty() {
        Ordering ordering = new Ordering("type", null);
        SearchIngredientsRequest request = new SearchIngredientsRequest("Biscuit", "Vanilla", ordering);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "orderDirection");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenOrderByAreEmpty() {
        Ordering ordering = new Ordering(null, "ASCENDING");
        SearchIngredientsRequest request = new SearchIngredientsRequest("Biscuit", "Vanilla", ordering);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "orderBy");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenOrderByContainNotValidValue() {
        Ordering ordering = new Ordering("notValidValue", "ASCENDING");
        SearchIngredientsRequest request = new SearchIngredientsRequest("Biscuit", "Vanilla", ordering);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "orderBy");
        assertEquals(errors.get(0).getMessage(), "Must contain 'taste' or 'type' only!");
    }

    @Test
    public void shouldReturnErrorWhenOrderDirectionContainNotValidValue() {
        Ordering ordering = new Ordering("type", "notValidValue");
        SearchIngredientsRequest request = new SearchIngredientsRequest("Biscuit", "Vanilla", ordering);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "orderDirection");
        assertEquals(errors.get(0).getMessage(), "Must contain 'ASCENDING' or 'DESCENDING' only!");
    }

    @Test
    public void shouldReturnErrorWhenPageNumberContainNotValidValue() {
        Paging paging = new Paging(0, 1);
        SearchIngredientsRequest request = new SearchIngredientsRequest("Biscuit", "Vanilla", paging);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "pageNumber");
        assertEquals(errors.get(0).getMessage(), "Must be greater then 0!");
    }

    @Test
    public void shouldReturnErrorWhenPageSizeContainNotValidValue() {
        Paging paging = new Paging(1, 0);
        SearchIngredientsRequest request = new SearchIngredientsRequest("Biscuit", "Vanilla", paging);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "pageSize");
        assertEquals(errors.get(0).getMessage(), "Must be greater then 0!");
    }

    @Test
    public void shouldReturnErrorWhenPageNumberAreEmpty() {
        Paging paging = new Paging(null, 1);
        SearchIngredientsRequest request = new SearchIngredientsRequest("Biscuit", "Vanilla", paging);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "pageNumber");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenPageSizeAreEmpty() {
        Paging paging = new Paging(1, null);
        SearchIngredientsRequest request = new SearchIngredientsRequest("Biscuit", "Vanilla", paging);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "pageSize");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

}