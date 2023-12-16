package lv.avangardteen.core.responce;

import lv.avangardteen.core.dto.UserSizes;
import lv.avangardteen.core.dto.Wheelchair;

import java.util.List;

public class UserSizeRegistrationResponse extends CoreResponse{
    UserSizes userSizes;
    Wheelchair wheelchair;

    public UserSizeRegistrationResponse(List<CoreError> errors) {
        super(errors);
    }
    public UserSizeRegistrationResponse() {}

    public UserSizes getUserSizes() {
        return userSizes;
    }

    public Wheelchair getWheelchair() {
        return wheelchair;
    }

    public void setWheelchair(Wheelchair wheelchair) {
        this.wheelchair = wheelchair;
    }

    public void setUserSizes(UserSizes userSizes) {
        this.userSizes = userSizes;
    }
}
