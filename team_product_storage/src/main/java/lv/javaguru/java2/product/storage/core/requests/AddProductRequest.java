package lv.javaguru.java2.product.storage.core.requests;

import lv.javaguru.java2.product.storage.core.domain.Category;

import java.math.BigDecimal;

public class AddProductRequest {
    private String productName;

    private String productBrand;

    private String productModel;

    private Integer productQuantity;

    private BigDecimal priceInStock;

    private Category category;

    public AddProductRequest(String productName, String productBrand, String productModel, Integer productQuantity, BigDecimal priceInStock, Category category) {
        this.productName = productName;
        this.productBrand = productBrand;
        this.productModel = productModel;
        this.productQuantity = productQuantity;
        this.priceInStock = priceInStock;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public String getProductModel() {
        return productModel;
    }

    public Integer getProductQuantity() { return productQuantity; }

    public BigDecimal getPriceInStock() {
        return priceInStock;
    }

    public Category getCategory() { return category; }
}


