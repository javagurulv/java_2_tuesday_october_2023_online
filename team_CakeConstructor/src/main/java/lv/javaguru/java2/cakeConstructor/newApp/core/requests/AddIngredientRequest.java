package lv.javaguru.java2.cakeConstructor.newApp.core.requests;

public class AddIngredientRequest {

    private String type;
    private String taste;

    public AddIngredientRequest() {
    }

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

    public void setType(String type) {
        this.type = type;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }
}
