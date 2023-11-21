package avangardteen.java.service;

import avangardteen.java.Client;
import avangardteen.java.UserSizes;
import avangardteen.java.Wheelchair;
import avangardteen.java.dependency_injection.DIComponent;
import avangardteen.java.dependency_injection.DIDependency;
import avangardteen.java.request.ShowDataSizeRequest;
import avangardteen.java.responce.ShowDataSizeResponse;
@DIComponent
public class GetAntropometricDataServis {
@DIDependency UserSizes sizes;

    public ShowDataSizeResponse response (ShowDataSizeRequest request){
        return new ShowDataSizeResponse(sizes);
    }
}

