public class UserData {
    private String nameSurname;
    private String phoneNumber;
    private String userAddress;

    public UserData(String nameSurname, String phoneNumber, String userAddress) {
        this.nameSurname = nameSurname;
        this.phoneNumber = phoneNumber;
        this.userAddress = userAddress;
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

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
