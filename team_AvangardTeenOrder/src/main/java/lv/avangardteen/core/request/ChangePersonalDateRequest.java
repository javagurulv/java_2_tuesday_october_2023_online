package lv.avangardteen.core.request;

import lv.avangardteen.core.domain.Client;

public class ChangePersonalDateRequest {
    private Long id;
    private String nameSurname;
    private Long personalCode;
    private Long phoneNumber;
    private String userAddress;
    Client userRegistration = new Client();

    public ChangePersonalDateRequest(Long id, String nameSurname, Long personalCode, Long phoneNumber, String userAddress) {
        this.id = id;
        this.nameSurname = nameSurname;
        this.personalCode = personalCode;
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
        userRegistration.setPersonalCode(personalCode);
        userRegistration.setPhone(phoneNumber);
        userRegistration.setAddress(userAddress);
        return userRegistration;
    }
}
