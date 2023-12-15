package lv.javaguru.java2.product.storage.core.domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Objects;

@Entity
@Table(name="products")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="product_name")
    private String productName;
    @Column(name="product_brand")
    private String productBrand;
    @Column(name="product_model")
    private String productModel;
    @Column(name="product_quantity")
    private Integer productQuantity;
    @Column(name="price_in_stock")
    private BigDecimal priceInStock;


    public Product() {
    }

    public Product(String productName, String productBrand, String productModel, Integer productQuantity, BigDecimal priceInStock) {
        this.productName = productName;
        this.productBrand = productBrand;
        this.productModel = productModel;
        this.productQuantity = productQuantity;
        this.priceInStock = priceInStock;
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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(getId(), product.getId()) && Objects.equals(getProductName(), product.getProductName()) && Objects.equals(getProductBrand(), product.getProductBrand()) && Objects.equals(getProductModel(), product.getProductModel()) && Objects.equals(getProductQuantity(), product.getProductQuantity()) && Objects.equals(getPriceInStock(), product.getPriceInStock());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProductName(), getProductBrand(), getProductModel(), getProductQuantity(), getPriceInStock());
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
                '}';
    }

}


