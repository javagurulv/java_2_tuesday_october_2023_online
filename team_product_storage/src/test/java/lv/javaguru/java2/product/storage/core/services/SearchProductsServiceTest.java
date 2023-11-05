package lv.javaguru.java2.product.storage.core.services;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import lv.javaguru.java2.product.storage.core.database.Database;
import lv.javaguru.java2.product.storage.core.domain.Product;
import lv.javaguru.java2.product.storage.core.requests.SearchProductsRequest;
import lv.javaguru.java2.product.storage.core.requests.Ordering;
import lv.javaguru.java2.product.storage.core.requests.Paging;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.responses.SearchProductsResponse;
import lv.javaguru.java2.product.storage.core.services.validators.SearchProductsRequestValidator;

@RunWith(MockitoJUnitRunner.class)
public class SearchProductsServiceTest {

    @Mock
    private Database database;
    @Mock private SearchProductsRequestValidator validator;
    @InjectMocks
    private SearchProductsService service;

    @Test
    public void shouldReturnResponseWithErrorsWhenValidatorFails() {
        SearchProductsRequest request = new SearchProductsRequest(null, null);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("productBrand", "Must not be empty!"));
        errors.add(new CoreError("productModel", "Must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);

        SearchProductsResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 2);

        Mockito.verify(validator).validate(request);
        Mockito.verify(validator).validate(any());
        Mockito.verifyNoInteractions(database);
    }

    @Test
    public void shouldSearchByProductBrand() {
        SearchProductsRequest request = new SearchProductsRequest("Apple", null);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Product> products = new ArrayList<>();
        products.add(new Product("Smartphone", "Apple", "iPhone 15"));
        Mockito.when(database.findByProductBrand("Apple")).thenReturn(products);

        SearchProductsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getProducts().size(), 1);
        assertEquals(response.getProducts().get(0).getProductBrand(), "Apple");
        assertEquals(response.getProducts().get(0).getProductModel(), "iPhone 15");
    }

    @Test
    public void shouldSearchByProductModel() {
        SearchProductsRequest request = new SearchProductsRequest(null, "iPhone 15");
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Product> products = new ArrayList<>();
        products.add(new Product("Smartphone", "Apple", "iPhone 15"));
        Mockito.when(database.findByProductModel("iPhone 15")).thenReturn(products);

        SearchProductsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getProducts().size(), 1);
        assertEquals(response.getProducts().get(0).getProductBrand(), "Apple");
        assertEquals(response.getProducts().get(0).getProductModel(), "iPhone 15");
    }

    @Test
    public void shouldSearchByProductNameAndProductBrandAndProductModel() {
        SearchProductsRequest request = new SearchProductsRequest("Apple", "iPhone 15");
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Product> products = new ArrayList<>();
        products.add(new Product("Smartphone", "Apple", "iPhone 15"));
        Mockito.when(database.findByProductBrandAndProductModel("Apple", "iPhone 15")).thenReturn(products);

        SearchProductsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getProducts().size(), 1);
        assertEquals(response.getProducts().get(0).getProductName(), "Smartphone");
        assertEquals(response.getProducts().get(0).getProductBrand(), "Apple");
        assertEquals(response.getProducts().get(0).getProductModel(), "iPhone 15");
    }

    @Test
    public void shouldSearchByProductBrandWithOrderingAscending() {
        Ordering ordering = new Ordering("productModel", "ASCENDING");
        SearchProductsRequest request = new SearchProductsRequest("Apple", null, ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Product> products = new ArrayList<>();
        products.add(new Product("Smartphone", "Apple", "iPhone 15"));
        products.add(new Product("Smartphone", "Apple", "iPhone 14"));
        Mockito.when(database.findByProductBrand("Apple")).thenReturn(products);

        SearchProductsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getProducts().size(), 2);
        assertEquals(response.getProducts().get(0).getProductModel(), "iPhone 14");
        assertEquals(response.getProducts().get(1).getProductModel(), "iPhone 15");
    }

    @Test
    public void shouldSearchByProductBrandWithOrderingDescending() {
        Ordering ordering = new Ordering("productModel", "DESCENDING");
        SearchProductsRequest request = new SearchProductsRequest("Apple", null, ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Product> products = new ArrayList<>();
        products.add(new Product("Smartphone", "Apple", "iPhone 14"));
        products.add(new Product("Smartphone", "Apple", "iPhone 15"));
        Mockito.when(database.findByProductBrand("Apple")).thenReturn(products);

        SearchProductsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getProducts().size(), 2);
        assertEquals(response.getProducts().get(0).getProductModel(), "iPhone 15");
        assertEquals(response.getProducts().get(1).getProductModel(), "iPhone 14");

    }

    @Test
    public void shouldSearchByProductBrandWithPagingFirstPage() {
        Paging paging = new Paging(1, 1);
        SearchProductsRequest request = new SearchProductsRequest("Apple", null, paging);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Product> products = new ArrayList<>();
        products.add(new Product("Smartphone", "Apple", "iPhone 14"));
        products.add(new Product("Smartphone", "Apple", "iPhone 15"));
        Mockito.when(database.findByProductBrand("Apple")).thenReturn(products);

        SearchProductsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getProducts().size(), 1);
        assertEquals(response.getProducts().get(0).getProductBrand(), "Apple");
        assertEquals(response.getProducts().get(0).getProductModel(), "iPhone 14");
    }

    @Test
    public void shouldSearchByProductBrandWithPagingSecondPage() {
        Paging paging = new Paging(2, 1);
        SearchProductsRequest request = new SearchProductsRequest("Apple", null, null, paging);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Product> products = new ArrayList<>();
        products.add(new Product("Smartphone", "Apple", "iPhone 14"));
        products.add(new Product("Smartphone", "Apple", "iPhone 15"));
        Mockito.when(database.findByProductBrand("Apple")).thenReturn(products);

        SearchProductsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getProducts().size(), 1);
        assertEquals(response.getProducts().get(0).getProductBrand(), "Apple");
        assertEquals(response.getProducts().get(0).getProductModel(), "iPhone 15");
    }

}