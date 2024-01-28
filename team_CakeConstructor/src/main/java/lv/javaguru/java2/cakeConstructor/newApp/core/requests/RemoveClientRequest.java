package lv.javaguru.java2.cakeConstructor.newApp.core.requests;

public class RemoveClientRequest {

    private Long clientId;

    public RemoveClientRequest(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }
}
