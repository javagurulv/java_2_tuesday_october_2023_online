package lv.avangardteen.core.responce;

import lv.avangardteen.core.domain.Client;

import java.util.List;

public class UserRegistrationResponse extends CoreResponse{

    private Client userRegistration;


    public UserRegistrationResponse(List<CoreError> errors) {
        super(errors);
    }
    public UserRegistrationResponse(Client userRegistration) {
        this.userRegistration = userRegistration;
    }

    public void setUserRegistration(Client userRegistration) {
        this.userRegistration = userRegistration;
    }

    public Client getUserRegistration() {
        return userRegistration;
    }

}
