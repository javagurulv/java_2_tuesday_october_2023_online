package lv.javaguru.java2.cakeConstructor.core.cake.request;

public class AddCakeRequest {

    private String clientLogin;

    public AddCakeRequest (String clientLogin){
        this.clientLogin = clientLogin;
    }

    public String getClientLogin() {
        return clientLogin;
    }
}
