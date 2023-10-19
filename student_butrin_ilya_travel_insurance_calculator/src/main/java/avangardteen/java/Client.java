package avangardteen.java;

public class Client {
    private String nameSurname;
    private String phoneNumber;
    private String e_mail;
    private int id;
    Wheelchair wheelchair;
    UserSizes userSizes;
    public Wheelchair getWheelchair() {
        return wheelchair;
    }

    public Client(Wheelchair wheelchair, UserSizes userSizes) {
        this.wheelchair = wheelchair;
        this.userSizes = userSizes;
    }

    public void setWheelchair(Wheelchair wheelchair) {
        this.wheelchair = wheelchair;
    }

    public UserSizes getUserSizes() {
        return userSizes;
    }

    public void setUserSizes(UserSizes userSizes) {
        this.userSizes = userSizes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserEmail() {
        return e_mail;
    }

    public void setUserEmail(String userAddress) {
        this.e_mail = userAddress;
    }
}
