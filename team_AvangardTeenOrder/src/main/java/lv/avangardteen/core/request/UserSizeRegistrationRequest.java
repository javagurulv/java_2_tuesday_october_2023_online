package lv.avangardteen.core.request;

import lv.avangardteen.core.domain.UserSizes;

public class UserSizeRegistrationRequest {
    public Integer pelvisWidth; //ширина таза
    public Integer thighLength; //длинна бедра
    public Integer backHeight; //высота спины
    public Integer shinLength; //длинна голени
    public UserSizes userSizes = new UserSizes();

    public UserSizeRegistrationRequest(
                                     Integer pelvisWidth, Integer thighLength,
                                     Integer backHeight, Integer shinLength
    ) {

        this.pelvisWidth = pelvisWidth;
        this.thighLength = thighLength;
        this.backHeight = backHeight;
        this.shinLength = shinLength;

    }

    public UserSizes getUserSizes() {
        return setUserSizes();
    }

    public UserSizes setUserSizes() {
        userSizes.setPelvisWidth(this.pelvisWidth);
        userSizes.setThighLength(this.thighLength);
        userSizes.setBackHeight(this.backHeight);
        userSizes.setShinLength(this.shinLength);
        return userSizes;
    }

}
