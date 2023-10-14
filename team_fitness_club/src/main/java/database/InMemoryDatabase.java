package database;

import java.util.ArrayList;
import java.util.List;
import domain.Client;

public class InMemoryDatabase implements Database {

    private Long nextId = 1L;
    private List<Client> clients = new ArrayList<>();

    public void addClient(Client client) {
        client.setId(nextId);
        nextId++;
        clients.add(client);
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }

    public List<Client> getAllClients() {
        return clients;
    }

    public void saveClient(List<Client> clients){

    }
}
