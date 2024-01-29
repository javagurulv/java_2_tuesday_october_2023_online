package lv.javaguru.java2.cakeConstructor.newApp.core.requests;

public class CreateCakeRequest {

    private Long id;
    private String cakeName;
    private Double weight;

    public CreateCakeRequest() { }

    public CreateCakeRequest(String cakeName, Double weight) {
        this.cakeName = cakeName;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCakeName() {
        return cakeName;
    }

    public void setCakeName(String cakeName) {
        this.cakeName = cakeName;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
