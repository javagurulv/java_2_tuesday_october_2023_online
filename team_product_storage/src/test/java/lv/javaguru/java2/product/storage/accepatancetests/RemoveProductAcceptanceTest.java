package lv.javaguru.java2.product.storage.accepatancetests;

import lv.javaguru.java2.product.storage.DatabaseCleaner;
import lv.javaguru.java2.product.storage.config.SpringCoreConfiguration;
import lv.javaguru.java2.product.storage.core.requests.AddProductRequest;
import lv.javaguru.java2.product.storage.core.requests.RemoveProductRequest;
import lv.javaguru.java2.product.storage.core.responses.RemoveProductResponse;
import lv.javaguru.java2.product.storage.core.services.AddProductService;
import lv.javaguru.java2.product.storage.core.services.RemoveProductService;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringCoreConfiguration.class})
@Sql({"/schema.sql"})
public class RemoveProductAcceptanceTest {

    @Autowired private AddProductService addProductService;
    @Autowired private RemoveProductService removeProductService;
    @Autowired private DatabaseCleaner databaseCleaner;

    @Before
    public void setup() {
        databaseCleaner.clean();
    }

    @Test
    public void shouldReturnErrorResponseWhenProductIdNotProvided() {
        AddProductRequest addProductRequest1 = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00"));
        addProductService.execute(addProductRequest1);

        RemoveProductRequest removeProductRequest2 = new RemoveProductRequest(null);
        RemoveProductResponse response = removeProductService.execute(removeProductRequest2);

        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "productId");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldRemoveProduct() {
        AddProductRequest addProductRequest1 = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00"));
        addProductService.execute(addProductRequest1);

        RemoveProductRequest removeProductRequest2 = new RemoveProductRequest(1L);
        RemoveProductResponse response = removeProductService.execute(removeProductRequest2);

        assertTrue(response.isProductRemoved());
    }


}
