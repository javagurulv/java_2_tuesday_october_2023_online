package lv.avangardteen.core.responce;


import lv.avangardteen.dto.Client;

import java.util.List;

public class ChangeComponentResponse extends CoreResponse{
    Client client;

    public ChangeComponentResponse(List<CoreError> errors) {
        super(errors);
    }
    public ChangeComponentResponse(Client client) {
        this.client = client;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
