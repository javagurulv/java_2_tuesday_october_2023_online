package avangardTeen.services;

import avangardTeen.domain.UserData;

public class AddPhoneNumberService {

    private UserData userData;

    public AddPhoneNumberService(UserData userData) {
        this.userData = userData;
    }

    public void addPhoneNumber (String phoneNumber){
        userData.setPhoneNumber(phoneNumber);

    }


}
