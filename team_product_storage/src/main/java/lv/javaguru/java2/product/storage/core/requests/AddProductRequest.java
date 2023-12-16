package lv.javaguru.java2.product.storage.core.requests;

import java.math.BigDecimal;

public class AddProductRequest {
    private String productName;

    private String productBrand;

    private String productModel;

    private Integer productQuantity;

    private BigDecimal priceInStock;


    public AddProductRequest(String productName, String productBrand, String productModel, Integer productQuantity, BigDecimal priceInStock) {
        this.productName = productName;
        this.productBrand = productBrand;
        this.productModel = productModel;
        this.productQuantity = productQuantity;
        this.priceInStock = priceInStock;
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

}


