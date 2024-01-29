package lv.javaguru.java2.product.storage.core.requests;


import java.math.BigDecimal;

public class AddProductToCartRequest {

    private Long id;
    private Long orderId;
    private Long productId;
    private Integer quantity;
    private BigDecimal amount;


    public AddProductToCartRequest() { }

    public AddProductToCartRequest(Long orderId, Long productId, Integer quantity, BigDecimal amount) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


}
