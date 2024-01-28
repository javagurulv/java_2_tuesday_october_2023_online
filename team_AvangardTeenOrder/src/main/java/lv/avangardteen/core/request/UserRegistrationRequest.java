package lv.avangardteen.core.request;

import lv.avangardteen.core.domain.Client;

public class UserRegistrationRequest {
    private String nameSurname;
    private Long personalCode;
    private Long phoneNumber;
    private String userAddress;


    public UserRegistrationRequest(){}

    public UserRegistrationRequest(String nameSurname, Long personalCode, Long phoneNumber, String userAddress) {
        this.nameSurname = nameSurname;
        this.personalCode = personalCode;
        this.phoneNumber = phoneNumber;
        this.userAddress = userAddress;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public Long getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(Long personalCode) {
        this.personalCode = personalCode;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
