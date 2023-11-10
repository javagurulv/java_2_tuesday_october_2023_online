package lv.javaguru.java2.product.storage.matchers;

import org.mockito.ArgumentMatcher;

import lv.javaguru.java2.product.storage.core.domain.Product;

public class ProductMatcher implements ArgumentMatcher<Product> {

    private String productName;
    private String productBrand;
    private String productModel;

    public ProductMatcher(String productName, String productBrand, String productModel) {
        this.productName = productName;
        this.productBrand = productBrand;
        this.productModel = productModel;
    }

    @Override
    public boolean matches(Product product) {
        return product.getProductName().equals(productName)
                && product.getProductBrand().equals(productBrand)
                && product.getProductModel().equals(productModel);
    }
}
