package lv.javaguru.java2.product.storage.core.domain;

import java.util.Objects;

public class Product {

    private Long id;
    private String productName;

    private String productBrand;

    private String productModel;

    private int productQuantity;


    public Product(String productName, String productBrand, String productModel, int productQuantity) {
        this.productName = productName;
        this.productBrand = productBrand;
        this.productModel = productModel;
        this.productQuantity = productQuantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return getProductQuantity() == product.getProductQuantity() && Objects.equals(getId(), product.getId()) && Objects.equals(getProductName(), product.getProductName()) && Objects.equals(getProductBrand(), product.getProductBrand()) && Objects.equals(getProductModel(), product.getProductModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProductName(), getProductBrand(), getProductModel(), getProductQuantity());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productBrand='" + productBrand + '\'' +
                ", productModel='" + productModel + '\'' +
                ", productQuantity=" + productQuantity +
                '}';
    }
}


