package lv.javaguru.java2.product.storage.core.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private Long id;
    private String productName;
    private String productBrand;
    private String productModel;
    private Integer productQuantity;
    private BigDecimal priceInStock;
    private Category category;

    public Product() {
    }

    public Product(String productName, String productBrand, String productModel, Integer productQuantity, BigDecimal priceInStock, Category category) {
        this.productName = productName;
        this.productBrand = productBrand;
        this.productModel = productModel;
        this.productQuantity = productQuantity;
        this.priceInStock = priceInStock;
        this.category = category;
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

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public BigDecimal getPriceInStock() {
        return priceInStock;
    }

    public void setPriceInStock(BigDecimal priceInStock) {
        this.priceInStock = priceInStock;
    }

    public Category getCategory() { return category; }

    public void setCategory(Category category) { this.category = category; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(getId(), product.getId()) && Objects.equals(getProductName(), product.getProductName()) && Objects.equals(getProductBrand(), product.getProductBrand()) && Objects.equals(getProductModel(), product.getProductModel()) && Objects.equals(getProductQuantity(), product.getProductQuantity()) && Objects.equals(getPriceInStock(), product.getPriceInStock()) && getCategory() == product.getCategory();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProductName(), getProductBrand(), getProductModel(), getProductQuantity(), getPriceInStock(), getCategory());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productBrand='" + productBrand + '\'' +
                ", productModel='" + productModel + '\'' +
                ", productQuantity=" + productQuantity +
                ", priceInStock=" + priceInStock +
                ", category=" + category +
                '}';
    }
}


