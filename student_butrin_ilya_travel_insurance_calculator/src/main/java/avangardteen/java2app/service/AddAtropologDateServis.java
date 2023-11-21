package avangardteen.java2app.service;

import avangardteen.java2app.CoreError;
import avangardteen.java2app.UserSizes;
import avangardteen.java2app.dependency_injection.DIComponent;
import avangardteen.java2app.dependency_injection.DIDependency;
import avangardteen.java2app.request.AddAnthropometricDataRequest;
import avangardteen.java2app.responce.AddAnthropometricDataResponse;
import avangardteen.java2app.service.valigation.AddAntropologDateValigation;

import java.util.List;
@DIComponent
public class AddAtropologDateServis {
  @DIDependency UserSizes sizes;
   @DIDependency AddAntropologDateValigation valigation;


    public AddAnthropometricDataResponse execute (AddAnthropometricDataRequest request) {
        List<CoreError> errorlist = valigation.errorlist(request);
        if (!errorlist.isEmpty()){
            return new AddAnthropometricDataResponse(errorlist);
        }
       sizes.setBackHeight(request.getBackLength());
        sizes.setPelvisWidth(request.getPelwicWidth());
        sizes.setThighLength(request.getThighLength());
        sizes.setShinLength(request.getShinLength());
        return new AddAnthropometricDataResponse();
    }
    public void setShinLength(int choose) {
        sizes.setShinLength(choose);
    }
    public void setPelvis(int choose) {
        sizes.setPelvisWidth(choose);
    }
    public void setThighLength(int choose) {
        sizes.setThighLength(choose);
    }
    public void setBackLength(int choose) {
        sizes.setShinLength(choose);
    }
}