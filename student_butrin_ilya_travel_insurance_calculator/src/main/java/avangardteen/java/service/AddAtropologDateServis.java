package avangardteen.java.service;

import avangardteen.java.Client;
import avangardteen.java.CoreError;
import avangardteen.java.UserSizes;
import avangardteen.java.request.AddAnthropometricDataRequest;
import avangardteen.java.responce.AddAnthropometricDataResponse;
import avangardteen.java.service.valigation.AddAntropologDateValigation;

import java.io.StreamCorruptedException;
import java.util.List;

public class AddAtropologDateServis {
    UserSizes sizes;
    AddAntropologDateValigation valigation;

    public AddAtropologDateServis(UserSizes sizes, AddAntropologDateValigation valigation) {
        this.sizes = sizes;
        this.valigation = valigation;
    }

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