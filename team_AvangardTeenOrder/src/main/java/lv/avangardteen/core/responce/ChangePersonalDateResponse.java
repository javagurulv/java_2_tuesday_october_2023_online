package lv.avangardteen.core.responce;


import lv.avangardteen.core.dto.Client;
import lv.avangardteen.core.dto.Order;

import java.util.List;

public class ChangePersonalDateResponse extends CoreResponse {
   private Client client;

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
