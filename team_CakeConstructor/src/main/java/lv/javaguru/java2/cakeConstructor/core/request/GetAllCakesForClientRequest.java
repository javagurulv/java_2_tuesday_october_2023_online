package lv.javaguru.java2.cakeConstructor.core.request;

public class GetAllCakesForClientRequest {

    private int clientId;


    public GetAllCakesForClientRequest (int clientId){
        this.clientId = clientId;
    }
    public int getClientId() {
        return clientId;
    }
}
