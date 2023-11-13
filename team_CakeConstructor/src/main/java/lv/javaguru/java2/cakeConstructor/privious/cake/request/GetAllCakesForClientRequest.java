package lv.javaguru.java2.cakeConstructor.privious.cake.request;

public class GetAllCakesForClientRequest {

    private String clientLogin;


    public GetAllCakesForClientRequest (String clientLogin){
        this.clientLogin = clientLogin;
    }
    public String getClientLogin() {
        return clientLogin;
    }
}
