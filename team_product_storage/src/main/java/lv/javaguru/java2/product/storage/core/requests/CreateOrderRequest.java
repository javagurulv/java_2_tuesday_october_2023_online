package lv.javaguru.java2.product.storage.core.requests;

import java.math.BigDecimal;
import java.util.Date;

public class CreateOrderRequest {

    private Long id;
    private Long customerId;
    private Date orderDate;
    private BigDecimal totalAmount;

    public CreateOrderRequest() { }


    public CreateOrderRequest(Long id, Long customerId, Date orderDate, BigDecimal totalAmount) {
        this.id = id;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }

    public Long getId()
    { System.out.println("GET ID"); return id; }



    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
