package avangardteen.java2app.responce;

import avangardteen.java2app.UserSizes;

public class ShowDataSizeResponse {
    UserSizes userSizes;

    public ShowDataSizeResponse(UserSizes userSizes) {
        this.userSizes = userSizes;
    }

    public UserSizes getUserSizes() {
        return userSizes;
    }
}
