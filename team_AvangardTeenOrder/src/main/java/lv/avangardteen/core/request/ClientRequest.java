package lv.avangardteen.core.request;


public class ClientRequest {

    String nameSurname;
    int phoneNumber;
    String userAddress;
    int shinLength;
    int backLength;
    int thighLength;
    int pelvisWidth;
    int indexWheelFront;
    int indexWheelBack;
    int indexBrakeChoose;
    int indexArmrestChoose;


    public ClientRequest(String nameSurname, int phoneNumber,
                         String userAddress, int shinLength, int backLength,
                         int thighLength, int pelvisWidth, int indexWheelFront,
                         int indexWheelBack, int indexBrakeChoose, int indexArmrestChoose) {
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public int getShinLength() {
        return shinLength;
    }

    public int getBackLength() {
        return backLength;
    }

    public int getThighLength() {
        return thighLength;
    }

    public int getPelvisWidth() {
        return pelvisWidth;
    }

    public int getIndexWheelFront() {
        return indexWheelFront;
    }

    public int getIndexWheelBack() {
        return indexWheelBack;
    }

    public int getIndexBrakeChoose() {
        return indexBrakeChoose;
    }

    public int getIndexArmrestChoose() {
        return indexArmrestChoose;
    }
}
