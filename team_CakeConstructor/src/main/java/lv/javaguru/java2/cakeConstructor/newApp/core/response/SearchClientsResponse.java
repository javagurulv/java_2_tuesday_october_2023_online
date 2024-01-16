package lv.javaguru.java2.cakeConstructor.newApp.core.response;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Client;

import java.util.List;

public class SearchClientsResponse extends CoreResponse {

    private List<Client> clients;

    public SearchClientsResponse(List<Client> clients, List<CoreError> errors) {
        super(errors);
        this.clients = clients;
    }

    public List<Client> getClients() {
        return clients;
    }
}
