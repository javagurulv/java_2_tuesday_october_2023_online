package lv.javaguru.java2.cakeConstructor.newApp.core.requests;


public class AddIngredientToCakeRequest {

    private Long id;
    private Long cakeId;
    private Long ingredientId;
    private Double quantity;

    public AddIngredientToCakeRequest() { }

    public AddIngredientToCakeRequest(Long id, Long cakeId, Long ingredientId, Double quantity) {
        this.id = id;
        this.cakeId = cakeId;
        this.ingredientId = ingredientId;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCakeId() {
        return cakeId;
    }

    public void setCakeId(Long cakeId) {
        this.cakeId = cakeId;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
