package lv.avangardteen.core.request;

public class ChangePersonalDateRequest {
    private int id;
    private String nameSurname;
    private String phoneNumber;
    private String userAddress;

    public ChangePersonalDateRequest(int id, String nameSurname, String phoneNumber, String userAddress) {
        this.id = id;
        this.nameSurname = nameSurname;
        this.phoneNumber = phoneNumber;
        this.userAddress = userAddress;
    }


    public int getId() {
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
}
