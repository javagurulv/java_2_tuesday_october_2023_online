package lv.avangardteen.core.responce;

import lv.avangardteen.Client;


public class ShowOrderResponse {

    Client client;


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
