package lv.javaguru.java2.product.storage.accepatancetests;

import lv.javaguru.java2.product.storage.dependency_injection.ApplicationContext;
import lv.javaguru.java2.product.storage.core.requests.AddProductRequest;
import lv.javaguru.java2.product.storage.core.requests.SearchProductsRequest;
import lv.javaguru.java2.product.storage.core.responses.AddProductResponse;
import lv.javaguru.java2.product.storage.core.responses.SearchProductsResponse;
import lv.javaguru.java2.product.storage.core.services.AddProductService;
import lv.javaguru.java2.product.storage.core.services.SearchProductsService;
import lv.javaguru.java2.product.storage.dependency_injection.DIApplicationContextBuilder;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

public class AddProductAcceptanceTest {

    private ApplicationContext appContext =
            new DIApplicationContextBuilder().build("lv.javaguru.java2.product.storage");

    @Test
    public void shouldReturnErrorWhenProductNameNotProvided() {
        AddProductRequest addProductRequest1 = new AddProductRequest(null, "Apple", "iPhone 15", 1);
        getAddProductService().execute(addProductRequest1);

        AddProductResponse response = getAddProductService().execute(addProductRequest1);

        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "productName");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenProductBrandNotProvided() {
        AddProductRequest addProductRequest1 = new AddProductRequest("Smartphone", null, "iPhone 15", 1);
        getAddProductService().execute(addProductRequest1);

        AddProductResponse response = getAddProductService().execute(addProductRequest1);

        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "productBrand");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenProductModelNotProvided() {
        AddProductRequest addProductRequest1 = new AddProductRequest("Smartphone", "Apple", null, 1);
        getAddProductService().execute(addProductRequest1);

        AddProductResponse response = getAddProductService().execute(addProductRequest1);

        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "productModel");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenProductQuantityIsNull() {
        AddProductRequest addProductRequest1 = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 0);
        getAddProductService().execute(addProductRequest1);

        AddProductResponse response = getAddProductService().execute(addProductRequest1);

        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "productQuantity");
        assertEquals(response.getErrors().get(0).getMessage(), "Must be greater than 0!");
    }
    @Test
    public void shouldReturnProduct() {
        AddProductRequest addProductRequest1 = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 1);
        getAddProductService().execute(addProductRequest1);

        SearchProductsRequest searchProductsRequest2 = new SearchProductsRequest("Apple", null);
        SearchProductsResponse response = getSearchProductsService().execute(searchProductsRequest2);

        assertEquals(response.getProducts().size(), 1);
        assertEquals(response.getProducts().get(0).getProductBrand(), "Apple");
        assertEquals(response.getProducts().get(0).getProductModel(), "iPhone 15");
    }

    private AddProductService getAddProductService() { return appContext.getBean(AddProductService.class); }

    private SearchProductsService getSearchProductsService() { return appContext.getBean(SearchProductsService.class); }

}

