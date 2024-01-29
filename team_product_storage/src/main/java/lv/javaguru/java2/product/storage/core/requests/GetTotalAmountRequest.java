package lv.javaguru.java2.product.storage.core.requests;

import java.math.BigDecimal;

public class GetTotalAmountRequest {

    private Long id;

    private BigDecimal totalAmount;


    public GetTotalAmountRequest() { }

    public GetTotalAmountRequest(Long id, BigDecimal totalAmount) {
        this.id = id;
        this.totalAmount = totalAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
