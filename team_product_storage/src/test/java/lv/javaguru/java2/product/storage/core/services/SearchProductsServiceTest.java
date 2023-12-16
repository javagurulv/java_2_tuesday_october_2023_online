package lv.javaguru.java2.product.storage.core.services;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import lv.javaguru.java2.product.storage.core.database.ProductRepository;
import lv.javaguru.java2.product.storage.core.domain.Product;
import lv.javaguru.java2.product.storage.core.requests.SearchProductsRequest;
import lv.javaguru.java2.product.storage.core.requests.Ordering;
import lv.javaguru.java2.product.storage.core.requests.Paging;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.responses.SearchProductsResponse;
import lv.javaguru.java2.product.storage.core.services.validators.SearchProductsRequestValidator;


@RunWith(MockitoJUnitRunner.class)
public class SearchProductsServiceTest {

    @Mock private ProductRepository productRepository;
    @Mock private SearchProductsRequestValidator validator;
    @InjectMocks
    private SearchProductsService service;

    @Before
    public void setup() {
        ReflectionTestUtils.setField(service, "orderingEnabled", true);
        ReflectionTestUtils.setField(service, "pagingEnabled", true);
    }

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
        Mockito.verifyNoInteractions(productRepository);
    }

    @Test
    public void shouldSearchByProductBrand() {
        SearchProductsRequest request = new SearchProductsRequest("Apple", null);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Product> products = new ArrayList<>();
        products.add(new Product("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00")));
        Mockito.when(productRepository.findByProductBrand("Apple")).thenReturn(products);

        SearchProductsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getProducts().size(), 1);
        assertEquals(response.getProducts().get(0).getProductName(), "Smartphone");
        assertEquals(response.getProducts().get(0).getProductBrand(), "Apple");
        assertEquals(response.getProducts().get(0).getProductModel(), "iPhone 15");
        assertEquals(response.getProducts().get(0).getProductQuantity(), Integer.valueOf(1));
        assertEquals(response.getProducts().get(0).getPriceInStock(), new BigDecimal("1000.00"));

    }

    @Test
    public void shouldSearchByProductModel() {
        SearchProductsRequest request = new SearchProductsRequest(null, "iPhone 15");
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Product> products = new ArrayList<>();
        products.add(new Product("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00")));
        Mockito.when(productRepository.findByProductModel("iPhone 15")).thenReturn(products);

        SearchProductsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getProducts().size(), 1);
        assertEquals(response.getProducts().get(0).getProductName(), "Smartphone");
        assertEquals(response.getProducts().get(0).getProductBrand(), "Apple");
        assertEquals(response.getProducts().get(0).getProductModel(), "iPhone 15");
        assertEquals(response.getProducts().get(0).getProductQuantity(), Integer.valueOf(1));
        assertEquals(response.getProducts().get(0).getPriceInStock(), new BigDecimal("1000.00"));

    }

    @Test
    public void shouldSearchByProductBrandAndProductModel() {
        SearchProductsRequest request = new SearchProductsRequest("Apple", "iPhone 15");
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Product> products = new ArrayList<>();
        products.add(new Product("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00")));
        Mockito.when(productRepository.findByProductBrandAndProductModel("Apple", "iPhone 15")).thenReturn(products);

        SearchProductsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getProducts().size(), 1);
        assertEquals(response.getProducts().get(0).getProductName(), "Smartphone");
        assertEquals(response.getProducts().get(0).getProductBrand(), "Apple");
        assertEquals(response.getProducts().get(0).getProductModel(), "iPhone 15");
        assertEquals(response.getProducts().get(0).getProductQuantity(), Integer.valueOf(1));
        assertEquals(response.getProducts().get(0).getPriceInStock(), new BigDecimal("1000.00"));

    }

    @Test
    public void shouldSearchByProductBrandWithOrderingAscending() {
        Ordering ordering = new Ordering("productModel", "ASCENDING");
        SearchProductsRequest request = new SearchProductsRequest("Apple", null, ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Product> products = new ArrayList<>();
        products.add(new Product("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00")));
        products.add(new Product("Smartphone", "Apple", "iPhone 14", 1, new BigDecimal("900.00")));
        Mockito.when(productRepository.findByProductBrand("Apple")).thenReturn(products);

        SearchProductsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getProducts().size(), 2);

        assertEquals(response.getProducts().get(0).getProductName(), "Smartphone");
        assertEquals(response.getProducts().get(0).getProductBrand(), "Apple");
        assertEquals(response.getProducts().get(0).getProductModel(), "iPhone 14");
        assertEquals(response.getProducts().get(0).getProductQuantity(), Integer.valueOf(1));
        //assertEquals(response.getProducts().get(0).getPriceInStock(), new BigDecimal("900.00"));


        assertEquals(response.getProducts().get(0).getProductName(), "Smartphone");
        assertEquals(response.getProducts().get(0).getProductBrand(), "Apple");
        assertEquals(response.getProducts().get(1).getProductModel(), "iPhone 15");
        assertEquals(response.getProducts().get(0).getProductQuantity(), Integer.valueOf(1));
       // assertEquals(response.getProducts().get(0).getPriceInStock(), new BigDecimal("1000.00"));

    }

    @Test
    public void shouldSearchByProductBrandWithOrderingDescending() {
        Ordering ordering = new Ordering("productModel", "DESCENDING");
        SearchProductsRequest request = new SearchProductsRequest("Apple", null, ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Product> products = new ArrayList<>();
        products.add(new Product("Smartphone", "Apple", "iPhone 14", 1, new BigDecimal("900.00")));
        products.add(new Product("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00")));
        Mockito.when(productRepository.findByProductBrand("Apple")).thenReturn(products);

        SearchProductsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getProducts().size(), 2);
        assertEquals(response.getProducts().get(0).getProductName(), "Smartphone");
        assertEquals(response.getProducts().get(0).getProductBrand(), "Apple");
        assertEquals(response.getProducts().get(0).getProductModel(), "iPhone 15");
        assertEquals(response.getProducts().get(0).getProductQuantity(), Integer.valueOf(1));
        //assertEquals(response.getProducts().get(0).getPriceInStock(), new BigDecimal("1000.00"));


        assertEquals(response.getProducts().get(0).getProductName(), "Smartphone");
        assertEquals(response.getProducts().get(0).getProductBrand(), "Apple");
        assertEquals(response.getProducts().get(1).getProductModel(), "iPhone 14");
        assertEquals(response.getProducts().get(0).getProductQuantity(), Integer.valueOf(1));
        //assertEquals(response.getProducts().get(0).getPriceInStock(), new BigDecimal("900.00"));


    }

    @Test
    public void shouldSearchByProductBrandWithPagingFirstPage() {
        Paging paging = new Paging(1, 1);
        SearchProductsRequest request = new SearchProductsRequest("Apple", null, paging);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Product> products = new ArrayList<>();
        products.add(new Product("Smartphone", "Apple", "iPhone 14", 1, new BigDecimal("900.00")));
        products.add(new Product("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00")));
        Mockito.when(productRepository.findByProductBrand("Apple")).thenReturn(products);

        SearchProductsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getProducts().size(), 1);
        assertEquals(response.getProducts().get(0).getProductName(), "Smartphone");
        assertEquals(response.getProducts().get(0).getProductBrand(), "Apple");
        assertEquals(response.getProducts().get(0).getProductModel(), "iPhone 14");
        assertEquals(response.getProducts().get(0).getProductQuantity(), Integer.valueOf(1));
        assertEquals(response.getProducts().get(0).getPriceInStock(), new BigDecimal("900.00"));

    }

    @Test
    public void shouldSearchByProductBrandWithPagingSecondPage() {
        Paging paging = new Paging(2, 1);
        SearchProductsRequest request = new SearchProductsRequest("Apple", null, null, paging);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Product> products = new ArrayList<>();
        products.add(new Product("Smartphone", "Apple", "iPhone 14", 1, new BigDecimal("900.00")));
        products.add(new Product("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00")));
        Mockito.when(productRepository.findByProductBrand("Apple")).thenReturn(products);

        SearchProductsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getProducts().size(), 1);
        assertEquals(response.getProducts().get(0).getProductName(), "Smartphone");
        assertEquals(response.getProducts().get(0).getProductBrand(), "Apple");
        assertEquals(response.getProducts().get(0).getProductModel(), "iPhone 15");
        assertEquals(response.getProducts().get(0).getProductQuantity(), Integer.valueOf(1));
        assertEquals(response.getProducts().get(0).getPriceInStock(), new BigDecimal("1000.00"));

    }

}