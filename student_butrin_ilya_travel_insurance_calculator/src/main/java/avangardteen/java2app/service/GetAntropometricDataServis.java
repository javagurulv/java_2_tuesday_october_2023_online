package avangardteen.java2app.service;

import avangardteen.java2app.domen.UserSizes;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import avangardteen.java2app.request.ShowDataSizeRequest;
import avangardteen.java2app.responce.ShowDataSizeResponse;
@Component
public class GetAntropometricDataServis {
@Autowired UserSizes sizes;

    public ShowDataSizeResponse response (ShowDataSizeRequest request){
        return new ShowDataSizeResponse(sizes);
    }
}

