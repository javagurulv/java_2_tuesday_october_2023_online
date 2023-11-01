package lv.javaguru.java2.product.storage.core.requests;

public class AddProductRequest {
    private String productName;

    private String productBrand;

    private String productModel;

    public AddProductRequest(String productName, String productBrand, String productModel) {
        this.productName = productName;
        this.productBrand = productBrand;
        this.productModel = productModel;
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
}


