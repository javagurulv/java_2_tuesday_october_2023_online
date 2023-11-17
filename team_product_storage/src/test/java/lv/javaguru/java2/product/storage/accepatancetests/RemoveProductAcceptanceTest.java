package lv.javaguru.java2.product.storage.accepatancetests;

import lv.javaguru.java2.product.storage.dependency_injection.ApplicationContext;
import lv.javaguru.java2.product.storage.core.requests.AddProductRequest;
import lv.javaguru.java2.product.storage.core.requests.RemoveProductRequest;
import lv.javaguru.java2.product.storage.core.responses.RemoveProductResponse;
import lv.javaguru.java2.product.storage.core.services.AddProductService;
import lv.javaguru.java2.product.storage.core.services.RemoveProductService;
import lv.javaguru.java2.product.storage.dependency_injection.DIApplicationContextBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RemoveProductAcceptanceTest {

    private ApplicationContext appContext =
            new DIApplicationContextBuilder().build("lv.javaguru.java2.product.storage");

    @Test
    public void shouldReturnErrorResponseWhenProductIdNotProvided() {
        AddProductRequest addProductRequest1 = new AddProductRequest("Smartphone", "Apple", "iPhone 15");
        getAddProductService().execute(addProductRequest1);

        RemoveProductRequest removeProductRequest2 = new RemoveProductRequest(null);
        RemoveProductResponse response = getRemoveProductService().execute(removeProductRequest2);

        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "productId");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldRemoveProduct() {
        AddProductRequest addProductRequest1 = new AddProductRequest("Smartphone", "Apple", "iPhone 15");
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
