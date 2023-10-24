package lv.avangardteen.core.responce;


import lv.avangardteen.Client;

import java.util.List;

public class ChangePersonalSizeResponse extends  CoreResponse{
    Client client;

    public ChangePersonalSizeResponse(List<CoreError> errors) {
        super(errors);
    }
    public ChangePersonalSizeResponse(Client client) {
        this.client = client;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
