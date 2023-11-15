package avangardteen.java.service;

import avangardteen.java.Client;
import avangardteen.java.UserSizes;
import avangardteen.java.Wheelchair;
import avangardteen.java.request.ShowDataSizeRequest;
import avangardteen.java.responce.ShowDataSizeResponse;

public class GetAntropometricDataServis {
UserSizes sizes;

    public GetAntropometricDataServis(UserSizes sizes) {
        this.sizes = sizes;
    }

    public ShowDataSizeResponse response (ShowDataSizeRequest request){
        return new ShowDataSizeResponse(sizes);
    }
}

