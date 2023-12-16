package lv.javaguru.java2.product.storage.accepatancetests;

import lv.javaguru.java2.product.storage.DatabaseCleaner;
import lv.javaguru.java2.product.storage.config.StorageConfiguration;
import lv.javaguru.java2.product.storage.core.requests.AddProductRequest;
import lv.javaguru.java2.product.storage.core.requests.GetAllProductsRequest;
import lv.javaguru.java2.product.storage.core.responses.GetAllProductsResponse;
import lv.javaguru.java2.product.storage.core.services.AddProductService;
import lv.javaguru.java2.product.storage.core.services.GetAllProductsService;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {StorageConfiguration.class})
@Sql({"/schema.sql"})
public class GetAllProductsAcceptanceTest {

    @Autowired private AddProductService addProductService;
    @Autowired private GetAllProductsService getAllProductsService;
    @Autowired private DatabaseCleaner databaseCleaner;

    @Before
    public void setup() {
        databaseCleaner.clean();
    }

    @Test
    public void shouldReturnCorrectProductList() {
        AddProductRequest addProductRequest1 = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00"));
        addProductService.execute(addProductRequest1);

        AddProductRequest addProductRequest2 = new AddProductRequest("Smartphone","Apple", "iPhone 14", 1, new BigDecimal("900.00"));
        addProductService.execute(addProductRequest2);

        GetAllProductsRequest getAllProductsRequest3 = new GetAllProductsRequest();
        GetAllProductsResponse response = getAllProductsService.execute(getAllProductsRequest3);

        assertEquals(response.getProducts().size(), 2);
    }


}

