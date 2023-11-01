package lv.avangardteen.data;

import lv.avangardteen.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class DataOrders implements Database {
    private Long nextId = 1L;
    List<Client> clients = new ArrayList<>();

    @Override
    public List<Client> getClients() {

        return clients;
    }

    @Override
    public void addUser(Client client) {
        client.setId(nextId);
        nextId++;
        clients.add(client);
    }

    @Override
    public void deleteUser(long id) {
        clients.stream()
                .filter(client -> client.getId() == id)
                .findFirst()
                .ifPresent(client -> clients.remove(client));
    }

    @Override
    public Client getClient(long id) {
        List<Client> clientList = getClients();
        Client clientSearch = null;
        for (Client client : clientList) {
            if (client.getId() == id) {
                clientSearch = client;
            }
        }
        return clientSearch;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataOrders that = (DataOrders) o;
        return Objects.equals(clients, that.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clients);
    }

    @Override
    public String toString() {
        return "DataOrders{" +
                "clients=" + clients +
                '}';
    }
}
