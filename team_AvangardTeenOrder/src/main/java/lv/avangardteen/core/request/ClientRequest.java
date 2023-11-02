package lv.avangardteen.core.request;


public class ClientRequest {

    String nameSurname;
    Integer phoneNumber;
    String userAddress;
    Integer shinLength;
    Integer backLength;
    Integer thighLength;
    Integer pelvisWidth;
    Integer indexWheelFront;
    Integer indexWheelBack;
    Integer indexBrakeChoose;
    Integer indexArmrestChoose;


    public ClientRequest(String nameSurname, Integer phoneNumber,
                         String userAddress, Integer shinLength, Integer backLength,
                         Integer thighLength, Integer pelvisWidth, Integer indexWheelFront,
                         Integer indexWheelBack, Integer indexBrakeChoose, Integer indexArmrestChoose) {
        this.nameSurname = nameSurname;
        this.phoneNumber = phoneNumber;
        this.userAddress = userAddress;
        this.shinLength = shinLength;
        this.backLength = backLength;
        this.thighLength = thighLength;
        this.pelvisWidth = pelvisWidth;
        this.indexWheelFront = indexWheelFront;
        this.indexWheelBack = indexWheelBack;
        this.indexBrakeChoose = indexBrakeChoose;
        this.indexArmrestChoose = indexArmrestChoose;
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

    public Integer getShinLength() {
        return shinLength;
    }

    public Integer getBackLength() {
        return backLength;
    }

    public Integer getThighLength() {
        return thighLength;
    }

    public Integer getPelvisWidth() {
        return pelvisWidth;
    }

    public Integer getIndexWheelFront() {
        return indexWheelFront;
    }

    public Integer getIndexWheelBack() {
        return indexWheelBack;
    }

    public Integer getIndexBrakeChoose() {
        return indexBrakeChoose;
    }

    public Integer getIndexArmrestChoose() {
        return indexArmrestChoose;
    }
}
