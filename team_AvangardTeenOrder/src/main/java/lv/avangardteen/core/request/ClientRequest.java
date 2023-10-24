package lv.avangardteen.core.request;


public class ClientRequest {
    private long id;
    String nameSurname;
    String phoneNumber;
    String userAddress;
    int shinLength;
    int backLength;
    int thighLength;
    int pelvisWidth;
    String wheelFront;
    String wheelBack;
    String brakeChoose;
    String armrestChoose;

    public ClientRequest(long id, String nameSurname,
                         String phoneNumber, String userAddress,
                         int shinLength, int backLength, int thighLength,
                         int pelvisWidth, String wheelFront, String wheelBack,
                         String brakeChoose, String armrestChoose) {
        this.id = id;
        this.nameSurname = nameSurname;
        this.phoneNumber = phoneNumber;
        this.userAddress = userAddress;
        this.shinLength = shinLength;
        this.backLength = backLength;
        this.thighLength = thighLength;
        this.pelvisWidth = pelvisWidth;
        this.wheelFront = wheelFront;
        this.wheelBack = wheelBack;
        this.brakeChoose = brakeChoose;
        this.armrestChoose = armrestChoose;
    }

    public long getId() {
        return id;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public String getPhoneNumber() {
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

    public String getWheelFront() {
        return wheelFront;
    }

    public String getWheelBack() {
        return wheelBack;
    }

    public String getBrakeChoose() {
        return brakeChoose;
    }

    public String getArmrestChoose() {
        return armrestChoose;
    }
}
