package lv.javaguru.java2.product.storage.matchers;

import org.mockito.ArgumentMatcher;

import lv.javaguru.java2.product.storage.core.domain.Product;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductMatcher implements ArgumentMatcher<Product> {

    private String productName;
    private String productBrand;
    private String productModel;
    private Integer productQuantity;
    private BigDecimal price;

    public ProductMatcher(String productName, String productBrand, String productModel, Integer productQuantity, BigDecimal price) {
        this.productName = productName;
        this.productBrand = productBrand;
        this.productModel = productModel;
        this.productQuantity = productQuantity;
        this.price = price;
    }

    @Override
    public boolean matches(Product product) {
        return product.getProductName().equals(productName)
                && product.getProductBrand().equals(productBrand)
                && product.getProductModel().equals(productModel)
                && Objects.equals(product.getProductQuantity(), productQuantity)
                && Objects.equals(product.getPrice(), price);

    }
}
