package avangardteen.java2app.service;

import avangardteen.java2app.UserSizes;
import avangardteen.java2app.dependency_injection.DIComponent;
import avangardteen.java2app.dependency_injection.DIDependency;
import avangardteen.java2app.request.ShowDataSizeRequest;
import avangardteen.java2app.responce.ShowDataSizeResponse;
@DIComponent
public class GetAntropometricDataServis {
@DIDependency UserSizes sizes;

    public ShowDataSizeResponse response (ShowDataSizeRequest request){
        return new ShowDataSizeResponse(sizes);
    }
}

