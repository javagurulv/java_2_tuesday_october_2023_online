package lv.avangardteen.core.responce;


import lv.avangardteen.core.dto.Order;
import lv.avangardteen.core.dto.UserSizes;
import lv.avangardteen.core.dto.Wheelchair;

import java.util.List;

public class ChangePersonalSizeResponse extends  CoreResponse{
    UserSizes userSizes;
    Wheelchair wheelchair;

    public ChangePersonalSizeResponse(List<CoreError> errors) {
        super(errors);
    }
    public ChangePersonalSizeResponse(UserSizes userSizes, Wheelchair wheelchair) {
        this.userSizes = userSizes;
        this.wheelchair = wheelchair;
    }



    public void setWheelchair(Wheelchair wheelchair) {
        this.wheelchair = wheelchair;
    }



    public void setUserSizes(UserSizes userSizes) {
        this.userSizes = userSizes;
    }
}
