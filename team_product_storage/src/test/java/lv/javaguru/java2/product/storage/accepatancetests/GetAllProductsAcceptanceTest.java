package lv.javaguru.java2.product.storage.accepatancetests;

import lv.javaguru.java2.product.storage.config.StorageConfiguration;
import lv.javaguru.java2.product.storage.core.domain.Category;
import lv.javaguru.java2.product.storage.core.requests.AddProductRequest;
import lv.javaguru.java2.product.storage.core.requests.GetAllProductsRequest;
import lv.javaguru.java2.product.storage.core.responses.GetAllProductsResponse;
import lv.javaguru.java2.product.storage.core.services.AddProductService;
import lv.javaguru.java2.product.storage.core.services.GetAllProductsService;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class GetAllProductsAcceptanceTest {

    private ApplicationContext appContext;

    @Before
    public void setup() {
        appContext = new AnnotationConfigApplicationContext(StorageConfiguration.class);
    }

    @Test
    public void shouldReturnCorrectProductList() {
        AddProductRequest addProductRequest1 = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00"), Category.PHONES);
        getAddProductService().execute(addProductRequest1);

        AddProductRequest addProductRequest2 = new AddProductRequest("Smartphone","Apple", "iPhone 14", 1, new BigDecimal("900.00"), Category.PHONES);
        getAddProductService().execute(addProductRequest2);

        GetAllProductsRequest getAllProductsRequest3 = new GetAllProductsRequest();
        GetAllProductsResponse response = getAllProductsService().execute(getAllProductsRequest3);

        assertEquals(response.getProducts().size(), 2);
    }

    private AddProductService getAddProductService() {
        return appContext.getBean(AddProductService.class);
    }

    private GetAllProductsService getAllProductsService() {
        return appContext.getBean(GetAllProductsService.class);
    }

}

