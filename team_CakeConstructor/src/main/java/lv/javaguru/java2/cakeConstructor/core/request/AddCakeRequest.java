package lv.javaguru.java2.cakeConstructor.core.request;

import lv.javaguru.java2.cakeConstructor.core.domain.Cake;

public class AddCakeRequest {

    private int clientId;

    public AddCakeRequest (int clientId){
        this.clientId = clientId;
    }

    public int getClientId() {
        return clientId;
    }
}
