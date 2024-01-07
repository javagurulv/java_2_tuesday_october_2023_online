package avangardteen.java2app.domen;

public class Client {
    private String firstName;



    private String lastName;
    private String phoneNumber;
    private String e_mail;
    private int id;
    Wheelchair wheelchair;
    UserSizes userSizes;

    public Client() {
    }

    public Wheelchair getWheelchair() {
        return wheelchair;
    }

    public Client(Wheelchair wheelchair, UserSizes userSizes) {
        this.wheelchair = wheelchair;
        this.userSizes = userSizes;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getE_mail() {
        return e_mail;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public void setUserEmail(String userAddress) {
        this.e_mail = userAddress;
    }
}
