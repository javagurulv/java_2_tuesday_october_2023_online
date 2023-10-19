package avangardteen.java.data;

import avangardteen.java.Client;

import java.util.ArrayList;
import java.util.List;

public class DataUsers {
    List<Client> users = new ArrayList<>();
    int id=0;

    public List<Client> getUsers() {
        return users;
    }
    public void addUser (Client user){
        id++;
        user.setId(id);
        users.add(user);
    }
}
