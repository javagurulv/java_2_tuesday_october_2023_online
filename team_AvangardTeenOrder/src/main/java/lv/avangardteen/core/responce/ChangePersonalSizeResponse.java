package lv.avangardteen.core.responce;


import lv.avangardteen.core.domain.UserSizes;
import lv.avangardteen.core.domain.Wheelchair;

import java.util.List;

public class ChangePersonalSizeResponse extends  CoreResponse{
    UserSizes userSizes;
    Wheelchair wheelchair;

    public ChangePersonalSizeResponse(List<CoreError> errors) {
        super(errors);
    }
    public ChangePersonalSizeResponse() {}



    public void setWheelchair(Wheelchair wheelchair) {
        this.wheelchair = wheelchair;
    }

    public UserSizes getUserSizes() {
        return userSizes;
    }

    public Wheelchair getWheelchair() {
        return wheelchair;
    }

    public void setUserSizes(UserSizes userSizes) {
        this.userSizes = userSizes;
    }
}
