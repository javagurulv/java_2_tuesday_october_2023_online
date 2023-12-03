package lv.javaguru.java2.product.storage.accepatancetests;

import lv.javaguru.java2.product.storage.config.StorageConfiguration;
import lv.javaguru.java2.product.storage.core.domain.Category;
import lv.javaguru.java2.product.storage.core.requests.AddProductRequest;
import lv.javaguru.java2.product.storage.core.requests.Ordering;
import lv.javaguru.java2.product.storage.core.requests.Paging;
import lv.javaguru.java2.product.storage.core.requests.SearchProductsRequest;
import lv.javaguru.java2.product.storage.core.responses.SearchProductsResponse;
import lv.javaguru.java2.product.storage.core.services.AddProductService;
import lv.javaguru.java2.product.storage.core.services.SearchProductsService;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class SearchProductsAcceptanceTest {

    private ApplicationContext appContext;

    @Before
    public void setup() {
        appContext = new AnnotationConfigApplicationContext(StorageConfiguration.class);
    }

    @Test
    public void searchProducts() {
        AddProductRequest request1 = new AddProductRequest("Smartphone", "Apple", "iPhone 14", 1, new BigDecimal("900.00"), Category.PHONES);
        getAddProductService().execute(request1);

        AddProductRequest request2 = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00"), Category.PHONES);
        getAddProductService().execute(request2);

        SearchProductsRequest request3 = new SearchProductsRequest("Apple", null);
        SearchProductsResponse response = getSearchProductsService().execute(request3);

        assertEquals(response.getProducts().size(), 2);
        assertEquals(response.getProducts().get(0).getProductName(), "Smartphone");
        assertEquals(response.getProducts().get(0).getProductBrand(), "Apple");
        assertEquals(response.getProducts().get(0).getProductModel(), "iPhone 14");
        assertEquals(response.getProducts().get(0).getProductQuantity(), Integer.valueOf(1));
        //assertEquals(response.getProducts().get(0).getPriceInStock(), new BigDecimal("900.00"));
        assertEquals(response.getProducts().get(0).getCategory(), Category.PHONES);

        assertEquals(response.getProducts().get(0).getProductName(), "Smartphone");
        assertEquals(response.getProducts().get(1).getProductBrand(), "Apple");
        assertEquals(response.getProducts().get(1).getProductModel(), "iPhone 15");
        assertEquals(response.getProducts().get(0).getProductQuantity(), Integer.valueOf(1));
        //assertEquals(response.getProducts().get(0).getPriceInStock(), new BigDecimal("1000.00"));
        assertEquals(response.getProducts().get(0).getCategory(), Category.PHONES);
    }

    @Test
    public void searchProductsOrderingDescending() {
        AddProductRequest request1 = new AddProductRequest("Smartphone", "Apple", "iPhone 14", 1, new BigDecimal("900.00"), Category.PHONES);
        getAddProductService().execute(request1);

        AddProductRequest request2 = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00"), Category.PHONES);
        getAddProductService().execute(request2);

        Ordering ordering = new Ordering("productModel", "DESCENDING");
        SearchProductsRequest request3 = new SearchProductsRequest("Apple", null, ordering);
        SearchProductsResponse response = getSearchProductsService().execute(request3);

        assertEquals(response.getProducts().size(), 2);
        assertEquals(response.getProducts().get(0).getProductName(), "Smartphone");
        assertEquals(response.getProducts().get(0).getProductBrand(), "Apple");
        assertEquals(response.getProducts().get(0).getProductModel(), "iPhone 15");
        assertEquals(response.getProducts().get(0).getProductQuantity(), Integer.valueOf(1));
        //assertEquals(response.getProducts().get(0).getPriceInStock(), new BigDecimal("1000.00"));
        assertEquals(response.getProducts().get(0).getCategory(), Category.PHONES);

        assertEquals(response.getProducts().get(0).getProductName(), "Smartphone");
        assertEquals(response.getProducts().get(1).getProductBrand(), "Apple");
        assertEquals(response.getProducts().get(1).getProductModel(), "iPhone 14");
        assertEquals(response.getProducts().get(0).getProductQuantity(), Integer.valueOf(1));
        //assertEquals(response.getProducts().get(0).getPriceInStock(), new BigDecimal("900.00"));
        assertEquals(response.getProducts().get(0).getCategory(), Category.PHONES);
    }

    @Test
    public void searchProductsOrderingAscending() {
        AddProductRequest request1 = new AddProductRequest("Smartphone", "Apple", "iPhone 14", 1, new BigDecimal("900.00"), Category.PHONES);
        getAddProductService().execute(request1);

        AddProductRequest request2 = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00"), Category.PHONES);
        getAddProductService().execute(request2);

        Ordering ordering = new Ordering("productModel", "ASCENDING");
        SearchProductsRequest request3 = new SearchProductsRequest("Apple", null, ordering);
        SearchProductsResponse response = getSearchProductsService().execute(request3);

        assertEquals(response.getProducts().size(), 2);
        assertEquals(response.getProducts().get(0).getProductName(), "Smartphone");
        assertEquals(response.getProducts().get(0).getProductBrand(), "Apple");
        assertEquals(response.getProducts().get(0).getProductModel(), "iPhone 14");
        assertEquals(response.getProducts().get(0).getProductQuantity(), Integer.valueOf(1));
        //assertEquals(response.getProducts().get(0).getPriceInStock(), new BigDecimal("900.00"));
        assertEquals(response.getProducts().get(0).getCategory(), Category.PHONES);

        assertEquals(response.getProducts().get(0).getProductName(), "Smartphone");
        assertEquals(response.getProducts().get(1).getProductBrand(), "Apple");
        assertEquals(response.getProducts().get(1).getProductModel(), "iPhone 15");
        assertEquals(response.getProducts().get(0).getProductQuantity(), Integer.valueOf(1));
        //assertEquals(response.getProducts().get(0).getPriceInStock(), new BigDecimal("1000.00"));
        assertEquals(response.getProducts().get(0).getCategory(), Category.PHONES);
    }

    @Test
    public void searchProductsOrderingPagingFirstPage() {
        AddProductRequest request1 = new AddProductRequest("Smartphone", "Apple", "iPhone 14", 1, new BigDecimal("900.00"), Category.PHONES);
        getAddProductService().execute(request1);

        AddProductRequest request2 = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00"), Category.PHONES);
        getAddProductService().execute(request2);

        Ordering ordering = new Ordering("productModel", "ASCENDING");
        Paging paging = new Paging(1, 1);
        SearchProductsRequest request3 = new SearchProductsRequest("Apple", null, ordering, paging);
        SearchProductsResponse response = getSearchProductsService().execute(request3);

        assertEquals(response.getProducts().size(), 1);
        assertEquals(response.getProducts().get(0).getProductName(), "Smartphone");
        assertEquals(response.getProducts().get(0).getProductBrand(), "Apple");
        assertEquals(response.getProducts().get(0).getProductModel(), "iPhone 14");
        assertEquals(response.getProducts().get(0).getProductQuantity(), Integer.valueOf(1));
        assertEquals(response.getProducts().get(0).getPriceInStock(), new BigDecimal("900.00"));
        assertEquals(response.getProducts().get(0).getCategory(), Category.PHONES);
    }
    @Test
    public void searchProductsOrderingPagingSecondPage() {
        AddProductRequest request1 = new AddProductRequest("Smartphone", "Apple", "iPhone 14", 1, new BigDecimal("900.00"), Category.PHONES);
        getAddProductService().execute(request1);

        AddProductRequest request2 = new AddProductRequest("Smartphone", "Apple", "iPhone 15", 1, new BigDecimal("1000.00"), Category.PHONES);
        getAddProductService().execute(request2);

        Ordering ordering = new Ordering("productModel", "ASCENDING");
        Paging paging = new Paging(2, 1);
        SearchProductsRequest request3 = new SearchProductsRequest("Apple", null, ordering, paging);
        SearchProductsResponse response = getSearchProductsService().execute(request3);

        assertEquals(response.getProducts().size(), 1);
        assertEquals(response.getProducts().get(0).getProductName(), "Smartphone");
        assertEquals(response.getProducts().get(0).getProductBrand(), "Apple");
        assertEquals(response.getProducts().get(0).getProductModel(), "iPhone 15");
        assertEquals(response.getProducts().get(0).getProductQuantity(), Integer.valueOf(1));
        assertEquals(response.getProducts().get(0).getPriceInStock(), new BigDecimal("1000.00"));
        assertEquals(response.getProducts().get(0).getCategory(), Category.PHONES);

}

    private AddProductService getAddProductService() {
        return appContext.getBean(AddProductService.class);
    }

    private SearchProductsService getSearchProductsService() {
        return appContext.getBean(SearchProductsService.class);
    }

}
