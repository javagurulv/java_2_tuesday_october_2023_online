package lv.avangardteen.core.responce;

import lv.avangardteen.core.domain.Client;

import java.util.List;

public class GetClientResponse extends CoreResponse{

    private Client client;

    public GetClientResponse(List<CoreError> errors) {
        super(errors);
    }

    public GetClientResponse(Client client) {
        this.client = client;
    }
    public GetClientResponse(){}

    public Client getClient() {
        return client;
    }
}
