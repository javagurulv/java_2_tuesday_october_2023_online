package lv.avangardteen.core.responce;

import lv.avangardteen.dto.Client;

import java.util.List;


public class ShowOrderResponse extends CoreResponse {

    Client client;

    public ShowOrderResponse(List<CoreError> errors) {
        super(errors);
    }

    public ShowOrderResponse(Client client) {
        this.client = client;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
