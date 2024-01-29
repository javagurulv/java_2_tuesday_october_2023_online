package lv.javaguru.java2.cakeConstructor.newApp.core.requests;

import java.math.BigDecimal;

public class GetWeightRequest {

    private Long id;

    private Double weight;

    public GetWeightRequest() {
    }

    public GetWeightRequest(Long id, Double weight) {
        this.id = id;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
