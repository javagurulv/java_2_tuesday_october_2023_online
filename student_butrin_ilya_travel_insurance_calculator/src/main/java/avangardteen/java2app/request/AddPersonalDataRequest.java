package avangardteen.java2app.request;

public class AddPersonalDataRequest {

    String nameSurname;
    String phoneNumber;
    String eMail;

    public AddPersonalDataRequest(String nameSurname, String phoneNumber, String eMail) {
        this.nameSurname = nameSurname;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String geteMail() {
        return eMail;
    }
}
