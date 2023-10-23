package avangardteen.java.service;

import avangardteen.java.Client;
import avangardteen.java.CoreError;
import avangardteen.java.request.AddAnthropometricDataRequest;
import avangardteen.java.responce.AddAnthropometricDataResponse;
import avangardteen.java.service.valigation.AddAntropologDateValigation;

import java.io.StreamCorruptedException;
import java.util.List;

public class AddAtropologDateServis {
    Client user;
    AddAntropologDateValigation valigation;

    public AddAtropologDateServis(Client user, AddAntropologDateValigation valigation) {
        this.user = user;
        this.valigation = valigation;
    }

    public AddAnthropometricDataResponse execute (AddAnthropometricDataRequest request) {
        List<CoreError> errorlist = valigation.errorlist(request);
        if (!errorlist.isEmpty()){
            return new AddAnthropometricDataResponse(errorlist);
        }
        user.getUserSizes().setBackHeight(request.getBackLength());
        user.getUserSizes().setPelvisWidth(request.getPelwicWidth());
        user.getUserSizes().setThighLength(request.getThighLength());
        user.getUserSizes().setShinLength(request.getShinLength());
        return new AddAnthropometricDataResponse();
    }
    public void setShinLength(int choose) {
        user.getUserSizes().setShinLength(choose);
    }
    public void setPelvis(int choose) {
        user.getUserSizes().setPelvisWidth(choose);
    }
    public void setThighLength(int choose) {
        user.getUserSizes().setThighLength(choose);
    }
    public void setBackLength(int choose) {
        user.getUserSizes().setShinLength(choose);
    }
}