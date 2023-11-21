package lv.javaguru.java2.cakeConstructor.newApp.core.requests;

public class RemoveIngredientRequest {

    private Long ingredientId;

    public RemoveIngredientRequest(Long ingredientId){
        this.ingredientId = ingredientId;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

}
