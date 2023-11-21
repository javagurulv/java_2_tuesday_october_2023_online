package lv.javaguru.java2.cakeConstructor.newApp.core.requests;

public class AddIngredientRequest {

    private String type;
    private String taste;

    public AddIngredientRequest(String type, String taste) {
        this.type = type;
        this.taste = taste;
    }

    public String getType() {
        return type;
    }

    public String getTaste() {
        return taste;
    }
}
