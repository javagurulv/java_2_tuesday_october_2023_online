package lv.avangardteen.core.responce;


import lv.avangardteen.Client;

import java.util.List;

public class ChangePersonalDateResponse extends CoreResponse {
   Client client;

    public ChangePersonalDateResponse(List<CoreError> errors) {
        super(errors);
    }
    public ChangePersonalDateResponse(Client client) {
        this.client = client;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}