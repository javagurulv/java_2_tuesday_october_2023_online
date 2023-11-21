package avangardteen.java.data;

import avangardteen.java.Client;
import avangardteen.java.dependency_injection.DIComponent;

import java.util.ArrayList;
import java.util.List;
@DIComponent
public class DataUsers {
    List<Client> clients = new ArrayList<>();
    int id=0;

    public List<Client> getClients() {
        return clients;
    }
    public void addUser (Client client){
        id++;
        client.setId(id);
        clients.add(client);
    }
}
