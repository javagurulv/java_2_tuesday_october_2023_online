package avangardteen.java2app.request;

public class AddPersonalDataRequest {

    String firstName;
    String secondName;
    String phoneNumber;
    String eMail;


    public AddPersonalDataRequest(String firstName, String secondName, String phoneNumber, String eMail) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String geteMail() {
        return eMail;
    }
}
