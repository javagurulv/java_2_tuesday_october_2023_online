package lv.javaguru.java2.product.storage.core.requests;

import java.math.BigDecimal;

public class AddProductRequest {
    private String productName;

    private String productBrand;

    private String productModel;

    private Integer productQuantity;

    private BigDecimal price;

    public AddProductRequest() {
    }

    public AddProductRequest(String productName, String productBrand, String productModel, Integer productQuantity, BigDecimal price) {
        this.productName = productName;
        this.productBrand = productBrand;
        this.productModel = productModel;
        this.productQuantity = productQuantity;
        this.price = price;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}


