package lv.javaguru.java2.product.storage.accepatancetests;

import lv.javaguru.java2.product.storage.config.StorageConfiguration;
import lv.javaguru.java2.product.storage.core.domain.Category;
import lv.javaguru.java2.product.storage.core.requests.AddProductRequest;
import lv.javaguru.java2.product.storage.core.requests.RemoveProductRequest;
import lv.javaguru.java2.product.storage.core.responses.RemoveProductResponse;
import lv.javaguru.java2.product.storage.core.services.AddProductService;
import lv.javaguru.java2.product.storage.core.services.RemoveProductService;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RemoveProductAcceptanceTest {

    private ApplicationContext appContext;

    @Before
    public void setup() {
        appContext = new AnnotationConfigApplicationContext(StorageConfiguration.class);
    }

    @Test
    public void shouldReturnErrorResponseWhenProductIdNotProvided() {
        AddProductRequest addProductRequest1 = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00"), Category.PHONES);
        getAddProductService().execute(addProductRequest1);

        RemoveProductRequest removeProductRequest2 = new RemoveProductRequest(null);
        RemoveProductResponse response = getRemoveProductService().execute(removeProductRequest2);

        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "productId");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldRemoveProduct() {
        AddProductRequest addProductRequest1 = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00"), Category.PHONES);
        getAddProductService().execute(addProductRequest1);

        RemoveProductRequest removeProductRequest2 = new RemoveProductRequest(1L);
        RemoveProductResponse response = getRemoveProductService().execute(removeProductRequest2);

        assertTrue(response.isProductRemoved());
    }

    private AddProductService getAddProductService() {
        return appContext.getBean(AddProductService.class);
    }

    private RemoveProductService getRemoveProductService() {
        return appContext.getBean(RemoveProductService.class);
    }

}
