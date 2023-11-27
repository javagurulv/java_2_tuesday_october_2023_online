package avangardteen.java2app.data;

import avangardteen.java2app.Client;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
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
