package lv.avangardteen.core.request;

import lv.avangardteen.core.dto.Client;

public class UserRegistrationRequest {
    private String nameSurname;
    private Long phoneNumber;
    private String userAddress;
    Client userRegistration = new Client();

    public UserRegistrationRequest(String nameSurname, Long phoneNumber, String userAddress) {
        this.nameSurname = nameSurname;
        this.phoneNumber = phoneNumber;
        this.userAddress = userAddress;
    }


    public Client getUserRegistration() {
        return setUserRegistration();
    }

    public Client setUserRegistration() {
        userRegistration.setNameSurname(nameSurname);
        userRegistration.setPhoneNumber(phoneNumber);
        userRegistration.setUserAddress(userAddress);
        return userRegistration;
    }
}
