package lv.javaguru.java2.cakeConstructor.core.request;

import lv.javaguru.java2.cakeConstructor.core.domain.Cake;

public class AddCakeRequest {

    private String clientLogin;

    public AddCakeRequest (String clientLogin){
        this.clientLogin = clientLogin;
    }

    public String getClientLogin() {
        return clientLogin;
    }
}
