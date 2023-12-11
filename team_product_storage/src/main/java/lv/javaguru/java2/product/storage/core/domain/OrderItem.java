package lv.javaguru.java2.product.storage.core.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class OrderItem {

    private Long id;
    private Order Order;
    private Product product;
    private Integer productQuantity;
    private BigDecimal priceInStock;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return Order;
    }

    public void setOrder(Order order) {
        Order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
        if (!(o instanceof OrderItem orderItem)) return false;
        return Objects.equals(getId(), orderItem.getId()) && Objects.equals(getOrder(), orderItem.getOrder()) && Objects.equals(getProduct(), orderItem.getProduct()) && Objects.equals(getProductQuantity(), orderItem.getProductQuantity()) && Objects.equals(getPriceInStock(), orderItem.getPriceInStock());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOrder(), getProduct(), getProductQuantity(), getPriceInStock());
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", Order=" + Order +
                ", product=" + product +
                ", productQuantity=" + productQuantity +
                ", priceInStock=" + priceInStock +
                '}';
    }
}
