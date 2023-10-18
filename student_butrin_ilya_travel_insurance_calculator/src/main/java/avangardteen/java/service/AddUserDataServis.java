package avangardteen.java.service;

import avangardteen.java.data.DataUsers;
import avangardteen.java.Client;

public class AddUserDataServis {
    Client user;
    DataUsers data;


    public AddUserDataServis(Client user, DataUsers data) {
        this.user = user;
        this.data = data;
    }

    public void addUzer (String name, String phone, String email){
        user.setUserEmail(email);
        user.setNameSurname(name);
        user.setPhoneNumber(phone);
        data.addUser(user);
    }
}
