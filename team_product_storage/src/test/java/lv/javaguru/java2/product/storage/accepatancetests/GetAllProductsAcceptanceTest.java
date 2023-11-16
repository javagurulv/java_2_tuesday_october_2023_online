package lv.javaguru.java2.product.storage.accepatancetests;

import lv.javaguru.java2.product.storage.dependency_injection.ApplicationContext;
import lv.javaguru.java2.product.storage.core.requests.AddProductRequest;
import lv.javaguru.java2.product.storage.core.requests.GetAllProductsRequest;
import lv.javaguru.java2.product.storage.core.responses.GetAllProductsResponse;
import lv.javaguru.java2.product.storage.core.services.AddProductService;
import lv.javaguru.java2.product.storage.core.services.GetAllProductsService;
import lv.javaguru.java2.product.storage.dependency_injection.DIApplicationContextBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetAllProductsAcceptanceTest {

    private ApplicationContext appContext =
            new DIApplicationContextBuilder().build("lv.javaguru.java2.product.storage");

    @Test
    public void shouldReturnCorrectProductList() {
        AddProductRequest addProductRequest1 = new AddProductRequest("Smartphone", "Apple", "iPhone 15");
        getAddProductService().execute(addProductRequest1);

        AddProductRequest addProductRequest2 = new AddProductRequest("Smartphone","Apple", "iPhone 14");
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

