package lv.javaguru.java2.product.storage.core.requests;

public class AddProductRequest {
    private String productName;


    public AddProductRequest(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }
}


