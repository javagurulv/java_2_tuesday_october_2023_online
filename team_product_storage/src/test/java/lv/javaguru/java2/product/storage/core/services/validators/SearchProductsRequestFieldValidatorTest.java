package lv.javaguru.java2.product.storage.core.services.validators;

import java.util.List;

import lv.javaguru.java2.product.storage.core.requests.SearchProductsRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchProductsRequestFieldValidatorTest {

    private SearchProductsRequestFieldValidator validator = new SearchProductsRequestFieldValidator();

    @Test
    public void shouldNotReturnErrorsWhenProductBrandIsProvided() {
        SearchProductsRequest request = new SearchProductsRequest("Apple", null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldNotReturnErrorsWhenProductModelIsProvided() {
        SearchProductsRequest request = new SearchProductsRequest(null, "iPhone 15");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldNotReturnErrorsWhenProductBrandAndProductModelIsProvided() {
        SearchProductsRequest request = new SearchProductsRequest("Apple", "iPhone 15");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorWhenSearchFieldsAreEmpty() {
        SearchProductsRequest request = new SearchProductsRequest(null, null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 2);
        assertEquals(errors.get(0).getField(), "productBrand");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
        assertEquals(errors.get(1).getField(), "productModel");
        assertEquals(errors.get(1).getMessage(), "Must not be empty!");
    }
}