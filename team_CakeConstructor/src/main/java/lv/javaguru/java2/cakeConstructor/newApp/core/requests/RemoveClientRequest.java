package lv.javaguru.java2.cakeConstructor.newApp.core.requests;

public class RemoveClientRequest {

    private Long clientIdToRemove;

    public RemoveClientRequest(Long clientIdToRemove) {
        this.clientIdToRemove = clientIdToRemove;
    }

    public Long getClientIdToRemove() {
        return clientIdToRemove;
    }
}
