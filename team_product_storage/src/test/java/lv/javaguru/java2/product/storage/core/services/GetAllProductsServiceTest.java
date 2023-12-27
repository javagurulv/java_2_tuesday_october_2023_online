package lv.javaguru.java2.product.storage.core.services;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lv.javaguru.java2.product.storage.core.database.ProductRepository;
import lv.javaguru.java2.product.storage.core.domain.Product;
import lv.javaguru.java2.product.storage.core.requests.GetAllProductsRequest;
import lv.javaguru.java2.product.storage.core.responses.GetAllProductsResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GetAllProductsServiceTest {

    @Mock private ProductRepository productRepository;
    @InjectMocks
    private GetAllProductsService service;

    @Test
    public void shouldGetProductsFromDb() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00")));
        Mockito.when(productRepository.getAllProducts()).thenReturn(products);

        GetAllProductsRequest request = new GetAllProductsRequest();
        GetAllProductsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getProducts().size(), 1);
        assertEquals(response.getProducts().get(0).getProductName(), "Smartphone");
        assertEquals(response.getProducts().get(0).getProductBrand(), "Apple");
        assertEquals(response.getProducts().get(0).getProductModel(), "iPhone 15");
        assertEquals(response.getProducts().get(0).getProductQuantity(), Integer.valueOf(1));
        assertEquals(response.getProducts().get(0).getPriceInStock(), new BigDecimal("1000.00"));



    }


}