package lv.javaguru.java2.product.storage.core.requests;

public class AddProductRequest {
    private String productName;

    private String productBrand;

    private String productModel;

    private int productQuantity;

    public AddProductRequest(String productName, String productBrand, String productModel, int productQuantity) {
        this.productName = productName;
        this.productBrand = productBrand;
        this.productModel = productModel;
        this.productQuantity = productQuantity;
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

    public int getProductQuantity() { return productQuantity; }
}


