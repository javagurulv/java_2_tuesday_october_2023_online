package lv.javaguru.java2.cakeConstructor.newApp.core.requests;

import java.util.Date;

public class CreateOrderRequest {

    private Long id;
    private Long clientId;
    private Long cakeId;
    private Date orderDate;


    public CreateOrderRequest() { }

    public CreateOrderRequest(Long id, Long clientId, Long cakeId, Date orderDate) {
        this.id = id;
        this.clientId = clientId;
        this.cakeId = cakeId;
        this.orderDate = orderDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getCakeId() {
        return cakeId;
    }

    public void setCakeId(Long cakeId) {
        this.cakeId = cakeId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
