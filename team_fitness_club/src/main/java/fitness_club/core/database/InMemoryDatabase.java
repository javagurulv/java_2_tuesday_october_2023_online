package fitness_club.core.database;

import java.util.ArrayList;
import java.util.List;

import fitness_club.core.domain.Client;

public class InMemoryDatabase implements Database {

    private Long nextId = 1L;
    private List<Client> clients = new ArrayList<>();

    public void addClient(Client client) {
        client.setId(nextId);
        nextId++;
        clients.add(client);
    }

    public void removeClient(String personalCode) {
        clients.stream()
                .filter(client -> client.getPersonalCode().equals(personalCode))
                .findFirst()
                .ifPresent(client -> clients.remove(client));
    }

    public List<Client> getAllClients() {
        return clients;
    }

    public void saveClient(List<Client> clients) {
    }
}