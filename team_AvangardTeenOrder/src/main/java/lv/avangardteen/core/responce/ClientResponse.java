package lv.avangardteen.core.responce;

import lv.avangardteen.core.dto.Client;

import java.util.List;

public class ClientResponse extends CoreResponse{

    Client client;

    public ClientResponse(List<CoreError> errors) {
        super(errors);
    }
    public ClientResponse(Client client) {
        this.client = client;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
