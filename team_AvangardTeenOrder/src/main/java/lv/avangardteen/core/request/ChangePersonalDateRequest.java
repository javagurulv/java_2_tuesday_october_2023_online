package lv.avangardteen.core.request;

import lv.avangardteen.core.dto.Client;

public class ChangePersonalDateRequest {
    private Long id;
    private String nameSurname;
    private Long phoneNumber;
    private String userAddress;
    Client userRegistration = new Client();

    public ChangePersonalDateRequest(Long id, String nameSurname, Long phoneNumber, String userAddress) {
        this.id = id;
        this.nameSurname = nameSurname;
        this.phoneNumber = phoneNumber;
        this.userAddress = userAddress;
    }


    public Long getId() {
        return id;
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
