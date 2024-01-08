package avangardteen.java2app.service;

import avangardteen.java2app.CoreError;
import avangardteen.java2app.domen.UserSizes;
import avangardteen.java2app.domen.Wheelchair;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import avangardteen.java2app.request.AddAnthropometricDataRequest;
import avangardteen.java2app.responce.AddAnthropometricDataResponse;
import avangardteen.java2app.service.valigation.AddAntropologDateValigation;

import java.util.List;
@Component
public class AddAtropologDateServis {
  @Autowired UserSizes sizes;
  @Autowired
    Wheelchair wheelchair;
   @Autowired AddAntropologDateValigation valigation;



    public AddAnthropometricDataResponse execute (AddAnthropometricDataRequest request) {
        List<CoreError> errorlist = valigation.errorlist(request);
        if (!errorlist.isEmpty()){
            return new AddAnthropometricDataResponse(errorlist);
        }
       sizes.setBackHeight(request.getBackLength());
        sizes.setPelvisWidth(request.getPelwicWidth());
        sizes.setThighLength(request.getThighLength());
        sizes.setShinLength(request.getShinLength());

        wheelchair.setSeatWidth(sizes.findSeatWidth());
        wheelchair.setSeatWidth(sizes.findSeatDepth());
        wheelchair.setSeatWidth(sizes.findFootrestLength());


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