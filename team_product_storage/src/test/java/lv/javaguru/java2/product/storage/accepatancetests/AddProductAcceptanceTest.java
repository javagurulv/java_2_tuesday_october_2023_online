package lv.javaguru.java2.product.storage.accepatancetests;

import lv.javaguru.java2.product.storage.core.domain.Category;
import lv.javaguru.java2.product.storage.core.requests.AddProductRequest;
import lv.javaguru.java2.product.storage.core.requests.SearchProductsRequest;
import lv.javaguru.java2.product.storage.core.responses.AddProductResponse;
import lv.javaguru.java2.product.storage.core.responses.SearchProductsResponse;
import lv.javaguru.java2.product.storage.core.services.AddProductService;
import lv.javaguru.java2.product.storage.core.services.SearchProductsService;
import lv.javaguru.java2.product.storage.config.BookListConfiguration;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

public class AddProductAcceptanceTest {

    private ApplicationContext appContext;

    @Before
    public void setup() {
        appContext = new AnnotationConfigApplicationContext(BookListConfiguration.class);
    }

    @Test
    public void shouldReturnErrorWhenProductNameNotProvided() {
        AddProductRequest addProductRequest1 = new AddProductRequest(null, "Apple", "iPhone 15", 1, new BigDecimal("1000.00"), Category.PHONES);
        getAddProductService().execute(addProductRequest1);

        AddProductResponse response = getAddProductService().execute(addProductRequest1);

        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "productName");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenProductBrandNotProvided() {
        AddProductRequest addProductRequest1 = new AddProductRequest("Smartphone", null, "iPhone 15", 1, new BigDecimal("1000.00"), Category.PHONES);
        getAddProductService().execute(addProductRequest1);

        AddProductResponse response = getAddProductService().execute(addProductRequest1);

        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "productBrand");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenProductModelNotProvided() {
        AddProductRequest addProductRequest1 = new AddProductRequest("Smartphone", "Apple", null, 1, new BigDecimal("1000.00"), Category.PHONES);
        getAddProductService().execute(addProductRequest1);

        AddProductResponse response = getAddProductService().execute(addProductRequest1);

        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "productModel");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenProductQuantityIsNull() {
        AddProductRequest addProductRequest1 = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 0, new BigDecimal("1000.00"), Category.PHONES);
        getAddProductService().execute(addProductRequest1);

        AddProductResponse response = getAddProductService().execute(addProductRequest1);

        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "productQuantity");
        assertEquals(response.getErrors().get(0).getMessage(), "Must be greater than 0!");
    }

    @Test
    public void shouldReturnErrorWhenPriceInStockIsNull() {
        AddProductRequest addProductRequest1 = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("0.00"), Category.PHONES);
        getAddProductService().execute(addProductRequest1);

        AddProductResponse response = getAddProductService().execute(addProductRequest1);

        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "priceInStock");
        assertEquals(response.getErrors().get(0).getMessage(), "Must be greater than 0.01!");
    }

    @Test
    public void shouldReturnErrorWhenDuplicateBookFound() {
        AddProductRequest addProductRequest1 = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00"), Category.PHONES);
        getAddProductService().execute(addProductRequest1);
        AddProductRequest addBookRequest2 = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00"), Category.PHONES);
        getAddProductService().execute(addBookRequest2);

        AddProductResponse response = getAddProductService().execute(addBookRequest2);

        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "duplicate");
        assertEquals(response.getErrors().get(0).getMessage(), "Duplicate product not accepted!");
    }
    @Test
    public void shouldReturnProduct() {
        AddProductRequest addProductRequest1 = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00"), Category.PHONES);
        getAddProductService().execute(addProductRequest1);

        SearchProductsRequest searchProductsRequest2 = new SearchProductsRequest("Apple", null);
        SearchProductsResponse response = getSearchProductsService().execute(searchProductsRequest2);

        assertEquals(response.getProducts().size(), 1);
        assertEquals(response.getProducts().get(0).getProductName(), "Smartphone");
        assertEquals(response.getProducts().get(0).getProductBrand(), "Apple");
        assertEquals(response.getProducts().get(0).getProductModel(), "iPhone 15");
        assertEquals(response.getProducts().get(0).getProductQuantity(), Integer.valueOf(1));
        assertEquals(response.getProducts().get(0).getPriceInStock(), new BigDecimal("1000.00"));
        assertEquals(response.getProducts().get(0).getCategory(), Category.PHONES);
    }


    private AddProductService getAddProductService() { return appContext.getBean(AddProductService.class); }

    private SearchProductsService getSearchProductsService() { return appContext.getBean(SearchProductsService.class); }

}

