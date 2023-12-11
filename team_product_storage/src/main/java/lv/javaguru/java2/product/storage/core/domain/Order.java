package lv.javaguru.java2.product.storage.core.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Order {

    private Long id;
    private Customer customer;
    private Date orderDate;
    private BigDecimal totalPriceInStock;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalPriceInStock() {
        return totalPriceInStock;
    }

    public void setTotalPriceInStock(BigDecimal totalPriceInStock) {
        this.totalPriceInStock = totalPriceInStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return Objects.equals(getId(), order.getId()) && Objects.equals(getCustomer(), order.getCustomer()) && Objects.equals(getOrderDate(), order.getOrderDate()) && Objects.equals(getTotalPriceInStock(), order.getTotalPriceInStock());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCustomer(), getOrderDate(), getTotalPriceInStock());
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", orderDate=" + orderDate +
                ", TotalPrice=" + totalPriceInStock +
                '}';
    }
}
