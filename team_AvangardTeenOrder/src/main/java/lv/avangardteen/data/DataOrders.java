package lv.avangardteen.data;

import lv.avangardteen.dependency_injection.DIComponent;
import lv.avangardteen.dto.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
@DIComponent
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
    public boolean deleteUser(Long id) {
        boolean isClientDelete = false;
        Optional<Client> clientToDelete = clients.stream()
                .filter(client -> client.getId() == id)
                .findFirst();
               if(clientToDelete.isPresent()) {
               Client clientToRemove = clientToDelete.get();
               isClientDelete = clients.remove(clientToRemove);
               }
               return isClientDelete;

    }

    @Override
    public Client getClient(Long id) {
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
    public List<Client> findBySurname(String surname) {
        return getClients().stream()
                .filter(client -> client.getNameSurname().equals(surname))
                .collect(Collectors.toList());


    }

    @Override
    public List<Client> findBySurnameAndAddress(String surname, String address) {
        return getClients().stream()
                .filter(client -> client.getNameSurname().equals(surname))
                .filter(client -> client.getUserAddress().equals(address))
                .collect(Collectors.toList());
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
