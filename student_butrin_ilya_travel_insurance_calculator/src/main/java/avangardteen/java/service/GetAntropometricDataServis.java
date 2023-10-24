package avangardteen.java.service;

import avangardteen.java.Client;
import avangardteen.java.UserSizes;
import avangardteen.java.Wheelchair;
import avangardteen.java.request.ShowDataSizeRequest;
import avangardteen.java.responce.ShowDataSizeResponse;

public class GetAntropometricDataServis {
     Client client;

    public GetAntropometricDataServis(Client client) {
        this.client = client;
    }

    public ShowDataSizeResponse response (ShowDataSizeRequest request){
        UserSizes size = client.getUserSizes();
        return new ShowDataSizeResponse(size);
    }
}

