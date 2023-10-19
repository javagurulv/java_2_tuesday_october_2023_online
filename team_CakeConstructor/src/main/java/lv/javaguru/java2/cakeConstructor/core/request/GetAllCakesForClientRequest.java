package lv.javaguru.java2.cakeConstructor.core.request;

public class GetAllCakesForClientRequest {

    private String clientLogin;


    public GetAllCakesForClientRequest (String clientLogin){
        this.clientLogin = clientLogin;
    }
    public String getClientLogin() {
        return clientLogin;
    }
}
