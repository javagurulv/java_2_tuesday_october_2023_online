package lv.avangardteen.core.responce;

import lv.avangardteen.Client;

import java.util.List;

public class DeleteOrderResponse extends CoreResponse {
    Client client;

    public DeleteOrderResponse(List<CoreError> errors) {
       super(errors);
    }

    public DeleteOrderResponse() {

    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
