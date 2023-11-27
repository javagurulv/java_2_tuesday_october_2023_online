package lv.avangardteen.core.request;


import lv.avangardteen.core.service.WheelchairComponent;
import lv.avangardteen.core.dto.UserSizes;

public class ClientRequest {

    String nameSurname;
    Integer phoneNumber;
    String userAddress;
    Integer shinLength;
    Integer backHeight;
    Integer thighLength;
    Integer pelvisWidth;
    Integer indexWheelFront;
    Integer indexWheelBack;
    Integer indexBrakeChoose;
    Integer indexArmrestChoose;
    private UserSizes userSizes = new UserSizes();
    private WheelchairComponent wheelchairComponent = new WheelchairComponent();


    public ClientRequest(String nameSurname, Integer phoneNumber,
                         String userAddress, Integer shinLength, Integer backHeight,
                         Integer thighLength, Integer pelvisWidth, Integer indexWheelFront,
                         Integer indexWheelBack, Integer indexBrakeChoose, Integer indexArmrestChoose) {
        this.nameSurname = nameSurname;
        this.phoneNumber = phoneNumber;
        this.userAddress = userAddress;
        this.shinLength = shinLength;
        this.backHeight = backHeight;
        this.thighLength = thighLength;
        this.pelvisWidth = pelvisWidth;
        this.indexWheelFront = indexWheelFront;
        this.indexWheelBack = indexWheelBack;
        this.indexBrakeChoose = indexBrakeChoose;
        this.indexArmrestChoose = indexArmrestChoose;
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

    public WheelchairComponent getWheelchairComponent() {
        return setWheelchairComponent();
    }

    public WheelchairComponent setWheelchairComponent() {
        wheelchairComponent.addComponents(indexWheelFront);
        wheelchairComponent.addComponents(indexWheelBack);
        wheelchairComponent.addComponents(indexBrakeChoose);
        wheelchairComponent.addComponents(indexArmrestChoose);
        return wheelchairComponent;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public String getUserAddress() {
        return userAddress;
    }
}
