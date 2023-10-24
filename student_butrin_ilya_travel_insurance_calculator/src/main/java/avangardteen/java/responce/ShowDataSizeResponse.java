package avangardteen.java.responce;

import avangardteen.java.Client;
import avangardteen.java.UserSizes;
import avangardteen.java.request.ShowDataSizeRequest;

public class ShowDataSizeResponse {
    UserSizes userSizes;

    public ShowDataSizeResponse(UserSizes userSizes) {
        this.userSizes = userSizes;
    }

    public UserSizes getUserSizes() {
        return userSizes;
    }
}
