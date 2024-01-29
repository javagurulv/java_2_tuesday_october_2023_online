package avangardteen.java2app.service;

import avangardteen.java2app.data.DatabaseAtropometric;
import avangardteen.java2app.domen.UserSizes;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import avangardteen.java2app.request.ShowDataSizeRequest;
import avangardteen.java2app.responce.ShowDataSizeResponse;
@Component
public class GetAntropometricDataServis {
@Autowired
DatabaseAtropometric data;
@Autowired
AddAtropologDateServis addService;

    public ShowDataSizeResponse response (ShowDataSizeRequest request){
        data.getAntropologDatedyId(addService.getIdAntropometric());
        return new ShowDataSizeResponse();
    }
}

