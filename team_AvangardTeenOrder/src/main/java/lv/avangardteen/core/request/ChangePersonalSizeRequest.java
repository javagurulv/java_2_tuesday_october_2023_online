package lv.avangardteen.core.request;

import lv.avangardteen.dto.UserSizes;

public class ChangePersonalSizeRequest {
    public Long id;
    public Integer pelvisWidth; //ширина таза
    public Integer thighLength; //длинна бедра
    public Integer backHeight; //высота спины
    public Integer shinLength; //длинна голени
    public UserSizes userSizes = new UserSizes();

    public ChangePersonalSizeRequest(Long id,
                                     Integer pelvisWidth, Integer thighLength,
                                     Integer backHeight, Integer shinLength
    ) {
        this.id = id;
        this.pelvisWidth = pelvisWidth;
        this.thighLength = thighLength;
        this.backHeight = backHeight;
        this.shinLength = shinLength;

    }

    public UserSizes getUserSizes() {
        return setUserSizes();
    }


    public UserSizes setUserSizes() {

        userSizes.setPelvisWidth(pelvisWidth);
        userSizes.setThighLength(thighLength);
        userSizes.setBackHeight(backHeight);
        userSizes.setShinLength(shinLength);
        return userSizes;
    }


    public Long getId() {
        return id;
    }


}
