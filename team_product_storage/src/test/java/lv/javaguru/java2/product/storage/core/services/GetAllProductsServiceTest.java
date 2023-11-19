package lv.javaguru.java2.product.storage.core.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import lv.javaguru.java2.product.storage.core.database.Database;
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

    @Mock
    private Database database;
    @InjectMocks
    private GetAllProductsService service;

    @Test
    public void shouldGetProductsFromDb() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Smartphone", "Apple", "iPhone 15", 1));
        Mockito.when(database.getAllProducts()).thenReturn(products);

        GetAllProductsRequest request = new GetAllProductsRequest();
        GetAllProductsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getProducts().size(), 1);
        assertEquals(response.getProducts().get(0).getProductName(), "Smartphone");
        assertEquals(response.getProducts().get(0).getProductBrand(), "Apple");
        assertEquals(response.getProducts().get(0).getProductModel(), "iPhone 15");
    }


}